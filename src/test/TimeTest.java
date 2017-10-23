package test;

import model.Time;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TimeTest {
    Time testTime;

    @Before
    public void setUP(){

    }

    @Test
    public void TestTime(){
        testTime = new Time(24,0);
        assertEquals(testTime.getHour(),24);
        assertEquals(testTime.getMinute(),0);
    }
}
