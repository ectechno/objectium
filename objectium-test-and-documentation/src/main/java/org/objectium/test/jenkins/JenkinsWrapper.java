package org.objectium.test.jenkins;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JenkinsWrapper {

    private static final int TIME_OUT = 10000;
    private URL jenkinsUrl;
    private String jenkinsUrlString;
    private Document jenkinsDoc;

    public void setUrl(String url) throws ParserConfigurationException, SAXException, IOException {
        char lastCharacter = url.charAt(url.length() - 1);
        jenkinsUrlString = (lastCharacter == '/') ? url + "api/xml" : url + "/api/xml";
        jenkinsUrl = new URL(jenkinsUrlString);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        jenkinsDoc = builder.parse(jenkinsUrlString);
        jenkinsDoc = builder.parse(jenkinsUrlString);
        jenkinsDoc.getDocumentElement().normalize();
    }

    public boolean isAvailable() {
        HttpURLConnection connection = null;
        try {
            connection = getJenkinsConnection();
            int responseCode = connection.getResponseCode();
            return (200 <= responseCode && responseCode <= 399);
        } catch (IOException e) {
            return false;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private HttpURLConnection getJenkinsConnection() throws IOException, ProtocolException {
        HttpURLConnection connection = (HttpURLConnection) jenkinsUrl.openConnection();
        connection.setConnectTimeout(TIME_OUT);
        connection.setReadTimeout(TIME_OUT);
        connection.setRequestMethod("HEAD");
        return connection;
    }

    public boolean isJobConfigured(String jobName){
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
