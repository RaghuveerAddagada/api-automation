package Sample;

import org.testng.annotations.Test;

public class A {


    public void meth1(String name, boolean... optionalFlag) {

        boolean flag = (optionalFlag.length >= 1) ? optionalFlag[0] : false;
        System.out.println("flag value :" + flag);
    }

    @Test
    public void testData() {
        meth1( "raghu", false);
    }
}
