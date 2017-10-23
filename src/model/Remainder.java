package model;

public class Remainder extends Entry{
    private String note ;

    public Remainder(Date date, Time time, String label) {
        super(date, time, label);
    }


    //Getter
    public String getNote(){ return note; }

    //Setter
    public void setNote(String note){ this.note = note; }
}
