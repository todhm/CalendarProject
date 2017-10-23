package test;

import model.Meeting;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MeetingTest extends EventTest{

    Meeting testMeeting;
    String testEmail;
    String testEmail2;
    String testEmail3;
    String testEmail4;


    @Override
    public void setUp(){
        super.setUp();
        String label = "testMeeting";
        testMeeting =  new Meeting(date,time,label);
        testEmail ="todhm@nate.com";
        testEmail2 ="gmlaud@nate.com";
        testEmail3 ="gmlaud14@nate.com";
        testEmail4 ="jordang@nate.com";


    }

    public void checkContainEmail(String email){
        assertTrue(testMeeting.getAtendeeList().contains(email));

    }

    public void removeAndCheck(String email){
        testMeeting.removeEmail(email);
        assertFalse(testMeeting.getAtendeeList().contains(email));

    }


    public void addEmailList(String email){
        testMeeting.addEmail(email);
    }

    @Test
    public void testAttendList(){

        addEmailList(testEmail);
        assertTrue(testMeeting.getAtendeeList().contains(testEmail));
        removeAndCheck(testEmail);

    }



    @Test
    public void testMultipleEmailList(){

        addEmailList(testEmail);
        addEmailList(testEmail2);
        addEmailList(testEmail3);
        addEmailList(testEmail4);
        checkContainEmail(testEmail);
        checkContainEmail(testEmail2);
        checkContainEmail(testEmail3);
        checkContainEmail(testEmail4);

        assertEquals(testMeeting.getAtendeeList().size(),4);
        addEmailList(testEmail);
        assertEquals(testMeeting.getAtendeeList().size(),4);
        removeAndCheck(testEmail2);


    }


    @Test
    public void sendInvitationCorrectly(){
        addEmailList(testEmail);
        addEmailList(testEmail2);
        addEmailList(testEmail3);
        addEmailList(testEmail4);
        testMeeting.sendInvitation();
    }





}
