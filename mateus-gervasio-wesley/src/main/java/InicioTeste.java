import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.containsString;

public class InicioTeste {
    public static void main(String... args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.google.com/");
        driver.findElement(By.id("lst-ib")).sendKeys("Árvore");
        //driver.findElement(By.name("btnK")).click();
        driver.findElement(By.name("btnG")).click();
        Thread.sleep(2000);
        Assert.assertThat(driver.getTitle(), containsString("Árvore"));
    }
}
