import org.junit.After;
import org.junit.Before;

public class Test {

    @Before
    public void before(){
        System.out.println("Test.before");
    }

    @org.junit.Test
    public void test(){
        System.out.println("Test.test");
    }

    @After
    public void after(){
        System.out.println("Test.after");
    }


}
