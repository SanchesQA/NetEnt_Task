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
}
