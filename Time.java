public class Time {

    int hour;
    int minute;

    Time(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getHour(){
        return this.hour;
    }

    public void setMinute(int minute){
        this.minute = minute;
    }

    public int getMinute(){
        return this.minute;
    }
}
