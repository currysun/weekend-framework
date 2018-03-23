package com.test.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class NewReport implements IReporter {

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		List<ITestResult> list=new ArrayList<ITestResult>();
		for(ISuite suite:suites) {
			Map<String,ISuiteResult> suiteResults=suite.getResults();
			for(ISuiteResult suiteResult:suiteResults.values()) {
				ITestContext testContext = suiteResult.getTestContext();
				list.addAll(testContext.getPassedTests().getAllResults());
				list.addAll(testContext.getFailedTests().getAllResults());
				list.addAll(testContext.getSkippedTests().getAllResults());
				list.addAll(testContext.getFailedConfigurations().getAllResults());
			}
		}
	}

}
