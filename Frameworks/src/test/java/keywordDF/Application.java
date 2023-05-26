package keywordDF;

import java.io.IOException;

import org.testng.annotations.Test;

import utils.ReadExcel;

public class Application {
	
	@Test
	public void verifyErrMessages() throws IOException {
		
		String[][] data = ReadExcel.getData("resources//userdata.xlsx", "Sheet2");
			
		for (int i=1; i<data.length; i++) {
			
			switch(data[i][3]) {
			case "openBrowser": //i=1,9,17
				Methods.openBrowser();
				break;
				
			case "maximizeIt": //i=2,10,18
				Methods.maximizeIt();
				break;
				
			case "navigateTo": //i=3,11,19
				Methods.navigateTo(data[i][6]);
				break;
			
			case "enterUsername": //i=4,12,20
				Methods.enterUsername(data[i][5], data[i][6]);
				break;
				
			case "enterPassword": //i=5,13,21
				Methods.enterPassword(data[i][5], data[i][6]);
				break;	
			
			case "clickLoginBtn": //i=6,14,22
				Methods.clickLoginBtn(data[i][4], data[i][5]);
				break;
				
			case "verifyErrMsg": // i=7,15,23
				Methods.verifyErrMsg(data[i][4],data[i][5],data[i][6]);
				break;
				
			case "closeBrowser": //i=8,16,24
				Methods.closeBrowser();
				break;
			}
			
		}
	}

}
