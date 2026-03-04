package TestClass;

import BaseFolder.BaseTest;
import BaseFolder.ExcelUtils;
import PageFactoryPageClass.LoginPage;
import org.apache.poi.xwpf.usermodel.IBody;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData")
    public void verifyLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }
//One way -- Data driven framework
//    @DataProvider(name = "loginData1")
//    public Object[][] getData() {
//        return new Object[][] {
//                {"standard_user", "secret_sauce"},
//                {"locked_out_user", "secret_sauce"},
//                {"problem_user", "secret_sauce"}
//        };
//    }

    //Another way of Data Driven Frame work
    @DataProvider(name = "loginData")
    public Object[][] getExcelData() throws Exception {
        String filePath = "src/test/resources/Excel Sheet Structure for Automation .xlsx";
        String sheetName = "Sheet1";

        // Calling the Excel utility method we created earlier
        return ExcelUtils.getTableArray(filePath, sheetName);
    }
}