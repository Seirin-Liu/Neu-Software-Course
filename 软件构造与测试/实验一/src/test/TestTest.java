package test;

import static org.junit.Assert.assertEquals;

public class TestTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }


    @org.junit.Test
    /**
     * 白盒测试
     */
    public void main() {
        //Test为测试类
        assertEquals("100,10.0", Test.test(1,1,1,1));
        assertEquals("1050,107.5", Test.test(10,10,12,2));
        assertEquals("2000,260.0", Test.test(20,20,20,3));
        assertEquals("输入值异常", Test.test(71,40,40,4));
        assertEquals("输入值异常", Test.test(40,81,40,5));
        assertEquals("输入值异常", Test.test(40,40,91,6));
        assertEquals("输入值异常", Test.test(0,40,40,7));
        assertEquals("输入值异常", Test.test(40,0,40,8));
        assertEquals("输入值异常", Test.test(40,40,0,9));
    }
}