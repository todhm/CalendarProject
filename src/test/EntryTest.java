package test;

import model.Date;
import model.Entry;
import model.Time;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class EntryTest {
    Entry testEntry;


    Date date;
    Time time;
    String label;

    @Before
    public void setUp(){
        this.date= new Date(2017,10,1);
        this.time= new Time(10,0);
        
    }

    //Todo: Set UP properly.
    @Test
    public void setUpProperly(){
        assertEquals(testEntry.getDate(),this.date);
        assertEquals(testEntry.getTime(),this.time);
        assertEquals(testEntry.getLabel(),this.label);

    }

    @Test
    public void setInterval(){
        testEntry.setInterval(10);
        int interval = testEntry.getInterval();
        assertEquals(interval,interval);
    }

}
