package com.ScreenShot_12;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass_2 extends ScreenShotUtils_2 implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {

		try {
			captureScreenShot(result.getName() + ".jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
