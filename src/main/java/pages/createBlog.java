package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class createBlog {
    private WebDriver driver;


    public createBlog(WebDriver driver) {
        this.driver = driver;
    }

    public void addResponces(String[] args)
    {
        int min = 100000000;
        int max = 999999999;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        WebElement titleText = driver.findElement(By.id("id_title"));
        titleText.sendKeys(args[0] + randomNum);
        String titlecheck = args[0] + randomNum;
        driver.findElement(By.id("id_slug")).clear();
        WebElement slugTxt = driver.findElement(By.id("id_slug"));
        slugTxt.sendKeys(args[1] + randomNum + 50);
        driver.findElement(By.id("id_text_markdown")).clear();
        WebElement Textmark = driver.findElement(By.id("id_text_markdown"));
        Textmark.sendKeys(args[2] + randomNum + 50);
        driver.findElement(By.id("id_text")).clear();
        WebElement Text = driver.findElement(By.id("id_text"));
        Text.sendKeys(args[3] + randomNum + 50);
        WebElement button_save = driver.findElement(By.name("_save"));

        button_save.click();

        driver.get("http://igorakintev.ru/admin/blog/");

        WebElement item = driver.findElement(By.linkText("Entry " + titlecheck));

        try {
            if (item.getText() != "") {
                 System.out.println("Блог: "+"Entry " + titlecheck +" присутсвует");
                item.click();
                driver.findElement(By.className("deletelink")).click();
                WebElement submit = driver.findElement(By.xpath("//input[@value='Да, я уверен']"));
                submit.click();
                System.out.println("Запись удалена");

            }
        } catch (Exception e) {
            System.out.println("Блог отсутсвует");
        }

    }



}
