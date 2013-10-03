package org.objectium.features

import java.io.File
import org.objectium.features.*

Feature: Configure Eclipse With Code Quality Plugins

As a PO I want to configure check style, PMD, Code cleanup and Code formatter in eclipse IDE and create documentation for it so that other contributors of the project can follow. It's important to ensure that all code committed to Objectium Project follows a pre-defined standard and adheer to certain rules.

It is expected from contributers to configure their Eclipse environment with the instruction given below

Also, we assume that you have downloaded and installed Eclipse IDE from [eclispe.org](http://www.eclipse.org/Downloads).

Background:
	var String currentPath = new File(".").getAbsolutePath();
	var String localPath = "/objectium-test-and-documentation/.";
	var String rootFolderPath = currentPath.replace(localPath,"");
	var String projectFolder;
	var String resourcesFolder;
Scenario: Ensure the build-tools project exists and the files required to configure Eclipse is available
	
	Given "build-tools" Project is available
		projectFolder = rootFolderPath+"/"+args.first.toString;
		new File(rootFolderPath).exists => true
	Then the files "checkstyle.xml", "pmd.xml", "code_cleanup.xml" and "code_formatter.xml" should be available in the "src/main/resources/configurations" folder 	witin the build-tools project root.
		resourcesFolder = projectFolder+"/"+args.fifth.toString;
		new File(resourcesFolder).exists should be true
		new File(resourcesFolder+"/"+args.first.toString).exists should be true
		new File(resourcesFolder+"/"+args.second.toString).exists should be true
		new File(resourcesFolder+"/"+args.third.toString).exists should be true
		new File(resourcesFolder+"/"+args.forth.toString).exists should be true

Scenario: Configure Eclipse with checkstyle
	
	When "checkstyle.xml" is available in "build-tools" project "src/main/resources/configurations" path
		projectFolder = rootFolderPath+"/"+args.second.toString;
		resourcesFolder = projectFolder+"/"+args.third.toString;
		new File(resourcesFolder+"/"+args.first.toString).exists should be true
		
	Then we can configure the checkstyle plugin in Eclipse IDE by following the steps given below
		'''
			- Open your Eclipse IDE
			- Goto Help->Install new software
			- The "Install" dialog will appear.
			- In the "Work With" input box enter "http://eclipse-cs.sourceforge.net/update" and press ENTER
			- Select "Checkstyle" from the presented list and press Next
			- Installation process will prompt you when it require confirmation; just follow the process
			- Goto Windows->Prefernces
			- Under the categories you see in the left hand side, select Checkstyle; You will see the checkstyle configurations on the right hand pane of the preference window.
			- Select "New" button to select a new checkstyle ruleset; "Check configuration properties" window will popup
			- Under the "Type" combo box select "External Confgiruations"
			- Select the "Browse" button to select the "checkstyle.xml" configuration file from the "build-tools" project
			- Type "Objectium" in the "Name" text box and press "OK"
			- You will see a new entry for the "Objectium" configuratins in the Checkstyle configuration panel.
			- Press "Set as Default" button to set the "Objectium" configurations as the default ruleset
			- Now press OK button; You will be prompted to confirm a re-build of the workspace since the PMD ruleset has changed
			
		'''

Scenario: Configure Eclipse with PMD
	When "pmd.xml" is available in "build-tools" project "src/main/resources/configurations" path
	Then we can configure the PMD plugin in Eclipse IDE by following the steps given below
		'''
			- Open your Eclipse IDE
			- Goto Help->Install new software
			- The "Install" dialog will appear.
			- In the "Work With" input box enter "http://pmd.sourceforge.net/eclipse/" and press ENTER
			- Select "Checkstyle" from the presented list and press Next
			- Installation process will prompt you when it require confirmation; just follow the process.
			- Goto Windows->Preferences 
			- Under the categories you see in the left hand side, select PMD->Rules Configurations; You will see the rules configurations on the right hand pane of the preference window.
			- Click on the ruleset table in the right hand side and press "CTRL+A" or "Command+A" to select all the existing rules and press the "X" (Delete) button from the right hand side control button set.
			- All the rules will be deleted
			- Now press on the "Import Rules" icon from the right handside control button set; A new rule import window will popup
			- Press the "Browse" button and slect the path to "pmd.xml" file under the "build-tools" project
			- All the rules will be imported
			- Now press OK button; You will be prompted to confirm a re-build of the workspace since the PMD ruleset has changed
			
			
		'''

Scenario: Configure Eclipse with Objectium Code Ceanup strategy
	/*
	 * It's important to ensure that all developers of Objectium use the same code cleanup mechanism. 
	 * You can use te code_cleanup.xml available with the build-tools project to configure your local Eclipse environment.
	 */
	 
	 When "code_cleanup.xml" is available in "build-tools" project "src/main/resources/configurations" path
	 Then we can configure the eclipse Java code cleanup by following the steps given below
		 '''
		 	- Open your Eclipse IDE
		 	- Goto Windows->Preferences
		 	- Under the categories you see in the left hand side, select Java->Code Style->Clean Up; You will see the code cleanup configurations on the right hand pane of the preference window.
		 	- click the "Import" button
		 	- Select the folder path to code_cleanup.xml under "build-tools"
		 	- All the rules defined in the xml will be important and it will be set as the default code cleanup ruleset.
		 	- Now press "Apply" and "OK" buttons to confirm your selection.
		 '''
Scenario: Configure Eclipse with Objectium Code Format strategy
	/*
	 * Code formating is another important aspect that ensures that every one follows the standard coding standard.
	 * Objectium Code formatting stratagy must be followed by all developers.
	 */
	 
	 When "code_formatter.xml" is available in "build-tools" project "src/main/resources/configurations" path
	 Then we  can configure the eclipse java code formatting by following the steps given below
		 '''
		 	- Open your Eclipse IDE
		 	- Goto Windows->Preferences
		 	- Under the categories you see in the left hand side, select Java->Code Style->Formatter; You will see the code cleanup configurations on the right hand pane of the preference window.
		 	- click the "Import" button
		 	- Select the folder path to code_formatter.xml under "build-tools"
		 	- All the rules defined in the xml will be important and it will be set as the default code formatter ruleset.
		 	- Now press "Apply" and "OK" buttons to confirm your selection.
		 '''