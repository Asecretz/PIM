public class DateHandler {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    DateHandler(String dateAndTime){
        // DD-MM-YY hh-mm
        String[] parts = dateAndTime.split(" |-");
        year = Integer.parseInt(parts[0]);
        month = Integer.parseInt(parts[1]);
        day = Integer.parseInt(parts[2]);
        hour = Integer.parseInt(parts[3]);
        minute = Integer.parseInt(parts[4]);
    }

    DateHandler(String date, String time){
        String[] dateParts = date.split("-");
        String[] timeParts = time.split("-");
        year = Integer.parseInt(dateParts[0]);
        month = Integer.parseInt(dateParts[1]);
        day = Integer.parseInt(dateParts[2]);
        hour = Integer.parseInt(timeParts[0]);
        minute = Integer.parseInt(timeParts[1]);
    }

    public boolean before(DateHandler dateAndTime){
        if(this.year <= dateAndTime.year){
            return true;
        } else if(this.month <= dateAndTime.month){
            return true;
        } else if(this.day <= dateAndTime.day){
            return true;
        } else if(this.hour <= dateAndTime.hour){
            return true;
        } else return this.minute <= dateAndTime.minute;
    }

    public boolean after(DateHandler dateAndTime){
        if(this.year >= dateAndTime.year){
            return true;
        } else if(this.month >= dateAndTime.month){
            return true;
        } else if(this.day >= dateAndTime.day){
            return true;
        } else if(this.hour >= dateAndTime.hour){
            return true;
        } else return this.minute >= dateAndTime.minute;
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

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getMinute() {
        return minute;
    }
}
