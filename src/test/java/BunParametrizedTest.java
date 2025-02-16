import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParametrizedTest {

    private String bunName;
    private float bunPrice;
    private Bun bun;


    public BunParametrizedTest(String bunName, float bunPrice){
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {Constants.BLACK_BUN, Float.MIN_VALUE},
                {Constants.BLACK_BUN, Float.MAX_VALUE},
                {Constants.RYE_BUN, 100},
                {"", 100},
                {null, 100},
                {"1", 100},
                {"!", 100},
                {Constants.RYE_BUN, -100},
                {Constants.RYE_BUN, 0}
        };
    }

    @Before
    public void rpepare() {
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void getBunNameTest(){
        Assert.assertEquals(Constants.ASSERTION_FAILED_MSG, bunName, bun.getName());
    }

    @Test
    public void getBunPriceTest(){
        Assert.assertEquals(Constants.ASSERTION_FAILED_MSG, bunPrice, bun.getPrice(), Constants.DELTA);
    }
}
