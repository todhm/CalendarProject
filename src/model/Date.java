package model;

public class Date {
    private int day;
    private int year;
    private int month;

    public Date(int year,int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //Getter.
    public int getYear(){ return year; }

    public int getMonth(){ return month; }

    public int getDay(){ return day; }

    public String getShortDate(){ return String.valueOf(month) + "/" +String.valueOf(day) + "/" + String.valueOf(year);}


    public String getLongDate(){
        String dateString = "";
        dateString += getMonthString();
        dateString += " ";
        dateString += String.valueOf(day) + ",";
        dateString += String.valueOf(year);
        dateString += " " + getDayOfDate();


        return dateString;

    }



    //helper

    //Effects convert Month to String
    public String getMonthString(){
        String monthString = "";
        switch (month) {
            case 1    : monthString = "January";
                break;

            case 2    : monthString = "Febuary";
                break;
            case 3    : monthString = "March";
                break;
            case 4    : monthString = "April";
                break;
            case 5    : monthString = "May";
                break;
            case 6    : monthString = "June";
                break;
            case 7    : monthString = "July";
                break;
            case 8    : monthString = "August";
                break;
            case 9    : monthString = "September";
                break;
            case 10    : monthString = "October";
                break;
            case 11    : monthString = "November";
                break;
            case 12    : monthString = "December";
                break;
            default    : System.out.println("Invalid Month");
                         monthString = "";
                break;
        }

        return monthString;
    }
    //Effect return day of month of following date.
    public String getDayOfDate(){
        String dayString = "";
        int Y = ( month==1 || month == 2 ? year -1 : year );
        int y =  Y % 100;
        int c = Integer.parseInt(Integer.toString(Y).substring(0,2));
        int m = month - 2;
        if(m <= 0 ){
            m+= 10;
        }


        int w = (day + (int)(13*(m + 1) /5) + y + (int)(4/y) + (int)(c/4) - (2*c)) % 7;
        switch (w) {

            case 0:
                dayString = "Monday";
                break;
            case 1:
                dayString = "Tuesday";
                break;
            case 2:
                dayString = "Wednesday";
                break;
            case 3:
                dayString = "Thursday";
                break;
            case 4:
                dayString = "Friday";
                break;
            case 5:
                dayString = "Saturday";
                break;
            case 6:
                dayString = "Sunday";
                break;
            default :
                System.out.println("Invalid Month");
                dayString = "";
                break;
        }
        return dayString;

    }
}
