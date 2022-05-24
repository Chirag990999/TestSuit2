package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestSuit2 {
    protected static WebDriver driver;










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
