package org.adl.pages
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by IntelliJ IDEA.
 * User: edvorkin
 * Date: 2/11/12
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
class ShibLoginPage extends Page{
    private final WebDriver driver;
    public ShibLoginPage(driver, url) {
        this.driver=driver;
        driver.get(url);
        // check that we are loading the right page
        if (!"Login".equals(this.driver.getTitle())) {
            throw new IllegalStateException("This is not Shib Login Page")
        }
    }
        public ShibLoginPage(driver) {
            this.driver=driver;

            // check that we are loading the right page
            if (!"Login".equals(this.driver.getTitle())) {
                throw new IllegalStateException("This is not Shib Login Page")
            }

    }

    public WebDriver login(username, password){
        def elem_username=driver.findElement(By.name("j_username"))
        def elem_password=driver.findElement(By.name("j_password"))
        elem_username.sendKeys(username)
        elem_password.sendKeys(password)
        elem_password.submit()
        // because this is redirect, we just returning the driver object

        return driver;
        
    }
}
