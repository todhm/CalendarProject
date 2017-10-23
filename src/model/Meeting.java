package model;

import java.util.ArrayList;

public class Meeting extends Event{


    private ArrayList<Remainder> remainderList;
    private ArrayList<String> atendeeList;


    public Meeting(Date date, Time time, String label){
        super(date,time,label);
        atendeeList = new ArrayList<>();

    }

    //Getter.
    public ArrayList<String> getAtendeeList() {
        return atendeeList;
    }


    //Modifies: this.
    //Effects add email in atendeeList
    public void addEmail(String email){
        for(String atendeeEmail : atendeeList){
            if(atendeeEmail == email ){
                return ;
            }
        }
        atendeeList.add(email);
    }


    //Modifies: this.
    //Effects erase email in atendeeList if exists  and return true.
    public boolean removeEmail(String email){
        boolean exists = atendeeList.contains(email);
        if(exists){
            atendeeList.remove(email);
            return exists;
        }
        else{
            return false;
        }
    }

    //Effects: Send invitation to given atendeeList.
    public void sendInvitation(){
        for(String email : atendeeList){
            System.out.println("Invitation was sended to: " + email);
        }


    }


}
