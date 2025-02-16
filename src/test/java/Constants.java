import java.util.Random;

public class Constants {

    /// / Bun types
    public static final String BLACK_BUN = "black bun";
    public static final String RYE_BUN = "ржаная булочка";
    public static final String WHITE_BUN = "white bun";
    public static final String RED_BUN = "red bun";
    /// / Sauces
    public static final String HOT_SAUCE = "hot sauce";
    public static final String SOUR_CREAM = "sour cream";
    public static final String CHILI_SAUCE = "chili sauce";

    /// / Filling
    public static final String CUTLET = "cutlet";
    public static final String DINOSAUR = "dinosaur";
    public static final String SAUSAGE = "sausage";

    public static final float DELTA = 0f;

    public static String[] Ingredients = {BLACK_BUN, RYE_BUN, WHITE_BUN,
                                          RED_BUN, HOT_SAUCE, SOUR_CREAM,
                                          CHILI_SAUCE, CUTLET, DINOSAUR, SAUSAGE};
    public static String getIngredient(){
        Random random = new Random();
        return Ingredients[random.nextInt(Ingredients.length)];
    }

    public static final String ASSERTION_FAILED_MSG = "Результат теста не соответствует ожидаемому";
}
