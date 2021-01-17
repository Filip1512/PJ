import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class NWWandNWDTests {

    int mockObj;

    @Test
    public void test_CheckNWD(){
        //given
        NWWandNWD mock = Mockito.mock(NWWandNWD.class);

        //when + then
        Mockito.when(mock.nwd(6,10)).thenReturn(2);
        mockObj = mock.nwd(6,10);
        Assert.assertEquals(2, mockObj);
    }

    @Test
    public void test_CheckNWW(){
        //given
        NWWandNWD mock = Mockito.mock(NWWandNWD.class);

        //when + then
        Mockito.when(mock.nwd(2,3)).thenReturn(6);
        mockObj = mock.nwd(2,3);
        Assert.assertEquals(6, mockObj);
    }

    @Test
    public void test_CheckCalc(){
        //given
        NWWandNWD mock = Mockito.mock(NWWandNWD.class);

        //when + then
        Mockito.when(mock.calc(2,6, "+")).thenReturn(8);
        mockObj = mock.calc(2,6, "+");
        Assert.assertEquals(8, mockObj);
    }

}
