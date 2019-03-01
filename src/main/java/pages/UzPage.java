package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class UzPage {

    protected WebDriver driver;

    public UzPage(WebDriver driver) {
        logger.info("loading page: " + this.getClass().getSimpleName());
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.info("Page loaded: " + this.getClass().getSimpleName());
    }

    public static final String KYIV = "Kyiv";
    public static final String XPATH_CITY_FROM_DROP_DOWN_KYIV = "//ul[@id='ui-id-1']/li[text()='" + KYIV + "']";
    public static final String ODESA = "Odesa";
    public static final String XPATH_CITY_TO_DROP_DOWN_ODESA = "//ul[@id='ui-id-2']/li[text()='" + ODESA + "']";


    @FindBy(name = "from-title")
    private WebElement inputFrom;

    @FindBy(name = "to-title")
    private WebElement inputTo;

    @FindBy(xpath = XPATH_CITY_FROM_DROP_DOWN_KYIV)
    private WebElement cityFromDropDownKyiv;

    @FindBy(xpath = XPATH_CITY_TO_DROP_DOWN_ODESA)
    private WebElement cityToDropDownOdesa;


    public Logger logger = Logger.getLogger(this.getClass());


    public void setCityFromKyiv() {
        inputFrom.click();
        inputFrom.sendKeys(KYIV);
        WebElement cityFromDropDownKyiv = driver.findElement(By.xpath(XPATH_CITY_FROM_DROP_DOWN_KYIV));
        waitForVisibility(cityFromDropDownKyiv);
        cityFromDropDownKyiv.click();

    }

    public void setCityToOdesa() {
        inputTo.click();
        inputTo.sendKeys(ODESA);
        waitForVisibility(cityToDropDownOdesa);
        cityToDropDownOdesa.click();
    }




    /*
    If input param element is initialized using annotation @FindBy wait works correctly
    If input param element is initialized by calling driver.findElement(...) method than
        wait is not applied and NoSuchElement exception is being thrown.
    */
    protected void waitForVisibility(WebElement element) throws Error {
        logger.debug("waiting till element " + element.toString() + " loaded");
        /*incorrect using ExpectedConditions.visibilityOf(element). Method visibilityOf(element)
        supposed to be used when it is known that element is present in DOM, just for checking visibility.
        Used incorrectly just to show different behavior between @FindBy and direct finding element
        by driver.findElement()
        */
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
        logger.debug("waiting till element " + element.toString() + " loaded...Done");
    }

}
