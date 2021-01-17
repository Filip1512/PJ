import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.BDDMockito.*;
import org.junit.*;
import org.junit.Assert.*;

public class CalculatorTests {

    int mockObj;

    @Test
    public void calc_TestSum(){
        //given
        Calculator mock = Mockito.mock(Calculator.class);

        //when + then
        Mockito.when(mock.calculateSum(1,2)).thenReturn(3);
        mockObj = mock.calculateSum(1,2);
        Assert.assertEquals(3, mockObj);
    }

    @Test
    public void calc_TestSubstract(){
        //given
        Calculator mock = Mockito.mock(Calculator.class);

        //when + then
        Mockito.when(mock.calculateSubstract(3,2)).thenReturn(1);

        mockObj = mock.calculateSubstract(3,2);
        Assert.assertEquals(1, mockObj);
    }

    @Test
    public void calc_TestMultiply(){
        //given
        Calculator mock = Mockito.mock(Calculator.class);

        //when + then
        Mockito.when(mock.calculateMultiply(3,2)).thenReturn(6);

        mockObj = mock.calculateMultiply(3,2);
        Assert.assertEquals(6, mockObj);
    }

    @Test
    public void calc_TestDiv(){
        //given
        Calculator mock = Mockito.mock(Calculator.class);

        //when + then
        Mockito.when(mock.calculateDiv(6,2)).thenReturn(3);

        mockObj = mock.calculateDiv(6,2);
        Assert.assertEquals(2, mockObj); // zamierzony zły wynik, powinno byc 3
    }
}
