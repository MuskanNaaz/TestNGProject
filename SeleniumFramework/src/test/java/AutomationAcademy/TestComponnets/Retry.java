package AutomationAcademy.TestComponnets;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
//to rerun the fail test casese;
	int count =0;
	int maxTry = 1;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxTry) {
			count++; 
			return true;
		}
		return false;
	}

}
