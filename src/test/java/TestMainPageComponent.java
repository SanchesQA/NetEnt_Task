import listeners.TestNGListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
public class TestMainPageComponent extends BaseTest{
    @Test
    public void testAllNavMenuIsDisplayed() {
        MainPageComponent main = new MainPageComponent(driver);
        main.open();
        Assert.assertTrue(main.allNavMenuIsDisplayed());

    }

    @Test
    public void testSkinChange() throws Exception{
        MainPageComponent main = new MainPageComponent(driver);
        SlotMachineComponent slot = main.open().clickExampleSkin();
        Assert.assertTrue(slot.skinBackgChanged(), "BackGround is not changed correctly");
    }
}
