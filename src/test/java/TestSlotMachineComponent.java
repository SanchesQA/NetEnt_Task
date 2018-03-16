
import listeners.TestNGListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners (TestNGListeners.class)
public class TestSlotMachineComponent extends BaseTest{


    @Test
    public void testSpitButtonIsDisabledWhenMachineIsSpinning(){
        SlotMachineComponent slotMachine = new SlotMachineComponent(driver);
        slotMachine.open()
                .spinIt();
        Assert.assertTrue(slotMachine.checkThatSpinButtonIsDisabled());
    }
    @Test
    public void verifyInitialBetSpinUpValue(){
        SlotMachineComponent slotMachine = new SlotMachineComponent(driver);
        slotMachine.open();
        Assert.assertEquals(slotMachine.getBetElementText(), "1");
    }
    @Test
    public void testBetMaxValue(){
        SlotMachineComponent slotMachine = new SlotMachineComponent(driver);
        slotMachine.open()
                .clickBetUp(10);
        Assert.assertEquals(slotMachine.getBetElementText(), "10");
    }

    @Test
    public void testBetValueCanBeDecreased()  {
        SlotMachineComponent slotMachine = new SlotMachineComponent(driver);
        slotMachine.open()
                .clickBetUp(5)
                .clickBetDown(2);
        Assert.assertEquals(slotMachine.getBetElementText(), "4");
    }

    @Test
    public void testWinChartIsDisplayed(){
        SlotMachineComponent slotMachine = new SlotMachineComponent(driver);
        slotMachine.open();
        Assert.assertTrue(slotMachine.winChartIsDisplayed());
    }

    @Test
    public void testPayOutValues()  {
        SlotMachineComponent slotMachine = new SlotMachineComponent(driver);
        slotMachine.open()
          .clickBetUp(2);
        Assert.assertTrue(slotMachine.compareTableVlues());
    }

    @Test
    public void winBehaviorTest() {
        SlotMachineComponent slotMachine = new SlotMachineComponent(driver);
        slotMachine.open().spinNumberOfTimesUntilWin(10);
        SoftAssert check = new SoftAssert();
        check.assertTrue(slotMachine.prizeIsHighlighted());
        check.assertTrue(slotMachine.compareWinValues());
        check.assertAll();
    }


}
