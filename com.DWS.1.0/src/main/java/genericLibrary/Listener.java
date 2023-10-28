package genericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(" Test case has failed ");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(" Test execution has started ");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" Test execution has finished ");
	}
}
