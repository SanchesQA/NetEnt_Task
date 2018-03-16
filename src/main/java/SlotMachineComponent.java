import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;



public class SlotMachineComponent  extends BaseComponent{
    private static final java.lang.String URL = "http://slotmachinescript.com/";

    @FindBy (id="spinButton")
    private  WebElement spinButton;

    @FindBy (id="betSpinUp")
    private  WebElement betSpinUpArrow;

    @FindBy(id="betSpinDown")
    private  WebElement betSpinDownArrow;

    @FindBy(id ="bet")
    private WebElement betCell;

    @FindBy (id="prizes_list")
    private WebElement winChart;

    @FindBy (xpath = "//div[@id='spinButton'][@class='disabled']")
    private  WebElement disabledSpinButton;

    @FindBy (xpath = "//div[@id='SlotsOuterContainer'][@class='won']")
    private WebElement wonStateSlotMachine;

    @FindBy (id="lastWin")
    private WebElement lastWin;

    @FindBy (id="credits")
    private WebElement credits;


    public SlotMachineComponent(WebDriver driver) {
        super(driver);


    }

    public SlotMachineComponent open() {
        driver.get(URL);
        return this;
    }

    public boolean checkThatSpinButtonIsDisabled(){
        return disabledSpinButton.isEnabled();
    }
    public SlotMachineComponent spinIt() {
        spinButton.click();
        return this;
    }

    public SlotMachineComponent clickBetUp(int numberOftimes){
        for (int i=0; i<numberOftimes; i++) {
            betSpinUpArrow.click();
        }
        return this;
    }
    public SlotMachineComponent clickBetUp(){
         betSpinUpArrow.click();
         return this;
    }

    public SlotMachineComponent clickBetDown(int numberOftimes){
        for (int i=0; i<numberOftimes; i++) {
            betSpinDownArrow.click();
        }
        return this;
    }

    public SlotMachineComponent clickBetDown(){
        betSpinDownArrow.click();
        return this;
    }

    public java.lang.String getBetElementText(){
           return betCell.getText();

    }

    public boolean winChartIsDisplayed(){
       return  winChart.isDisplayed();
    }

    public List getTableValues(){
        List<String> actualValues = new ArrayList<String>();
        List<WebElement> prize_values = winChart.findElements(By.xpath("//div[@id='prizes_list_slotMachine1']//span[@class='tdPayout']"));
        for (WebElement prize_value : prize_values){
            actualValues.add(prize_value.getText());
        }
        return actualValues;
    }


    public boolean compareTableVlues(){
         return getTableValues().equals(expectedValues());
    }

    public List expectedValues(){
        List<String> expected = new ArrayList<String>();
        expected.add("600");
        expected.add("150");
        expected.add("60");
        expected.add("48");
        expected.add("45");
        expected.add("42");
        expected.add("36");
        expected.add("21");
        expected.add("12");
        return expected;
    }

    public SlotMachineComponent spinNumberOfTimesUntilWin(int numberOfTimes){
        spinButton.click();
        for (int i=0; i<numberOfTimes; i++){
            while (driver.findElements(By.xpath("//div[@id='SlotsOuterContainer'][@class='won']")).isEmpty()){
                spinButton.click();
         }
        }
        return this;
    }

    public boolean prizeIsHighlighted(){
        return driver.findElement(By.cssSelector(".trPrize.won")).isDisplayed();
    }

    public String getPrizeValue(){
      return   driver.findElement(By.xpath("//div[@id='prizes_list']//div[@class='trPrize won']//span[@class='tdPayout']")).getText();
    }

    public boolean compareWinValues(){
        return getPrizeValue().contains(lastWin.getText());
    }

}
