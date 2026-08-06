import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertSame;


@RunWith(MockitoJUnitRunner.class)
public class IngredientReplacerTest {
    private Burger burger;

    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient tomat;

    @Mock
    private Ingredient potat;

    @Test
    public void ReplaceIngredient() {
        burger = new Burger();
        burger.setBuns(bunMock);
        
        burger.addIngredient(tomat);
        burger.addIngredient(potat);
        
        burger.moveIngredient(0, 1);
        
        assertSame(potat, burger.ingredients.get(0));
        assertSame(tomat, burger.ingredients.get(1));
    }
}
