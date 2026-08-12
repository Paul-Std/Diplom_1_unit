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
    public void recipeCreationTest() {
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
    }

    @Test
    public void recipeDesignBunsTest() {
        burger = new Burger();
        burger.setBuns(bunMock);

        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn(100f);

        when(testIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(testIngredient.getName()).thenReturn("hot sauce");
        when(testIngredient.getPrice()).thenReturn(50f);

        burger.addIngredient(testIngredient);

        String receipt = burger.getReceipt();


        assertTrue(receipt.contains("(==== black bun ====)"));
    }

    @Test
    public void recipeDesignFillingTest() {
        burger = new Burger();
        burger.setBuns(bunMock);

        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn(100f);

        when(testIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(testIngredient.getName()).thenReturn("hot sauce");
        when(testIngredient.getPrice()).thenReturn(50f);

        burger.addIngredient(testIngredient);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains("= sauce hot sauce ="));
    }

    @Test
    public void recipeDesignPriceTest() {
        burger = new Burger();
        burger.setBuns(bunMock);

        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn(100f);

        when(testIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(testIngredient.getName()).thenReturn("hot sauce");
        when(testIngredient.getPrice()).thenReturn(50f);

        burger.addIngredient(testIngredient);

        String receipt = burger.getReceipt();
        
        assertTrue(receipt.contains("Price:"));
    }

    @Test
    public void creationOfRecipeBunsNameTest() {
        burger = new Burger();
        burger.setBuns(bunMock);

        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn(100f);

        when(testIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(testIngredient.getName()).thenReturn("hot sauce");
        when(testIngredient.getPrice()).thenReturn(50f);

        burger.addIngredient(testIngredient);
        String receipt = burger.getReceipt();

        verify(bunMock, times(2)).getName();
    }

    @Test
    public void creationOfRecipeBunsPriceTest() {
        burger = new Burger();
        burger.setBuns(bunMock);

        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn(100f);

        when(testIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(testIngredient.getName()).thenReturn("hot sauce");
        when(testIngredient.getPrice()).thenReturn(50f);

        burger.addIngredient(testIngredient);
        String receipt = burger.getReceipt();

        verify(bunMock, times(1)).getPrice();
    }

    @Test
    public void creationOfRecipeIngredientTypeTest() {
        burger = new Burger();
        burger.setBuns(bunMock);

        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn(100f);

        when(testIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(testIngredient.getName()).thenReturn("hot sauce");
        when(testIngredient.getPrice()).thenReturn(50f);

        burger.addIngredient(testIngredient);
        String receipt = burger.getReceipt();

        verify(testIngredient, times(1)).getType();
    }

    @Test
    public void creationOfRecipeIngredientNameTest() {
        burger = new Burger();
        burger.setBuns(bunMock);

        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn(100f);

        when(testIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(testIngredient.getName()).thenReturn("hot sauce");
        when(testIngredient.getPrice()).thenReturn(50f);

        burger.addIngredient(testIngredient);
        String receipt = burger.getReceipt();

        verify(testIngredient, times(1)).getName();
    }

    @Test
    public void creationOfRecipeIngredientPriceTest() {
        burger = new Burger();
        burger.setBuns(bunMock);

        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn(100f);

        when(testIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(testIngredient.getName()).thenReturn("hot sauce");
        when(testIngredient.getPrice()).thenReturn(50f);

        burger.addIngredient(testIngredient);
        String receipt = burger.getReceipt();

        verify(testIngredient, times(1)).getPrice();
    }
}
