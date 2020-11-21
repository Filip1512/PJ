import org.junit.*;

import java.util.concurrent.ThreadLocalRandom;

public class NWWTests {

    @Test
    public void nww_EqualsRandomNumbersHigherThanTwo() {

        NWWClass nwwtesting = new NWWClass();

        Assert.assertEquals(6, nwwtesting.nww(2, 3));
        Assert.assertEquals(4, nwwtesting.nww(2, 4));
        Assert.assertEquals(15, nwwtesting.nww(3, 5));
        Assert.assertEquals(50, nwwtesting.nww(10, 25));
    }

    @Test (expected = IllegalArgumentException.class)
    public void nww_CheckNegativeNumberException(){

        NWWClass nwwtesting = new NWWClass();
        nwwtesting.nww(-1, -1);
        nwwtesting.nww(5, -1);
        nwwtesting.nww(-1, 5);
        Assert.fail("Liczba musi być większa niż 1!");
    }


    @Test(expected = ArithmeticException.class)
    public void nww_CheckZeroException() {
        NWWClass nwwtesting = new NWWClass();
        int randomNumber = ThreadLocalRandom.current().nextInt(2, 500 + 1);

        nwwtesting.nww(0, 0);
        nwwtesting.nww(0, randomNumber);
        nwwtesting.nww(randomNumber, 0);

        Assert.fail("To nie jest liczba!");
    }

/*
    @Test(expected = InputMismatchException.class)
    public void nww_InputMismatchException() {
        Assert.fail();
    }

        //nie wiem jak to obsłużyć
    @Test(expected = InputMismatchException.class)
    public void nww_CheckZeroException(){

    }
*/

}