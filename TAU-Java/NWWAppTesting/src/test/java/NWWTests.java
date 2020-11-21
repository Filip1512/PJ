import org.junit.*;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class NWWTests {

    NWWClass nwwtesting = new NWWClass();

    @Test
    public void nww_EqualsRandomNumbersHigherThanTwo() {
        Assert.assertEquals(6, nwwtesting.nww(2,3));
        Assert.assertEquals(4, nwwtesting.nww(2,4));
        Assert.assertEquals(15, nwwtesting.nww(3,5));
        Assert.assertEquals(50, nwwtesting.nww(10,25));
    }

    @Test(expected = ArithmeticException.class)
    public void nww_CheckZeroException(){
        int randomNumber = ThreadLocalRandom.current().nextInt(2, 500 + 1);
        nwwtesting.nww(0, 0);
        nwwtesting.nww(0, randomNumber);
        nwwtesting.nww(randomNumber, 0);
    }
/*
    @Test(expected = InputMismatchException.class)
    public void nww_CheckZeroException(){



    }



    @Test(expected = InputMismatchException.class)
    public void nww_InputMismatchException() {
        nwwtesting.nww(2, 5);
    }
*/
}
