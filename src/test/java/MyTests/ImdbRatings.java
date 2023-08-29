package MyTests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class ImdbRatings extends BaseTest {

    @Test
    public void imdbRatings() throws InterruptedException {
        //Navigate to Url
        driver.get("https://www.imdb.com/chart/top/");
        //Total number of movie in list
        List<WebElement> totalMoviesList = driver.findElements(By.xpath("//*[@id='__next']/main/div/div[3]/section/div/div[2]/div/ul/li"));
        System.out.println("Total Number of movies in a list: " + totalMoviesList.size());

        //Select the sort option from the dropdown and print the most rated movie in list
        Select sortOption = new Select(driver.findElement(By.xpath("//*[@id=\"sort-by-selector\"] ")));
        sortOption.selectByValue("USER_RATING");
        WebElement mostRated = driver.findElement(By.xpath("//ul[1]/li[1]/div[2]/div[1]/div[1]/div[1]"));
        System.out.println("Most Rated Movie in a list: " + mostRated.getText());

        //Print the oldest & Recent movies in list
        sortOption.selectByValue("RELEASE_DATE");

        //Print the recent movie in a list
        WebElement recentMovie = driver.findElement(By.xpath("//ul[1]/li[1]/div[2]/div[1]/div[1]/div[1]"));
        System.out.println("Recent Movie in a list: " + recentMovie.getText());

        //Click on the sort by direction button on the left side of sort option
        WebElement buttonFilter = driver.findElement(By.xpath("//button[@title='Change sort by direction']"));
        buttonFilter.click();
        WebElement oldestMovie = driver.findElement(By.xpath("//ul[1]/li[1]/div[2]/div[1]/div[1]/div[1]"));
        System.out.println("Oldest Movie in a list: " + oldestMovie.getText());

        //Print the movie with the highest user rating
        sortOption.selectByValue("USER_RATING_COUNT");
        WebElement highRatings = driver.findElement(By.xpath("//ul[1]/li[1]/div[2]/div[1]/div[1]/div[1]"));
        System.out.println("Highest User rating movie: " + highRatings.getText());
    }
}
