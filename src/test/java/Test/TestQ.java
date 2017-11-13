package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import pages.*;

import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;

public class TestQ {
    private  WebDriver driver;
    private login page;
    public String nameBlog;

    @BeforeTest
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:/Users/guninsb/Desktop/Test/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //период неявного ожидания
        page = new login(driver);

    }

    @org.testng.annotations.Test
    public void testRun() {
        page.open(" http://igorakintev.ru/admin/");
        page.setUsername("silenium");
        page.setPassword("super_password");
        page.clickLogin();
        checkBlog pageAdmin = new checkBlog(driver);
        pageAdmin.checkTitle("Панель управления");
        pageAdmin.clickAddButton();
        createBlog pageCreateBlog = new createBlog(driver);
        String[] blogItems = {
                "Title",
                "Slug",
                "Text markdown",
                "Text"
        };
        pageCreateBlog.addResponces(blogItems);

    }
}
