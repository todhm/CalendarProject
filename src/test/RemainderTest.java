package test;

import model.Remainder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemainderTest extends EntryTest {

    Remainder testRemainder;

    @Override
    public void setUp(){
        super.setUp();
        label = "test Remainder";
        testEntry = new Remainder(date,time,label);
        testRemainder = new Remainder(date,time,label);
    }


    @Test
    public void setNoteProperly(){
        String testNote = "Jordan";
        testRemainder.setNote(testNote);
        assertEquals(testRemainder.getNote(),testNote);
    }






}
