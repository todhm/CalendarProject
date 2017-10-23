package test;

import model.Date;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateTest {
    Date testDate;
    Date testDate2;
    Date testDate3;
    Date testDate4;

    @Before
    public void setUP(){
        testDate = new Date(2017,10,17);
        testDate2 = new Date(2017,11,10);
        testDate3 = new Date(2018,11,10);
        testDate4 = new Date(2019,11,10);

    }

    @Test
    public void TestDate(){
        assertEquals(testDate.getShortDate(),"10/17/2017");
        assertEquals(testDate2.getShortDate(),"11/10/2017");
        assertEquals(testDate3.getShortDate(),"11/10/2018");
        assertEquals(testDate4.getShortDate(),"11/10/2019");

        assertEquals(testDate.getLongDate(),"October 17,2017 Tuesday");
        assertEquals(testDate2.getLongDate(),"November 10,2017 Friday");
        assertEquals(testDate3.getLongDate(),"November 10,2018 Saturday");
        assertEquals(testDate4.getLongDate(),"November 10,2019 Sunday");


    }
}
