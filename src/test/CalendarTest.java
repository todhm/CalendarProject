package test;

import helper.Helper;
import model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CalendarTest {


    Calendar testCalendar;
    Date testDate;
    Time testTime;
    RemainderTest Rtest;
    Helper hp;

    ArrayList<Integer> yearList;
    ArrayList<Integer> monthList;
    ArrayList<Integer> dayList;
    int totalEntrySize;

    String meetingLabel;
    String eventLabel;
    String remainderLabel;

    String noLabel;





    @Before
    public void setUp(){
        hp = new Helper();
        testDate = hp.returnRandomDate();
        testCalendar = new Calendar(testDate, "gmlaud14@gmail.com");
        yearList =  new ArrayList<Integer>();
        monthList = new ArrayList<Integer>();
        dayList = new ArrayList<Integer>();
        yearList.add(2017);
        yearList.add(2018);
        yearList.add(2019);

        for(int i =0 ; i < 12; i++){
            monthList.add(i + 1);
        }
        for(int i = 0; i<31; i++){
            dayList.add(i+1);
        }

        String minimumDate = String.valueOf(yearList.get(0)) + String.valueOf(monthList.get(0)) + String.valueOf(dayList.get(0));
        meetingLabel = minimumDate + "Meeting";
        eventLabel = minimumDate + "Event";
        remainderLabel = minimumDate + "Remainder";

        totalEntrySize = yearList.size() * monthList.size() * dayList.size() * 3;

        noLabel = minimumDate;

        for(int year : yearList){
            for(int month: monthList){
                for(int day : dayList){
                    String testLabel = String.valueOf(year)+ String.valueOf(month)+ String.valueOf(day);
                    Date testDate = new Date(year,month,day);
                    Time testTime = new Time(10,10);

                    Event event = new Event(testDate, testTime, testLabel+"Event");
                    Meeting meeting = new Meeting(testDate, testTime, testLabel + "Meeting");
                    Remainder remainder = new Remainder(testDate, testTime, testLabel + "Remainder");
                    testCalendar.addEntry(event);
                    testCalendar.addEntry(meeting);
                    testCalendar.addEntry(remainder);


                }
            }
        }

    }



    //Todo: Event added properly.
    @Test
    public void eventAddedProperly(){
        ArrayList<Object> testList = testCalendar.getEntries();
        assertEquals(testList.size(),totalEntrySize);
        testCalendar.removeEntry(meetingLabel);
        assertEquals(testList.size(), totalEntrySize-1);

    }






    //Todo: get Nearest Entry Properly.
    @Test
    public void getNearestEntryProperly(){
        Event nearestEvent = (Event) testCalendar.nearestEntry();
        assertEquals(nearestEvent.getLabel(),"201711Event");
        testCalendar.removeEntry("201711Meeting");
        testCalendar.removeEntry("201711Event");
        Remainder nearestRemainder = (Remainder) testCalendar.nearestEntry();
        assertEquals(nearestRemainder.getLabel(),"201711Remainder");

    }



    // Todo:get specific Entry list correctly.
    @Test
    public void getSpecifiedEntry(){
        int listSize = totalEntrySize / 3;
        ArrayList<Object> testMeetingList = testCalendar.entryByClassName("Meeting");
        assertEquals(testMeetingList.size(),listSize);
        for(Object entrymeeting : testMeetingList){
            Meeting meeting = (Meeting) entrymeeting;
            assertEquals(meeting.getClass().getSimpleName(),"Meeting");
        }
        ArrayList<Object> testEventList = testCalendar.entryByClassName("Event");
        assertEquals(testEventList.size(),listSize);
        for(Object entryevent : testEventList){
            Event event = (Event) entryevent;
            assertEquals(event.getClass().getSimpleName(),"Event");
        }
        ArrayList<Object> testRemainderList = testCalendar.entryByClassName("Remainder");
        assertEquals(testRemainderList.size(),listSize);
        for(Object entryremainder : testRemainderList){
            Remainder remainder = (Remainder) entryremainder;
            assertEquals(remainder.getClass().getSimpleName(),"Remainder");
        }

    }


    //Todo: get Entry by Name;
    @Test
    public void getEntryByLabel(){
        Meeting selectedMeetingLabel = (Meeting) testCalendar.entryByName(meetingLabel);
        assertEquals(selectedMeetingLabel.getLabel(),meetingLabel);

        Event selectedEventLabel = (Event) testCalendar.entryByName(eventLabel);
        assertEquals(selectedEventLabel.getLabel(),eventLabel);

        Remainder selectedRemainderLabel = (Remainder) testCalendar.entryByName(remainderLabel);
        assertEquals(selectedRemainderLabel.getLabel(),remainderLabel);

        assertFalse((Boolean) testCalendar.entryByName(noLabel));




    }




}
