package StepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sauceLoginSteps {
    WebDriver driver;
    @Given(value = "^Open url \"([^\"]*)\"$")
    public void openUrl(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Then("^Input username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void inputUsernameAndPassword(String username, String password){
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @When("^Click button login$")
    public void clickButtonLogin() {
        driver.findElement(By.id("login-button")).click();

    }

    @And("^Should redirect to home page$")
    public void shouldRedirectToHomePage() {
        Assert.assertTrue(driver.findElement(By.id("inventory_container")).isDisplayed());
        driver.close();
        driver.quit();
    }

    @Then("^Failed login and show message$")
    public void failedLoginAndShowMessage() {
        Assert.assertTrue(driver.findElement(By.xpath("//h3[.='Epic sadface: Username and password do not match any user in this service']")).isDisplayed());
        driver.close();
        driver.quit();

    }
}
