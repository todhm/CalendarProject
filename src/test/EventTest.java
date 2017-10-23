package test;

import helper.Helper;
import model.Date;
import model.Event;
import model.Remainder;
import model.Time;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class EventTest extends EntryTest{
    private Event testEvent;
    Date date2;
    Date date3;
    Time time2;
    Time time3;
    Remainder testRemainder;
    Random random;
    Helper hp;




    @Override
    public void setUp(){
        super.setUp();
        this.label = "testEvent";
        testEntry = new Event(date,time,label);
        testEvent = new Event(date,time,label);
        date2 = new Date(2017,10,21);
        date3 = new Date(2018,3,10);
        time2 = new Time(9,10);
        time3 = new Time(10,30);
        testRemainder = new Remainder(date,time,"testRemainder");
        random = new Random();
        hp = new Helper();


    }


    @Test
    public void addRemainderProperly(){
        testEvent.setRemainderList(testRemainder);
        ArrayList remainderList = testEvent.getRemainderList();
        assertTrue(remainderList.contains(testRemainder));
    }

    @Test
    public void testMultipleRemainder(){
        testEvent.setRemainderList(testRemainder);
        Remainder testRemainder2 = new Remainder(date2,time2,"testRemainder2");
        Remainder testRemainder3 = new Remainder(date3,time3,"testRemainder3");
        testEvent.setRemainderList(testRemainder2);
        testEvent.setRemainderList(testRemainder3);
        ArrayList remainderList = testEvent.getRemainderList();
        assertTrue(remainderList.contains(testRemainder));
        assertTrue(remainderList.contains(testRemainder2));
        assertTrue(remainderList.contains(testRemainder3));
    }

    @Test
    public void testDuplicateRemainder(){
        testEvent.setRemainderList(testRemainder);
        testEvent.setRemainderList(new Remainder(date2,time2,"testRemainder"));
        ArrayList remainderList = testEvent.getRemainderList();
        assertEquals(remainderList.size(),1);
        assertEquals(testEvent.findRemainder("testRemainder").getDate(),date2);
        assertEquals(testEvent.findRemainder("testRemainder").getTime(),time2);

    }


    @Test
    public void testBigDataRemainder(){
        for(int i= 0 ; i< 10000; i++){


            Date randDate = hp.returnRandomDate();
            Time randTime = hp.returnRandomTime() ;

            String testBigString = "testBigString" + String.valueOf(i);

            Remainder testBigRem = new Remainder(randDate,randTime,testBigString);
            testEvent.setRemainderList(testBigRem);

            assertEquals(testEvent.findRemainder(testBigString),testBigRem);


        }

    }


}
