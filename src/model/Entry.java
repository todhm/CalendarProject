package model;

public abstract class Entry  {
    Date date;
    Time time;
    String label;
    int interval;
    boolean isRepeating;


    public Entry(Date date, Time time, String label) {
        this.date = date;
        this.time = time;
        this.label = label;

    }

    //Getters
    public Date getDate(){ return date;}
    public Time getTime(){ return time;}
    public String getLabel(){ return label;}
    public int getInterval(){return interval; }
    public boolean getRepeating(){return isRepeating; }



    //Setters
    public void setInterval(int interval ){ this.interval = interval; }



}
