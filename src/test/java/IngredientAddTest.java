import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;


@RunWith(Parameterized.class)
public class IngredientAddTest {
    private Burger burger;
    private int ingredientsCount;

    public IngredientAddTest(int ingredientsCount){
        this.ingredientsCount = ingredientsCount;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {1},
                {2},
                {4}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient ingredientMock;

    @Test
    public void ingredientSizeTest() {
        burger = new Burger();
        burger.setBuns(bunMock);
        
        for (int i = 0; i < ingredientsCount; i++) {
            burger.addIngredient(ingredientMock);
        }
        
        assertEquals(ingredientsCount, burger.ingredients.size());
    }

    @Test
    public void ingredientNameTest() {
        burger = new Burger();
        burger.setBuns(bunMock);

        for (int i = 0; i < ingredientsCount; i++) {
            burger.addIngredient(ingredientMock);
        }

        assertSame(ingredientMock, burger.ingredients.get(0));
    }
}
