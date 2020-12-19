import org.junit.*;

import java.util.InputMismatchException;
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

    @Test
    public void nww_ObjectIsNotNull(){

        NWWClass nwwtesting = new NWWClass();

        Assert.assertNotNull(nwwtesting);
    }

    @Test (expected = IllegalArgumentException.class)
    public void nww_CheckNegativeNumberException(){

        NWWClass nwwtesting = new NWWClass();
        nwwtesting.nww(-1, -1);
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


    @Test(expected = InputMismatchException.class)
    public void nww_InputMismatchException() {
        Assert.fail();
    }

    @Test
    public void nwd_EqualsSomeResults() {

        NWWClass nwwtesting = new NWWClass();

        Assert.assertEquals(2, nwwtesting.nwd(6, 10));
        Assert.assertEquals(5, nwwtesting.nwd(5, 15));
        Assert.assertEquals(6, nwwtesting.nwd(18, 24));
        Assert.assertEquals(25, nwwtesting.nwd(75, 100));
    }
    @Test
    public void calc_BasicOperations(){

        NWWClass nwwtesting = new NWWClass();

        Assert.assertEquals(4, nwwtesting.calc(2, 2, "+"));
        Assert.assertEquals(6, nwwtesting.calc(2, 3, "*"));
        Assert.assertEquals(5, nwwtesting.calc(6, 1, "-"));
        Assert.assertEquals(2, nwwtesting.calc(10, 5, "/"));
        Assert.assertEquals(0, nwwtesting.calc(10, 5, ""));
    }

    @Test
    public void nww_CalcAndNwd(){
        NWWClass nwwtesting = new NWWClass();

        Assert.assertEquals(15, nwwtesting.nww(nwwtesting.calc(1,2, "+"), nwwtesting.calc(10,2,"/")));
    }

}