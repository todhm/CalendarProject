package ui;

import model.*;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        Date newDate = new Date(2017,10,1);
        Time newTime = new Time(10,10);
        String email = "gmlaud14@gmail.com";
        Calendar newCalendar = new Calendar(newDate,email);

        Date eventDate = new Date(2017,12,31);
        Time eventTime = new Time(10,31);
        Date meetingDate = new Date(2017,10,31);
        Time meetingTime = new Time(10,10);
        Date eventReminderDate = new Date(2018,10,11);
        Date eventMeetingDate = new Date(2018,1,1);

        Meeting newMeeting = new Meeting(meetingDate,meetingTime,"Google Meeting");
        Meeting newEvent = new Meeting(eventDate,eventTime,"Jordan Bell");

        newCalendar.addEntry(newMeeting);
        newCalendar.addEntry(newEvent);

        newCalendar.entryByName("Jordan Bell");
        ArrayList<Meeting> meetingList = newCalendar.entryByClassName("Meeting");
        for (Meeting meeting  : meetingList){
            System.out.println(meeting.getLabel());
            meeting.sendInvitation();
        }

        Entry nearestEntry = (Entry) newCalendar.nearestEntry();
        System.out.println(nearestEntry.getDate().getShortDate());



    }
}
