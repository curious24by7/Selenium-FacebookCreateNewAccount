package com.facebookselenium.mypackage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class scripts {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\soham\\selenium jars and drivers\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://en-gb.facebook.com/");
        System.out.println("Title: "+ driver.getTitle());
        driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[5]/a[1]")).click();
        Thread.sleep(3000);
        WebElement text = driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[9]/p[1]"));
        System.out.println("Popup Notice: "+ text.getText());
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("John");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("Doe");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("9420554666");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/input[1]")).sendKeys("3216554987");
        Thread.sleep(1000);
        Select day = new Select(driver.findElement(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/span[1]/span[1]/select[1]")));
        day.selectByVisibleText("6");
        Thread.sleep(1000);
        Select month = new Select(driver.findElement(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/span[1]/span[1]/select[2]")));
        month.selectByVisibleText("Jun");
        Thread.sleep(1000);
        Select year = new Select(driver.findElement(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/span[1]/span[1]/select[3]")));
        year.selectByVisibleText("1966");
        driver.findElement(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/span[1]/span[2]/input[1]")).click();
        scripts.CaptureScreenShot(driver);
        driver.findElement(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[10]/button[1]")).click();
        Thread.sleep(19000);
        WebElement warning = driver.findElement(By.xpath("//*[@id=\"reg_error_inner\"]"));
        System.out.println("Notice: " + warning.getText());
        Thread.sleep(2000);
        driver.quit();
    }

    public static void CaptureScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        File SourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("./screenshots/" + "facebook-register-" + System.currentTimeMillis() + ".png");
        //FileUtils.copyFile(SourceFile, destinationFile);
        FileHandler.copy(SourceFile, destinationFile);
    }
}
