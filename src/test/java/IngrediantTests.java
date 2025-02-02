import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngrediantTests {

    private String ingredientName;

    private Ingredient ingredient;

    @Before
    public void prepare(){
        ingredientName = Constants.getIngredient();
        ingredient = new Ingredient(IngredientType.FILLING, ingredientName, 55.5f);
    }

    @Test
    public void getPrice(){
        Assert.assertEquals(Constants.ASSERTION_FAILED_MSG, 55.5f, ingredient.getPrice(), Constants.DELTA);
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals(Constants.ASSERTION_FAILED_MSG, ingredientName, ingredient.getName());
    }

    @Test
    public void getTypeTest(){
        Assert.assertEquals(Constants.ASSERTION_FAILED_MSG, IngredientType.FILLING, ingredient.getType());
    }
}
