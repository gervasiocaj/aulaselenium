import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

public class AddProdutoTest {

    static WebDriver driver;

    @BeforeClass
    public static void before() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void carrinhoVazio() throws InterruptedException {
        driver.navigate().to("https://sacola.submarino.com.br/");
        Thread.sleep(6000);
        String text = driver.findElement(By.className("basket-wrapper")).getText();
        Assert.assertThat(text, containsString("Seu carrinho está vazio"));
    }

    @Test
    public void adicionar() {
        driver.navigate().to("http://www.submarino.com.br/produto/122702668/");
        driver.findElement(By.className("spt-b-main-buy")).click();
        driver.findElement(By.className("warranty-off")).findElement(By.tagName("input")).click();
        driver.findElement(By.className("spt-b-continue")).click();
        String text = driver.findElement(By.id("form-basket")).findElement(By.tagName("article")).getText();
        Assert.assertThat(text, containsString("Smart TV LED"));
    }
}
