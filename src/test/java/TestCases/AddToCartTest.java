package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pomclasses.AccountSettingPage;

import pomclasses.AddressFromPage;
import pomclasses.HomePage;
import pomclasses.MyAddress;
import pomclasses.MyProfilePage;
import pomclasses.NetBankingPage;
import pomclasses.PaymentMethod;
import pomclasses.TshirtPage;
import pomclasses.addToCartPage;
import pomclasses.addressPage;
import utilities.BaseClass;
import utilities.WebDriverUtility;
@Listeners(utilities.ListenersUtility.class)
public class AddToCartTest extends BaseClass {

	@Test(dataProvider = "dataProviderAddress")
	public void Tc_AddAddress_001_Test(String home,String house_office,
			String street,String landmark, String country,String state,String city, String Dpin, String mobN) throws Throwable {
		System.out.println("add address");
		Thread.sleep(5000); 
		HomePage hp = new HomePage(driver);
		//hp.javaScriptClick(driver);
		WebElement accountSetting = hp.getAccountSettingIcon();
		accountSetting.click();

		AccountSettingPage as = new AccountSettingPage(driver);
		as.getmyProfileLink().click();

		Assert.assertEquals(driver.getCurrentUrl(),"https://shoppersstack.com/my-profile/my-profile-info");

		System.out.println(" The my profile page is opened");

		MyProfilePage mp = new MyProfilePage(driver);
		mp.getAddAddressLink().click();

		MyAddress ma = new MyAddress(driver);
		ma.getAddAddressformbutton().click();

		AddressFromPage afp = new AddressFromPage(driver);
		afp.getNameTextField().sendKeys(home);
		afp.getHouseOfficeInformationTextField().sendKeys(house_office);
		afp.getStreetInformationTextField().sendKeys(street);
		afp.getLandMarkTextField().sendKeys(landmark);
		WebElement countryDropDown = afp.getCountryDropDown();
		drpu.selectDropDownByVisibleText(country, countryDropDown);
		WebElement StateDropDown = afp.getStateDropDown();
		drpu.selectDropDownByVisibleText(state, StateDropDown);
		WebElement CityDropDown = afp.getCityDropDown();
		drpu.selectDropDownByVisibleText(city, CityDropDown);
		afp.getPincodeTextField().sendKeys(Dpin);
		afp.getPhoneNumberTextField().sendKeys(mobN);
		afp.getAddAddressButton().click();

//		Assert.assertEquals(ma.getAddedAddress().getText(), home);
//		System.out.println("The address -" + home + " is added successfully");
	}
	@DataProvider
	public Object[][]dataProviderAddress1() throws Throwable{
		return data.accessAllAddress();
	}

	@DataProvider
	public Object[][] dataProviderAddress() {
		Object[][] ref = new Object[1][9];
		ref[0][0] = "LOveBirds";
		ref[0][1] = "ambani building 2nd floor";
		ref[0][2] = "ambani street";
		ref[0][3] = "ambani point";
		ref[0][4] = "India";
		ref[0][5] = "Karnataka";
		ref[0][6] = "Bengaluru";
		ref[0][7] = "560010";
		ref[0][8] = "8497885567";

//      ref[1][0] = "Rowdies";
//		ref[1][1] = "Rowdies building 5th floor";
//      ref[1][2] = "Rowdies street";
//      ref[1][3] = "Rowdies point";
//		ref[1][4] = "India";
//      ref[1][5] = "Karnataka";
//		ref[1][6] = "Bengaluru";
//      ref[1][7] = "560010";
//      ref[1][8] = "9964138253";

		return ref;

	}

	@Test(priority=1,dependsOnMethods = "Tc_AddAddress_001_Test")

	public void Tc_EndToEndCashOnDelivery_Test() throws Throwable {
		Thread.sleep(3000);

		System.out.println("first test case");
		String titleHomePage = driver.getTitle();
		Assert.assertEquals(titleHomePage, "ShoppersStack | Home");

		HomePage hp = new HomePage(driver);
		Thread.sleep(5000);
		WebElement menLink = hp.getmenManuLink();

		wu.mouseOverAction(driver, menLink);

		hp.getTshirtPopUpLink().click();

		TshirtPage tsp = new TshirtPage(driver);
		String currentUrl = driver.getCurrentUrl();

		Assert.assertEquals(currentUrl,"https://shoppersstack.com/sub-category/men-tshirt");
		wu.mouseOverAction(driver, tsp.gettshirtTopLink());
         Thread.sleep(2000);
		tsp.getlevisMenRegularfitproduct_AddToCartButton().click();
		hp.getaddToCartLink().click();
		Assert.assertEquals(driver.getCurrentUrl(),"https://shoppersstack.com/cart");
		System.out.println("The cart page is opened");

		addToCartPage ac = new addToCartPage(driver);
		String leviseProductTest = ac.getLevisProduct().getText();
		Assert.assertEquals(leviseProductTest, "Levis Mens Regular Fit Tee");
		System.out.println("the product is added to cart");

		ac.getBuyNowButtonInAddToCartPage().click();
		String addresPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(addresPageUrl,"https://shoppersstack.com/selectaddress");
		System.out.println("the address page is displayed");
		
		addressPage ap=new addressPage(driver);
		ap.getLovwebirdAddress().click();
		ap.getProcedButton().click();
		
		PaymentMethod pm=new PaymentMethod(driver);
		pm.getcashOndeliveryRadioButton().click();
		pm.getProceedButton().click();
		
		

	}

	 @Test(priority=2,dependsOnMethods="Tc_AddAddress_001_Test")
	public void EndToEnd_NetBanking() throws Throwable {
		//Thread.sleep(3000);

		//System.out.println("Second test case");
		 Thread.sleep(3000);

			System.out.println("first test case");
			String titleHomePage = driver.getTitle();
			Assert.assertEquals(titleHomePage, "ShoppersStack | Home");

			HomePage hp = new HomePage(driver);
			Thread.sleep(5000);
			WebElement menLink = hp.getmenManuLink();

			wu.mouseOverAction(driver, menLink);

			hp.getTshirtPopUpLink().click();

			TshirtPage tsp = new TshirtPage(driver);
			String currentUrl = driver.getCurrentUrl();

			Assert.assertEquals(currentUrl,"https://shoppersstack.com/sub-category/men-tshirt");
			wu.mouseOverAction(driver, tsp.gettshirtTopLink());
			Thread.sleep(3000);
			tsp.getlevisMenRegularfitproduct_AddToCartButton().click();
			hp.getaddToCartLink().click();
			Assert.assertEquals(driver.getCurrentUrl(),"https://shoppersstack.com/cart");
			System.out.println("The cart page is opened");

			addToCartPage ac = new addToCartPage(driver);
			String leviseProductTest = ac.getLevisProduct().getText();
			Assert.assertEquals(leviseProductTest, "Levis Mens Regular Fit Tee");
			System.out.println("the product is added to cart");

			ac.getBuyNowButtonInAddToCartPage().click();
			String addresPageUrl = driver.getCurrentUrl();
			Assert.assertEquals(addresPageUrl,"https://shoppersstack.com/selectaddress");
			System.out.println("the address page is displayed");
			
			addressPage ap= new addressPage(driver);
		     ap.getLovwebirdAddress().click();
		     ap.getProcedButton().click();
		     PaymentMethod pm=new PaymentMethod(driver);
		    WebElement netbankingbutton= pm.getNetBankingButton();
		    wu.javaScriptClick(driver,netbankingbutton);
		    
		     pm.getProceedButton().click();
//		     NetBankingPage nb= new NetBankingPage(driver);
//		     Thread.sleep(2000);
//		     driver.switchTo().frame(nb.getnetBankingFrameTag());
//		     Thread.sleep(2000);
//		     nb.getIDHC_radioButton().click();
//		     nb.getsubmitButton().submit();
		     
		     
	}
}
