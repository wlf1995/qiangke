package com.ibicn;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * 抢课
 */
public class GrabLesson {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        WebDriver driver = new ChromeDriver();// 用WebDriver new Firefox浏览器的驱动给变量driver，相当于driver拿到了Firefox浏览器的控制权。
        //最大化
//        driver.manage().window().maximize();
        //打开网址
        driver.get("http://jwcnew.nefu.edu.cn/dblydx_jsxsd/");
        //设置账号和密码
        driver.findElement(By.name("USERNAME")).sendKeys("2018220644");
        driver.findElement(By.name("PASSWORD")).sendKeys("hui1219");
        driver.findElement(By.id("btnSubmit")).click();

        //如果有提示信息，点击确定
        Alert alert = driver.switchTo().alert();
        if (alert != null) {
            System.out.println("有对话框弹出,对话框内容：" + alert.getText());
            alert.accept();
            By by = By.cssSelector(".block2");
            By block2 = By.className("block2");
        }
        //跳转至选课页面
        driver.findElements(By.cssSelector(".block2")).get(0).click();

//        driver.findElement(By.xpath(".//*[@id='navbar-collapse-01']/ul[2]/li[2]/button")).click();

//        driver.findElement(By.linkText("点击登录")).click();
//        driver.findElement(By.xpath(".//*[@id='main-container']/div[1]/div[2]/div/div[2]/div/a[3]/span")).click();
        // 回车键查询
//        driver.findElement(By.cssSelector(".form-control")).sendKeys("软件测试学");
//        new Actions(driver).sendKeys(Keys.ENTER).perform();// 按回车键

        // 后退
//        driver.navigate().back();

        // 刷新
//        driver.navigate().refresh();

        // 关闭浏览器
//        driver.close();
    }

    public static WebElement getTag(WebDriver driver, By by) {
        WebElement e;
        while (true) {
            try {
                e = driver.findElement(by);
            } catch (Exception e1) {
                //每次获取失败休眠100毫秒
                try {
                    Thread.sleep(1000);
                    continue;
                } catch (InterruptedException e11) {
                    e11.printStackTrace();
                    continue;
                }
            }
            break;
        }
        return e;
    }
}
