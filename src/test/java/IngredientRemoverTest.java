import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@RunWith(MockitoJUnitRunner.class)
public class IngredientRemoverTest {

    private Burger burger;
    
    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient tomat; // можно как отдельный объект.

    @Mock
    private Ingredient potat;

    @Test
    public void IngredientRemover() {
        burger = new Burger();
        burger.setBuns(bunMock);
        
        burger.addIngredient(tomat);
        burger.addIngredient(potat);
        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertSame(potat, burger.ingredients.get(0));

    }
}
