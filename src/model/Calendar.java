package model;

import java.util.ArrayList;

public class Calendar {
    Date date;
    String email;

    ArrayList<Object> entryList;

    public Calendar(Date date,String email){
        this.date = date;
        this.email = email;
        entryList = new ArrayList<>();
    }



    //Getter.
    public Date getDate(){ return date; }

    public String getEmail(){ return email; }

    public ArrayList getEntries(){return entryList;}

    //Modifies: this.
    //Effects : add following entry from entryList if such entry is not exists else update information.
    public void addEntry(Object sampleEntry){


        Entry tempEntry = (Entry) sampleEntry;
        String testLabel = tempEntry.getLabel();
        for(int i =0; i< entryList.size(); i++){
            Entry testentry = (Entry) entryList.get(i);
            if(testLabel == testentry.getLabel()){
                entryList.set(i,sampleEntry);
                return;
            }
        }
        entryList.add(sampleEntry);
    }

    //Requires: entryList should be non Empty.
    //Modifies: this.
    //Effects : remove following entry from entryList if such entry is already exists in Calendar.
    public void removeEntry(String entryLabel){
        for(int i =0; i< entryList.size(); i++){
            Object thisEntry =  entryList.get(i);
            Entry tempEntry = (Entry) thisEntry;
            if(entryLabel.equals(tempEntry.getLabel())){
                entryList.remove(thisEntry);
                return;
            }
        }

    }

    //Requires: entryList should be non empty.
    //Effect: return the entry with largest date.
    public Object nearestEntry() {

        Object firstObject = entryList.get(0);
        Entry firstTempObject = (Entry) firstObject;
        Date minDate = firstTempObject.getDate();
        for(int i =0; i< entryList.size(); i++){
            Object thisEntry =  entryList.get(i);
            Entry tempEntry = (Entry) thisEntry;
            Date thisDate = tempEntry.getDate();
            if(thisDate.getYear() < minDate.getYear()){
                firstObject = thisEntry;
                minDate = thisDate;


            }
            else if (thisDate.getYear()== minDate.getYear() && thisDate.getMonth() < minDate.getMonth()){
                firstObject  = thisEntry;
                minDate = thisDate;
            }
            else if (thisDate.getYear() == minDate.getYear() && thisDate.getMonth() == minDate.getMonth()
                    && thisDate.getDay() < minDate.getDay()){
                firstObject = thisEntry;
                minDate = thisDate;
            }
        }
        return firstObject;
    }

    //Effect: return the entry with following label.
    public Object entryByName(String name){
        for(int i =0 ; i < entryList.size(); i++){
            Object obj = entryList.get(i);
            Entry ent = (Entry) obj;
            if (name.equals(ent.getLabel())){
                return obj;
            }

        }

        return false;
    }

    //Effect: return the entry with following classes:
    public ArrayList entryByClassName(String classname){
       ArrayList<Object> arrayList = new ArrayList<>();
        for(int i = 0 ; i<entryList.size(); i++){
            if(entryList.get(i).getClass().getSimpleName().equals(classname)){
                arrayList.add(entryList.get(i));
            }

        }
        return arrayList;

    }



}
