package org.adl.specs
    import spock.lang.*
import org.openqa.selenium.firefox.FirefoxDriver
import org.adl.pages.ShibLoginPage
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
/**
 * Created by IntelliJ IDEA.
 * User: edvorkin
 * Date: 2/11/12
 * Time: 11:28 PM
 * To change this template use File | Settings | File Templates.
 */
class ShibbolethLoginSpec extends Specification{
    def "Simple login of shibboleth user into the system"() {
         given: "User choose IDP to login from page"
                def username='autogod181@artstorqa.artstor'
                def password='artstor'
                def startUrl="http://192.168.11.136/sso/shibbolethinit?o="
                def driver=new FirefoxDriver()   
                driver.get(startUrl)

         when: "User login into IDP with his username -passowrd"
                ShibLoginPage loginpage=ShibLoginPage(driver)
                driver=loginpage.login(username, password)
                WebElement p_user=driver.findElement(By.id("userId"))
         then: "User get authenticated into ADL application"

                p_user.text==username
                

    }
}
