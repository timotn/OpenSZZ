package com.SZZ.app;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.SZZ.jiraAnalyser.Application;
import com.SZZ.jiraAnalyser.git.JiraRetriever;

public class SZZApplication {
	
	  /* Get actual class name to be printed on */
	static Logger log = Logger.getLogger(SZZApplication.class.getName());
	public static final String DEFAULT_BUG_TRACKER = "https://issues.apache.org/jira/sr/jira.issueviews:searchrequest-xml/temp/SearchRequest.xml";

	

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Welcome to SZZ Calculation script.");
			System.out.println("Here a guide how to use the script");
			System.out.println("szz.jar -d jiraUrl");
			System.out.println("The script saves the file faults.csv containing the issues reported in Jira");
			System.out.println("szz.jar -l gitRepositoryPath");
			System.out.println(
					"This script saves the file gitlog.csv containing the parsed gitlog with all the information needed to execute szz");
			System.out.println("szz.jar -m gitRepositoryPath");
			System.out.println(
					"the script takes in input the files generated before (faults.csv and gitlog.csv) and generate the final result in the file FaultInducingCommits.csv");
			System.out.println("szz.jar -all githubUrl, jiraUrl => all steps together");
		} else {
			switch (args[0]) {
			case "-d":
				JiraRetriever jr = new JiraRetriever(DEFAULT_BUG_TRACKER, log, args[1]);
				jr.printIssues();
				jr.combineToOneFile();
				break;
			case "-l":
				break;
			case "-all":
				break;
			default:
				System.out.println("Commands are not in the right form! Please retry!");
				break;

			}
		}

	}
}
