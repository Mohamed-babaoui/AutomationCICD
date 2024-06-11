package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	
	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Report");
		reporter.config().setDocumentTitle("Demo Report");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Babaoui");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Version", "1.0");
		extent.setSystemInfo("Author", "Mohamed");
		extent.setSystemInfo("Date", "2024-06-06");
		extent.setSystemInfo("Country", "Morocco");
		extent.setSystemInfo("Company", "Eviden");
		extent.setSystemInfo("Project", "Selenium");
		extent.setSystemInfo("Module", "Login");
		
		return extent;
	}
}
