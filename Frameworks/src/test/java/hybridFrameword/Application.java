package hybridFrameword;

import java.io.IOException;

import org.testng.annotations.Test;

import keywordDF.Methods;
import utils.ReadExcel;

public class Application {

	@Test
	public void verifyErrMessages() throws IOException {

		String[][] data1 = ReadExcel.getData("resources//userdata.xlsx", "Sheet1");
		String[][] data2 = ReadExcel.getData("resources//userdata.xlsx", "Sheet2");

		for (int k = 1; k < data1.length; k++) {
			for (int i = 1; i < data2.length; i++) {

				switch (data2[i][3]) {
				case "openBrowser": // i=1,9,17
					Methods.openBrowser();
					break;

				case "maximizeIt": // i=2,10,18
					Methods.maximizeIt();
					break;

				case "navigateTo": // i=3,11,19
					Methods.navigateTo(data2[i][6]);
					break;

				case "enterUsername": // i=4,12,20
					Methods.enterUsername(data2[i][5], data1[k][1]);
					break;

				case "enterPassword": // i=5,13,21
					Methods.enterPassword(data2[i][5], data1[k][2]);
					break;

				case "clickLoginBtn": // i=6,14,22
					Methods.clickLoginBtn(data2[i][4], data2[i][5]);
					break;

				case "verifyErrMsg": // i=7,15,23
					Methods.verifyErrMsg(data2[i][4], data2[i][5], data2[i][6]);
					break;

				case "closeBrowser": // i=8,16,24
					Methods.closeBrowser();
					break;
				}

			}
		}
	}

}
