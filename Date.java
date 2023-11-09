public class Date {

    private int year;
    private int month;
    private int day;

    Time startTime;

    Time endTime;

    Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    Date(int year, int month, int day, int hour, int minute){
        this.year = year;
        this.month = month;
        this.day = day;
        this.startTime = new Time(hour, minute);
        this.endTime = new Time(hour, minute);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear(){
        return this.year;
    }

    public void setMonth(int month){
        this.month = month;
    }

    public int getMonth() {
        return this.month;
    }

    public void setDay(int day){
        this.day = day;
    }

    public int getDay(){
        return this.day;
    }


}
