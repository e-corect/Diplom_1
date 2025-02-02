import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    private Bun bun;

    private Burger burger;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;

    @Before
    public void prepare(){
        MockitoAnnotations.openMocks(this);

        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
    }

    @Test
    public void setBunsTest(){
        Assert.assertEquals(Constants.ASSERTION_FAILED_MSG, burger.bun, bun);
    }

    @Test
    public void addIngredientTest(){
        Assert.assertEquals(Constants.ASSERTION_FAILED_MSG, ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest(){
        burger.removeIngredient(1);
        Assert.assertEquals(Constants.ASSERTION_FAILED_MSG, ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientTest(){
        burger.moveIngredient(0,1);
        Assert.assertEquals(Constants.ASSERTION_FAILED_MSG, ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest(){
        Mockito.when(burger.getPrice()).thenReturn((float)555);
        Assert.assertEquals(Constants.ASSERTION_FAILED_MSG, 555, burger.getPrice(), Constants.DELTA);
    }

    @Test
    public void getReceiptTest(){
        Mockito.when(bun.getName()).thenReturn(Constants.WHITE_BUN);
        Mockito.when(burger.getPrice()).thenReturn(200f);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn(Constants.HOT_SAUCE);
        Mockito.when(ingredient1.getPrice()).thenReturn(100f);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn(Constants.DINOSAUR);
        Mockito.when(ingredient2.getPrice()).thenReturn(200f);
        StringBuilder receipt = new StringBuilder();
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(), ingredient1.getName()));
        receipt.append(String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(), ingredient2.getName()));
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        Assert.assertEquals(Constants.ASSERTION_FAILED_MSG, true, receipt.toString().equals(burger.getReceipt()));
    }
}
