package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class checkBlog {
    private  WebDriver driver;

    public checkBlog(WebDriver driver) {
        this.driver = driver;
    }

    public void checkTitle(String text)
    {
        String title;
        title = driver.getTitle();
        if (title.indexOf(text) != -1) {
            System.out.println("Title содержит нужную информацию");
        } else {
            System.out.println("Title не содержит нужной информацию");
            driver.quit();
        }
    }

    public void clickAddButton()
    {
        driver.get("http://igorakintev.ru/admin/blog/entry/add/");
    }
}
