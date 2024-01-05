package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConform {
	public WebDriver driver;

	// Initialization
	public OrderConform(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h1[text()='Order Confirmed'")
	private WebElement orderconformText;

	public WebElement getOrderconformText() {
		return orderconformText;
	}

}
