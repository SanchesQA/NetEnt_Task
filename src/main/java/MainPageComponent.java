import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class MainPageComponent  extends BaseComponent{


    public MainPageComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath ="//nav[@class='nav']//a[contains(@href,'overview')]")
    private WebElement overviewNav;
    private static final java.lang.String URL = "http://slotmachinescript.com/";
    @FindBy (xpath ="//nav[@class='nav']//a[contains(@href,'testimonials')]")
    private WebElement testimonialsNav;

    @FindBy (xpath ="//nav[@class='nav']//a[contains(@href,'buy_now')]")
    private WebElement buyNowNav;

    public MainPageComponent open() {
        driver.get(URL);
        return this;
    }

    @FindBy(xpath = "//a[@data-example='2']")
    WebElement exampleSkin;



    public SlotMachineComponent clickExampleSkin(){
        exampleSkin.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new SlotMachineComponent(driver);
    }

    public MainPageComponent clickOverviewNav(){
        overviewNav.click();
        return this;
    }
    public MainPageComponent clickTestimonialsNav(){
        testimonialsNav.click();
        return this;
    }
    public MainPageComponent clickBuyNowNav(){
        buyNowNav.click();
        return this;
    }

    public boolean allNavMenuIsDisplayed(){
        return (overviewNav.isDisplayed() & testimonialsNav.isDisplayed() & buyNowNav.isDisplayed());
    }

}
