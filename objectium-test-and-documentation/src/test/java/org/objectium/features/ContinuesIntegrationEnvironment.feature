package org.objectium.features

import org.objectium.test.jenkins.*
import org.objectium.test.jenkins.JenkinsWrapper

Feature: Setup Continues Integration Environment

Continues Integration is an essential part of project Obectium. It ensures the helthy existance of all source code constructs, business objectives and proect goals. It creats an environment where each feature and specification which are written accordance with the project objectives and goals are executed after every commit from developers. 

This also works as a platform to obtain quick feedback on the source code integrations that will happen continuesly when developers are committing code to the repository.

Developers are encouraged to setup their own local jenkins environments to ensure that work they do are accordance with the provided specifications. *It's manadatory for the developers to ensure their work is well integrated with the existing features, before they send pull requests they need to make sure every thing is working correctly. Having a Jenkins environment locally can help them to do this.*

Background: We will consider te following scenarios to ensure Continues Integration environment is setup correctly.
	JenkinsWrapper jenkins = new JenkinsWrapper();
	
Scenario: Continues integration environment is up and running
	Given the Jenkins CI enviornment URL is "http://localhost:8080"
		 jenkins.setUrl(args.first.toString);
	Then we should be able to access it via the URL
		 jenkins.isAvailable() should be true;

Scenario: Continues Integration Job for Main Applicaton Build is available
	When CI enviornment is up and running on "http://localhost:8080"
		jenkins.setUrl(args.first.toString);
		jenkins.isAvailable() should be true;
	Then There should be a job named "Main_Application_Build"
		jenkins.isJobConfigured(args.first.toString) should be true;

Scenario: Continues Integratoin job for Test and Deployment is available
	When CI enviornment is up and running on "http://localhost:8080"
	Then There should be a job named "Objectium_Test_And_Deploy"