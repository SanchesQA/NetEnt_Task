package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.sql.Timestamp;


public class TestNGListeners implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        System.out.println(iTestResult.getName()+" START at "+new Timestamp(System.currentTimeMillis()));
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(iTestResult.getName()+" SUCCESS at "+new Timestamp(System.currentTimeMillis()));
    }

    public void onTestFailure(ITestResult iTestResult) {
       System.out.println(iTestResult.getName()+" FAILED at "+new Timestamp(System.currentTimeMillis()));
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
