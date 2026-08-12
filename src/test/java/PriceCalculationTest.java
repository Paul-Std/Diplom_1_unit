import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PriceCalculationTest {

    private Burger burger;

    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient sauce;

    @Mock
    private Ingredient cutlet;

    @Test
    public void calculatePriceTest() {
        burger = new Burger();
        burger.setBuns(bunMock);
        
        when(bunMock.getPrice()).thenReturn(100f);
        when(sauce.getPrice()).thenReturn(50f);
        when(cutlet.getPrice()).thenReturn(150f);

        burger.addIngredient(sauce);
        burger.addIngredient(cutlet);

        float price = burger.getPrice();
        
        assertEquals(400f, price, 0.0001f);
    }

    @Test
    public void callBunsCalculationMethodTest() {
        burger = new Burger();
        burger.setBuns(bunMock);

        when(bunMock.getPrice()).thenReturn(100f);
        when(sauce.getPrice()).thenReturn(50f);
        when(cutlet.getPrice()).thenReturn(150f);

        burger.addIngredient(sauce);
        burger.addIngredient(cutlet);

        float price = burger.getPrice();
        
        verify(bunMock, times(1)).getPrice();
    }

    @Test
    public void callSauceCalculationMethodTest() {
        burger = new Burger();
        burger.setBuns(bunMock);

        when(bunMock.getPrice()).thenReturn(100f);
        when(sauce.getPrice()).thenReturn(50f);
        when(cutlet.getPrice()).thenReturn(150f);

        burger.addIngredient(sauce);
        burger.addIngredient(cutlet);

        float price = burger.getPrice();

        verify(sauce, times(1)).getPrice();
    }

    @Test
    public void callFillingCalculationMethodTest() {
        burger = new Burger();
        burger.setBuns(bunMock);

        when(bunMock.getPrice()).thenReturn(100f);
        when(sauce.getPrice()).thenReturn(50f);
        when(cutlet.getPrice()).thenReturn(150f);

        burger.addIngredient(sauce);
        burger.addIngredient(cutlet);

        float price = burger.getPrice();
        
        verify(cutlet, times(1)).getPrice();
    }
}
