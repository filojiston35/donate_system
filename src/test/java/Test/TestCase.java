/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 *
 * @author Yusuf
 */

public class TestCase {
    
   /* @Test
    public void donorLoginTest()
    {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\3.SINIF DERSLERİ\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://localhost:8080/donate_system/");
        driver.manage().window().maximize();
        driver.findElement(By.className("btn-success")).click();
        driver.findElement(By.id("j_idt30:j_idt31")).click();
        pause(1000);
        driver.findElement(By.id("j_idt30:mail")).click();
        driver.findElement(By.id("j_idt30:mail")).sendKeys("myunlu35@gmail.com");
        
        driver.findElement(By.id("j_idt30:password")).click();
        driver.findElement(By.id("j_idt30:password")).sendKeys("asd01233210");
        driver.findElement(By.id("j_idt30:j_idt37")).click();
        pause(2000);
        driver.quit();
    }
    @Test
    public void patientLoginTest()
    {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\3.SINIF DERSLERİ\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://localhost:8080/donate_system/");
        driver.manage().window().maximize();
        driver.findElement(By.className("btn-success")).click();
        driver.findElement(By.id("j_idt44:j_idt45")).click();
        driver.findElement(By.id("j_idt44:j_idt45")).sendKeys("HEE33LGG9F");
        driver.findElement(By.id("j_idt44:j_idt46")).click();
        pause(2000);
        driver.quit();
    }
    @Test
    public void patientDonorContact()
    {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\3.SINIF DERSLERİ\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://localhost:8080/donate_system/");
        driver.manage().window().maximize();
        driver.findElement(By.className("btn-success")).click();
        driver.findElement(By.id("j_idt44:j_idt45")).click();
        driver.findElement(By.id("j_idt44:j_idt45")).sendKeys("KXJWA50GJY");
        driver.findElement(By.id("j_idt44:j_idt46")).click();
        pause(1000);
        driver.findElement(By.id("j_idt84:0:j_idt86:j_idt88")).click();
        pause(2000);
        
    }
    @Test
    public void patientRegistrationForm()
    {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\3.SINIF DERSLERİ\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://localhost:8080/donate_system/");
        driver.manage().window().maximize();
        driver.findElement(By.className("btn-danger")).click();
        pause(1000);
        driver.findElement(By.id("patientForm:name")).click();
        driver.findElement(By.id("patientForm:name")).sendKeys("testName");
        
        driver.findElement(By.id("patientForm:surname")).click();
        driver.findElement(By.id("patientForm:surname")).sendKeys("testSurName");
        
        driver.findElement(By.id("patientForm:bloodgroup_label")).click();
        pause(1000);
        driver.findElement(By.id("patientForm:bloodgroup_1")).click();
        
        driver.findElement(By.id("patientForm:city_label")).click();
        pause(1000);
        driver.findElement(By.id("patientForm:city_1")).click();
        
        driver.findElement(By.id("patientForm:phone")).click();
        driver.findElement(By.id("patientForm:phone")).sendKeys("5414318216");
        
        driver.findElement(By.id("patientForm:mail")).click();
        driver.findElement(By.id("patientForm:mail")).sendKeys("testmail3@gmail.com");

        driver.findElement(By.cssSelector("label[for='patientForm:patientDegreeOfUrgency:1']")).click();
        
        driver.findElement(By.id("patientForm:j_idt57")).click();
        driver.findElement(By.id("patientForm:j_idt57")).sendKeys("Bu bir test çağrısıdır.");
        
        driver.findElement(By.id("patientForm:j_idt60")).click();
        pause(2000);
        driver.quit();
        
       
        
    }*/
    public static void pause(long sleeptime)
    {
        try {
            Thread.sleep(sleeptime);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestCase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
