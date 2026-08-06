import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class RecipeCreatorTest {

    private Burger burger;

    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient testIngredient;

    @Test
    public void CreationOfRecipe() {
        burger = new Burger();
        burger.setBuns(bunMock);
        
        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn(100f);

        when(testIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(testIngredient.getName()).thenReturn("hot sauce");
        when(testIngredient.getPrice()).thenReturn(50f);

        burger.addIngredient(testIngredient);

        String receipt = burger.getReceipt();

        assertNotNull(receipt);

        assertTrue(receipt.contains("(==== black bun ====)"));
        assertTrue(receipt.contains("= sauce hot sauce ="));
        assertTrue(receipt.contains("Price:"));

        verify(bunMock, times(2)).getName();
        verify(bunMock, times(1)).getPrice();

        verify(testIngredient, times(1)).getType();
        verify(testIngredient, times(1)).getName();
        verify(testIngredient, times(1)).getPrice();
        
    }
}
