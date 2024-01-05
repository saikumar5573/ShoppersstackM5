package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NetBankingLoginPage {
public WebDriver driver;
	
	public NetBankingLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

}
