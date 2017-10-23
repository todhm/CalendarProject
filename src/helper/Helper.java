package helper;

import model.Date;
import model.Time;

import java.util.Random;

public class Helper {
    Random random ;

    public Helper(){
        random = new Random();
    }



    //Effects: pick the number between max and min.
    public int returnRandom(int max , int min){
        return random.nextInt(max - min + 1) + min;
    }

    public Date returnRandomDate(){
        int randyear = returnRandom(2050,2000);
        int randmonth = returnRandom(12,1);
        int randday = returnRandom(31,1);
        Date returnDate =  new Date(randyear,randmonth,randday);
        return returnDate;

    }

    public Time returnRandomTime(){
        int randhour = returnRandom(23,0);
        int randminute = returnRandom(59,0);
        Time returnTime = new Time(randhour,randminute);
        return returnTime;

    }




}
