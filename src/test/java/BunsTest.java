import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import praktikum.Bun;
import praktikum.Burger;

import static org.junit.Assert.assertSame;


@RunWith(MockitoJUnitRunner.class)
public class BunsTest {

    private Burger burger;

    @Mock
    private Bun bunMock;
    
    @Test
    public void burgerSetBunTest() {
        burger = new Burger();
        
        burger.setBuns(bunMock);

        assertSame(bunMock, burger.bun);
    }
}
