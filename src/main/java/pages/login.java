package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class login {
    private  WebDriver driver;

    public login(WebDriver driver) {
        this.driver = driver;
    }
    public void open(String url) {
        driver.get(url);
    } //переход по ссылке

    public void setUsername(String text) {
        By username = By.id("id_username");
        WebElement userName = driver.findElement(username);
        userName.sendKeys(text);
    }

    public void setPassword(String text) {
        By password = By.id("id_password");
        WebElement passwor = driver.findElement(password);
        passwor.sendKeys(text);
    }

    public void clickLogin() {
        WebElement submit = driver.findElement(By.id("login-form"));
        submit.submit();
    }

}
