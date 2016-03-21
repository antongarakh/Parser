package by.websolutions.test.util;

import by.websolutions.test.model.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Parser {
    private final String driverPath = this.getClass().getClassLoader().getResource("").getPath().substring(1) + "chromedriver.exe";
    private static final String UNITED_URL = "https://www.united.com/ual/en/us/?root=1";
    private static Logger logger = Logger.getLogger(Parser.class.getName());
    private Properties properties;

    public void goToResults(HttpServletRequest req) throws InterruptedException {
        this.setProperties(req);
        this.setFormProperties();
    }

    private void setProperties(HttpServletRequest req) {
        String startDate = req.getParameter("startDate").toString();
        String endDate = req.getParameter("endDate").toString();
        String origin = req.getParameter("origin").toString();
        String destination = req.getParameter("destination").toString();
        int seats = Integer.parseInt(req.getParameter("seats").toString());
        String comfortClass = req.getParameter("class").toString();
        int requestID = Integer.parseInt(req.getParameter("request_id").toString());
        int userID = Integer.parseInt(req.getParameter("user_id").toString());
        String type = req.getParameter("type").toString();
        properties = new Properties(startDate, endDate, origin, destination, seats,
                comfortClass, requestID, userID, type);
        logger.info(properties);
    }

    private void setFormProperties() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(UNITED_URL);
        driver.findElement(By.cssSelector(".modalCloseImg.simplemodal-close")).click();
        driver.findElement(By.id("uniform-SearchTypeMain_oneWay")).click();
        driver.findElement(By.id("Origin")).sendKeys(properties.getOrigin());
        driver.findElement(By.id("Destination")).sendKeys(properties.getDestination());
        driver.findElement(By.id("DepartDate")).sendKeys(properties.getStartDate());
        WebElement dates = driver.findElement(By.cssSelector("#DepartDate+button"));
        dates.click();
        Thread.sleep(500);
        int seats = properties.getSeats();
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
        dropdown.selectByValue(this.parseFlightClass(properties.getComfortClass()));
        driver.findElement(By.id("flightBookingSubmit")).click();
    }


    private static String parseFlightClass(String flightClass) {
        if (flightClass.contains("\"F\"") && flightClass.contains("\"B\"")) {
            return "awardBusinessFirst";
        }
        if (flightClass.contains("\"E\"") || flightClass.contains("\"P\"")) {
            return "awardEcon";
        }
        if (flightClass.contains("\"F\"")) {
            return "awardFirst";
        }
        return "awardEcon";
    }

}
