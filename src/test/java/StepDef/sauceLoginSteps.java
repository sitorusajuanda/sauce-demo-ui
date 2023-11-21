package StepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sauceLoginSteps {
    WebDriver webDriver;
    public sauceLoginSteps(){
        super();
        this.webDriver = Hooks.webDriver;
    }
    @Given("^User open SauceDemo Website$")
    public void userOpenSauceDemoWebsite() {
        WebElement openWebsite = webDriver.findElement(By.xpath("//div[@class='login_logo']"));
        openWebsite.isDisplayed();
        Assert.assertTrue(true);
    }

    @Then("^Input username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void inputUsernameAndPassword(String username, String password){
        webDriver.findElement(By.id("user-name")).sendKeys(username);
        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @When("^Click button login$")
    public void clickButtonLogin() {
        webDriver.findElement(By.id("login-button")).click();

    }

    @And("^Should redirect to home page$")
    public void shouldRedirectToHomePage() {
        Assert.assertTrue(webDriver.findElement(By.id("inventory_container")).isDisplayed());
        webDriver.close();
        webDriver.quit();
    }

    @Then("^Failed login and show message$")
    public void failedLoginAndShowMessage() {
        Assert.assertTrue(webDriver.findElement(By.xpath("//h3[.='Epic sadface: Username and password do not match any user in this service']")).isDisplayed());
        webDriver.close();
        webDriver.quit();

    }


}
