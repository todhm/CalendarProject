package model;

import java.util.ArrayList;

public class Event extends Entry{

    private int date;
    private int time;
    private String label;
    private ArrayList<Remainder> remainderList;

    public Event(Date date, Time time, String label){
        super(date,time,label);
        remainderList = new ArrayList<>();

    }

    //Getter.
    public ArrayList<Remainder> getRemainderList(){ return remainderList; }

    //Setter.
    public void setRemainderList(Remainder rm){

        for(int i =0 ; i < remainderList.size() ; i++){
            if(remainderList.get(i).getLabel() == rm.getLabel()){
                remainderList.set(i,rm);
                return ;
            }
        }
        remainderList.add(rm);
    }


    public Remainder findRemainder(String labelname){
        for(Remainder rem : remainderList){
            if(rem.getLabel() == labelname){
                return rem;
            }

        }

        return null;

    }


}
