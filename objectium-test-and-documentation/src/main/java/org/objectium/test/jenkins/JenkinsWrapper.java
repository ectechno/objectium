/*
The MIT License (MIT)

Copyright (c) 2013 Suren Rodrigo, 99X Technology (Pvt) Ltd.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */

package org.objectium.test.jenkins;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Suren Rodrigo
 * Basic Jenkins Wrapper that is used only to obtain simple information from the CI Environment. This is not a mandatory class and will not be maintained
 * under the Objectium Proect.
 *
 */
public class JenkinsWrapper {

    private static final int THREAD_SLEEP_TIME = 5000;
    private static final int HTTP_REPONSE_REDIRECTIONS = 399;
    private static final int HTTP_RESPONSE_OK = 200;
    private static final int TIME_OUT = 10000;
    private URL jenkinsUrl = null;
    private Document jenkinsDoc = null;
    private DocumentBuilder builder = null;
    private String jenkinsUrlString = null;

    /**
     * @throws ParserConfigurationException
     * Main Constructor; This will always be initialized as a concrete class, we won't be using this for the Objectium project operations.
     */
    public JenkinsWrapper() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
    }

    /**
     *      * 
     * Set the Jenkins URL we want to connect and also create a URL representation and String path
     * @param url - URL of the jenkins server
     * @throws SAXException - 
     * @throws IOException - 
     * @throws InterruptedException - 
     */
    public void setUrl(String url) throws SAXException, IOException, InterruptedException {
        char lastCharacter = url.charAt(url.length() - 1);
        jenkinsUrlString = (lastCharacter == '/') ? url + "api/xml" : url + "/api/xml";
        jenkinsUrl = (jenkinsUrl == null) ? new URL(jenkinsUrlString) : jenkinsUrl;
    }

    /**
     * Initialize the XML Document
     * @throws SAXException
     * @throws IOException
     * @throws InterruptedException
     */
    private void initializeJenkinsXmlApi() throws SAXException, IOException, InterruptedException {
        if (jenkinsDoc == null) {
            Thread.sleep(THREAD_SLEEP_TIME);
            jenkinsDoc = builder.parse(jenkinsUrlString);
            jenkinsDoc.getDocumentElement().normalize();
        }
    }

    /**
     * @return - whether the Jenkins server is up and running
     */
    public boolean isAvailable() {
        HttpURLConnection connection = null;
        try {
            connection = getJenkinsConnection();
            int responseCode = connection.getResponseCode();
            return (HTTP_RESPONSE_OK <= responseCode && responseCode <= HTTP_REPONSE_REDIRECTIONS);
        } catch (IOException e) {
            return false;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private HttpURLConnection getJenkinsConnection() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) jenkinsUrl.openConnection();
        connection.setConnectTimeout(TIME_OUT);
        connection.setReadTimeout(TIME_OUT);
        connection.setRequestMethod("HEAD");
        return connection;
    }

   
    /**
     * @param jobName - name of the Jenkins Job we want to check
     * @return - whether the jenkins job is configured or not, returns true if configured
     * @throws SAXException - XML sax parser exceptions
     * @throws IOException - XML File IO Exceptions
     * @throws InterruptedException - Thread exceptions
     */
    public boolean isJobConfigured(String jobName) throws SAXException, IOException, InterruptedException {
        initializeJenkinsXmlApi();
        NodeList jobList = jenkinsDoc.getElementsByTagName("job");
        for (int i = 0; i < jobList.getLength(); i++) {
            Node jobNode = jobList.item(i);
            if (jobNode.getNodeType() != Node.ELEMENT_NODE)
                continue;

            Element jobElement = (Element) jobNode;
            NodeList nameList = jobElement.getElementsByTagName("name");
            for (int j = 0; j < nameList.getLength(); j++) {
                Element nameElement = (Element) nameList.item(j);
                if (nameElement.getChildNodes().item(0).getNodeValue().equals(jobName))
                    return true;
            }
        }
        return false;
    }
}
