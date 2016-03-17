package by.websolutions.test.util;


import by.websolutions.test.model.FlightsPropeties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ServletUtil {
    private static FlightsPropeties flightsPropeties;
    private static Logger logger = Logger.getLogger(ServletUtil.class.getName());

    public static void solve(HttpServletRequest req, HttpServletResponse resp) throws InterruptedException, IOException {
        setFlightsPropeties(req);
        setFormPropeties(resp);
    }

    private static void setFlightsPropeties(HttpServletRequest req) {
        String startDate = req.getParameter("startDate").toString();
        String endDate = req.getParameter("endDate").toString();
        String origin = req.getParameter("origin").toString();
        String destination = req.getParameter("destination").toString();
        int seats = Integer.parseInt(req.getParameter("seats").toString());
        String comfortClass = req.getParameter("class").toString();
        int requestID = Integer.parseInt(req.getParameter("request_id").toString());
        int userID = Integer.parseInt(req.getParameter("user_id").toString());
        String type = req.getParameter("type").toString();
        flightsPropeties = new FlightsPropeties(startDate, endDate, origin, destination, seats,
                comfortClass, requestID, userID, type);
        logger.info(flightsPropeties);
    }


    private static void setFormPropeties(HttpServletResponse resp) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.united.com/ual/en/us/?root=1");
        driver.findElement(By.cssSelector(".modalCloseImg.simplemodal-close")).click();
        driver.findElement(By.id("uniform-SearchTypeMain_oneWay")).click();
        driver.findElement(By.id("Origin")).sendKeys(flightsPropeties.getOrigin());
        driver.findElement(By.id("Destination")).sendKeys(flightsPropeties.getDestination());
        driver.findElement(By.id("DepartDate")).sendKeys(flightsPropeties.getStartDate());
        WebElement dates = driver.findElement(By.cssSelector("#DepartDate+button"));
        Thread.sleep(1000);
        dates.click();
        Thread.sleep(1000);
        int seats = flightsPropeties.getSeats();
        if (seats != 1) {
            driver.findElement(By.cssSelector("#travelers-selector")).click();
            WebElement increase = driver.findElement(By.cssSelector("#travelers-select li:first-child .stepper-btn-up"));
            for (int i = 1; i < seats; i++) {
                increase.click();
            }
            driver.findElement(By.cssSelector("#travelers-select .modalCloseImg")).click();
        }
        driver.findElement(By.id("AwardTravel")).click();
        driver.findElement(By.id("awardCabinType")).click();
        Select dropdown = new Select(driver.findElement(By.id("awardCabinType")));
        String flightClass = parseFlightClass();
        dropdown.selectByValue(flightClass);
        driver.findElement(By.id("flightBookingSubmit")).click();
        Thread.sleep(10000);
        WebElement page = driver.findElement(By.cssSelector(".page-loader-full"));
        while (page.isDisplayed()) {
            Thread.sleep(100);
        }
        if (driver.findElement(By.cssSelector(".qtip")).isDisplayed()) {
            driver.findElement(By.cssSelector(".ui-icon")).click();
        }
        List<WebElement> flightBlocks = driver.findElements(By.cssSelector(".flight-block"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        for (int i = 0; i < flightBlocks.size(); i++) {
            jse.executeScript("window.scrollBy(0,400)", "");
            driver.findElement(By.cssSelector("#ui-id-" + (3 + i * 2))).click();
            List<WebElement> prices = flightBlocks.get(i).findElements(By.cssSelector(".price-point-wrap"));
            for (int j = 0; j < prices.size(); j++) {
                logger.info(prices.get(j).getText());
            }
            WebElement departureDate = flightBlocks.get(i).findElement(By.cssSelector(".flight-time.flight-time-depart"));
            WebElement departCode = flightBlocks.get(i).findElement(By.cssSelector(".airport-code.origin-airport-mismatch-code"));
            WebElement arriveDate = flightBlocks.get(i).findElement(By.cssSelector(".flight-time.flight-time-arrive"));
            WebElement arriveCode = flightBlocks.get(i).findElement(By.cssSelector(".airport-code.destination-airport-mismatch-code"));
            WebElement totalDuration = flightBlocks.get(i).findElement(By.cssSelector(".flight-duration.otp-tooltip-trigger"));
        }
    }


    private static String parseFlightClass() {
        String flightClass = flightsPropeties.getComfortClass();
        if (flightClass.contains("\"F\"") && flightClass.contains("\"B|")) {
            return "awardBusinessFirst";
        }
        if (flightClass.contains("\"E\"")) {
            return "awardEcon";
        }
        if (flightClass.contains("\"F\"")) {
            return "awardFirst";
        }
        return "awardEcon";
    }

}
