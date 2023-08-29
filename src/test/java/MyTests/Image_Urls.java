package MyTests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Image_Urls extends BaseTest {

    @Test
    public void imageUrls() {
        //Naviagte to url
        driver.get("https://www.bookmyshow.com/explore/home/mumbai");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        //Print the urls under the Recommended movies
        List<WebElement> urlsList = driver.findElements(By.xpath("//h2[text()='Recommended Movies']/../../../following-sibling::div//a//img"));
        for (WebElement ele : urlsList) {
            System.out.println("Url of Recommended Movies: " + ele.getAttribute("src"));
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Premieres')]")));

        //print the name and language of the second movie in the premieres list
        WebElement nameOfMovie = driver.findElement(By.xpath("//*[contains(text(),'Premieres')]/../../../following-sibling::div/div/div[1]/a[2]/div/div[3]/div[1]"));
        System.out.println("Name of the movie: " + nameOfMovie.getText());

        WebElement langOfMovie = driver.findElement(By.xpath("//*[contains(text(),'Premieres')]/../../../following-sibling::div/div/div[1]/a[2]/div/div[3]/div[2]"));
        System.out.println("Language of the movie: " + langOfMovie.getText());
    }
}
