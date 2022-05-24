package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestSuit2 {
    protected static WebDriver driver;
    //---------------------------------------------------------------------------------------------------------------
//Create BeforeMethod to open the browser before every test
    @BeforeMethod
    public void openBrowser() {
        //public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 10 ) );
        driver.manage().window().maximize();
        //type URL
        driver.get( "https://demo.nopcommerce.com/" );
    }
    //---------------------------------------------------------------------------------------------------------------
    @Test
    public void userShouldBeRegisterSuccessfully(){
        //Go to Register page by click register
        clickOnElement(By.className( "ico-register" ) );

        //Select Male or Female
        driver.findElement(By.xpath( "//input[@id='gender-male']" )).click();

        //Enter First Name
        typeText( By.xpath( "//input[@name='FirstName']"),"Automation");

        //Enter Last Name
        typeText( By.id( "LastName" ),"LastNameTest" );

        //select day of the birthday
        Select DayOfBirth =new Select( driver.findElement( By.xpath( "//select[@name='DateOfBirthDay']" ) ) );
        DayOfBirth.selectByIndex( 7 );

        //select month of the birthday
        Select MonthOfBirth= new Select( driver.findElement( By.xpath("//select[@name='DateOfBirthMonth']" )) );
        MonthOfBirth.selectByIndex( 3 );

        // select year of the birthday
        Select YearOfBirth = new Select( driver.findElement( By.xpath( "//select[@name='DateOfBirthYear']" ) ) );
        YearOfBirth.selectByValue( "1981" );

        //Enter Email
        typeText( By.xpath( "//input[@name=\"Email\"]" ),"Automation"+randomDate()+"@bmail.com" );

        //Enter Password
        typeText( By.xpath( "//input[@name=\"Password\"]" ),"Auto123" );

        //Enter Confirm password
        typeText( By.xpath( "//input[@name=\"ConfirmPassword\"]" ),"Auto123" );

        //Click register
        clickOnElement( By.xpath( "//button[@id=\"register-button\"]" ) );

        //verification//Assert
        String actualmessage=driver.findElement( By.className( "result" ) ).getText();
        String expectedmessage = "Your registration completed";
        Assert.assertEquals( actualmessage,expectedmessage,"Registration is not match" );
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test
    public void userShouldEmailTheProductToTheFriendSuccessfully(){
        //Go to Register page by click register
        clickOnElement(By.className( "ico-register" ) );

        //Seelect Male or Female
        driver.findElement(By.xpath( "//input[@id='gender-male']" )).click();

        //Enter First Name
        typeText( By.xpath( "//input[@name='FirstName']"),"Automation");

        //Enter Last Name
        typeText( By.id( "LastName" ),"LastNameTest" );

        //select day of the birthday
        Select BirthDay =new Select( driver.findElement( By.xpath( "//select[@name='DateOfBirthDay']" ) ) );
        BirthDay.selectByIndex( 7 );

        //select month of the birthday
        Select BirthMonth= new Select( driver.findElement( By.xpath("//select[@name='DateOfBirthMonth']" )) );
        BirthMonth.selectByIndex( 3 );

        // select year of the birthday
        Select BirthYear = new Select( driver.findElement( By.xpath( "//select[@name='DateOfBirthYear']" ) ) );
        BirthYear.selectByValue( "1981" );

        //Enter Email
        typeText( By.xpath( "//input[@name=\"Email\"]" ),"Automation"+randomDate()+"@bmail.com" );

        //Enter Password
        typeText( By.xpath( "//input[@name=\"Password\"]" ),"Auto123" );

        //Enter Confirm password
        typeText( By.xpath( "//input[@name=\"ConfirmPassword\"]" ),"Auto123" );

        //Click register
        clickOnElement( By.xpath( "//button[@id=\"register-button\"]" ) );

        //verification//Assert
        String MessageActual=driver.findElement( By.className( "result" ) ).getText();
        String MessageExpected = "Your registration completed";
        Assert.assertEquals( MessageActual,MessageExpected,"Registration is not match" );

        //Click on Continue button
        clickOnElement( By.xpath( "//a[@class=\"button-1 register-continue-button\"]" ) );

        //Click on Computers Category
        clickOnElement(By.xpath( "//ul[@class=\"top-menu notmobile\"]/li//a[@href=\"/computers\"]" )  );

        //Select and click on Desktops category
        clickOnElement( By.xpath( "//h2[@class=\"title\"]//a[@title=\"Show products in category Desktops\"]" ) );

        //Select and click on "build your own computer" option
        clickOnElement( By.xpath( "//div[@class=\"details\"]/h2//a[@href=\"/build-your-own-computer\"]" ) );

        //Select Email a friend option
        clickOnElement( By.xpath( "//form[@action=\"/build-your-own-computer\"]/div[2]/div[1]/div[2]/div[10]/div[3]" ) );

        //Enter friend's E-mail address
        typeText( By.className( "friend-email" ),"mark" + randomDate() + "waugh@bmail.com");

        //Click on SEND EMAIL
        clickOnElement( By.xpath( "//form[@action=\"/productemailafriend/1\"]/div[2]" ) );

        //verification Message//Assert
        String actualMessage=driver.findElement( By.className( "result" ) ).getText();
        String expectedMessage = "Your message has been sent.";
        Assert.assertEquals( actualMessage,expectedMessage,"Message  is not match" );

    }
    //------------------------------------------------------------------------------------------------------------
    @Test
    public void userShouldSelectTheProductAndAddToTheCartSuccessfully(){
        //Click on Computers Category
        clickOnElement(By.xpath( "//ul[@class=\"top-menu notmobile\"]/li//a[@href=\"/computers\"]" )  );

        //Select and click on Desktops category
        clickOnElement( By.xpath( "//h2[@class=\"title\"]//a[@title=\"Show products in category Desktops\"]" ) );

        //Select and click on "build your own computer" option
        clickOnElement( By.xpath( "//div[@class=\"details\"]/h2//a[@href=\"/build-your-own-computer\"]" ) );

        //Select the Processor 2.2 GHz Intel Premium
        Select Processor = new Select( driver.findElement( By.xpath( "//select[@name=\"product_attribute_1\"]" ) ) );
        Processor.selectByValue( "1" );

        //Select the RAM 2GB
        Select RAM = new Select( driver.findElement( By.xpath( "//select[@name=\"product_attribute_2\"]" ) ) );
        RAM.selectByValue( "3" );

        //select the HDD 320GB
        clickOnElement(  By.xpath( "//label[@for=\"product_attribute_3_6\"]" ));

        //Select OS Vista Premium
        clickOnElement( By.xpath( "//label[@for=\"product_attribute_4_9\"]" ) );

        //Select Software All Categories
        clickOnElement( By.xpath("//label[@for=\"product_attribute_5_11\"]" ));
        clickOnElement(By.xpath( "//label[@for=\"product_attribute_5_12\"]" ));

        //Select ADD TO CART
        clickOnElement( By.xpath( "//button[@id=\"add-to-cart-button-1\"]" ) );

        // Select SHOPPING CART
        clickOnElement( By.xpath( "//div[@class=\"header-links\"]/ul/li[4]/a/span[2]" ) );

        //verification Message//Assert
        String ActualProduct = driver.findElement(By.xpath( "//td[@class=\"product\"]/a" ) ).getText();
        String ExpectedProduct = "Build your own computer";
        Assert.assertEquals( ActualProduct,ExpectedProduct,"Product is not match" );

    }
    //-----------------------------------------------------------------------------------------------------------
    @Test
    public void userShouldBeAbleToSelectAndChangeTheCurrency(){
        // Select Euro from dropdown currency menu
        Select Euro = new Select( driver.findElement(By.id( "customerCurrency" )) );
        Euro.selectByVisibleText( "Euro" );

        // Verify product price in Euro currency//Assert
        String actualCurrency=driver.findElement( By.xpath( "//div[@data-productid=\"1\"]/div[2]/div[3]/div/span" ) ).getText();
        String expectedCurrency = "€1032.00";
        Assert.assertEquals( actualCurrency,expectedCurrency,"Currency is not match" );

        // Select US Dollar from dropdown currency menu
        Select USDollar = new Select( driver.findElement(By.id( "customerCurrency" )) );
        USDollar.selectByVisibleText( "US Dollar" );

        // Verify product price in US Dollar currency
        // Assert
        String ActualCurrency=driver.findElement( By.xpath( "//div[@data-productid=\"1\"]/div[2]/div[3]/div/span" ) ).getText();
        String ExpectedCurrency = "$1,200.00";
        Assert.assertEquals( ActualCurrency,ExpectedCurrency,"Currency is not match" );
    }
    //---------------------------------------------------------------------------------------------------------------------
    @AfterMethod
    public void Quit(){
        driver.quit();
    }
//---------------------------------------------------------------------------------------------------------------------

    public static void clickOnElement(By by) {
        driver.findElement( by ).click();
    }

    public static void typeText(By by, String text) {
        driver.findElement( by ).sendKeys( text );
    }




    public static String randomDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat( "ddMMyyyyHHmmss" );
        return formatter.format( date );
    }
    public static void driverWaitsUntilElementToBeClickable(int time, By by){

        WebDriverWait wait01 =new WebDriverWait( driver, Duration.ofSeconds( 30 ) );
        wait01.until( ExpectedConditions.elementToBeClickable( by));

    }
    public static void driverWaitsUntilURLToBe(int time ,String url){
        WebDriverWait wait02 = new WebDriverWait( driver,Duration.ofSeconds( 10) );
        wait02.until( ExpectedConditions.urlToBe(" https://demo.nopcommerce.com/electronics" ));

    }
    public static void driverWaitsUntilElementToBeSelected(By by,int time){
        WebDriverWait wait03 = new WebDriverWait( driver, Duration.ofSeconds( time) );
        wait03.until(ExpectedConditions.elementToBeSelected( by));
    }
    public static  void driverWaitsUntilURLToBeSame(int time,String url){
        WebDriverWait wait04 = new WebDriverWait(driver, Duration.ofSeconds( time )  );
        wait04.until( ExpectedConditions.urlMatches("" ) );

    }
    public static void driverWaitsUntilTitleIs(int time,String Title){
        WebDriverWait wait05 = new WebDriverWait( driver,Duration.ofSeconds( time ) );
        wait05.until( ExpectedConditions.titleIs( "") );
    }
    public static void driverWaitsUntilURLContains(int time,String url){
        WebDriverWait wait06 = new WebDriverWait( driver,Duration.ofSeconds(time ) );
        wait06.until( ExpectedConditions.urlContains( "" ) );
    }
    public static void driverWaitsUntilInvisibilityOfElementLocated(By by,int time){
        WebDriverWait wait07 = new WebDriverWait( driver, Duration.ofSeconds( time) );
        wait07.until( ExpectedConditions.invisibilityOfElementLocated( by ) );
    }
    public static void driverWaitsUntilTextToBe(int time,String txt,By by){
        WebDriverWait wait08 = new WebDriverWait( driver, Duration.ofSeconds( time ) );
        wait08.until( ExpectedConditions.textToBe( by, "txt" ));
    }
    public static void driverWaitsUntilNumberOfElementsToBe(int time, int x, By by){
        WebDriverWait wait09 = new WebDriverWait( driver, Duration.ofSeconds( time ) );
        wait09.until( ExpectedConditions.numberOfElementsToBe( by, x) );
    }
    public static void driverWaitsUntilPresenceOfElementLocated(int time, By by){
        WebDriverWait wait10= new WebDriverWait( driver, Duration.ofSeconds(time ) );
        wait10.until( ExpectedConditions.presenceOfElementLocated( by ) );
    }
    public static void driverWaitsUntilNumberOfWindowsToBe(int time, int x){
        WebDriverWait wait11 = new WebDriverWait( driver, Duration.ofSeconds( time ) );
        wait11.until( ExpectedConditions.numberOfWindowsToBe( x ) );
    }
    public static void driverWaitsUntilAttributeToBe(int time, By by,String x, String y){
        WebDriverWait wait12 = new WebDriverWait( driver, Duration.ofSeconds(time)  );
        wait12.until( ExpectedConditions.attributeToBe( by,x,y ) );
    }
    public static void driverWaitsUntilAttributeToBeNotEmpty(int time,  String x, WebElement element) {
        WebDriverWait wait12 = new WebDriverWait( driver, Duration.ofSeconds( time ) );
        wait12.until( ExpectedConditions.attributeToBeNotEmpty( element, x ));
    }
    public static void driverWaitsUntilNumberOfElementsToBeMoreThan(int time,int x, By by){
        WebDriverWait wait13 = new WebDriverWait( driver, Duration.ofSeconds( time ) );
        wait13.until( ExpectedConditions.numberOfElementsToBeMoreThan( by,x ) );
    }
    public static void driverWaitsUntilAlertIsPresent(int time){
        WebDriverWait wait14 = new WebDriverWait( driver, Duration.ofSeconds( time ) );
        wait14.until( ExpectedConditions.alertIsPresent() );
    }



}
