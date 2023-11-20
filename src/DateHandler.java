public class DateHandler {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    DateHandler(String dateAndTime){
        // DD-MM-YY hh-mm
        String[] parts = dateAndTime.split(" |-");
        year = Integer.parseInt(parts[2]);
        month = Integer.parseInt(parts[1]);
        day = Integer.parseInt(parts[0]);
        hour = Integer.parseInt(parts[3]);
        minute = Integer.parseInt(parts[4]);
    }

    DateHandler(String date, String time){
        String[] dateParts = date.split("-");
        String[] timeParts = time.split("-");
        year = Integer.parseInt(dateParts[2]);
        month = Integer.parseInt(dateParts[1]);
        day = Integer.parseInt(dateParts[0]);
        hour = Integer.parseInt(timeParts[0]);
        minute = Integer.parseInt(timeParts[1]);
    }

    DateHandler(int year, int month, int day, int hour, int minute){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public boolean before(DateHandler dateAndTime) {
        if (this.year < dateAndTime.year) {
            return true;
        } else if (this.year == dateAndTime.year && this.month < dateAndTime.month) {
            return true;
        } else if (this.year == dateAndTime.year && this.month == dateAndTime.month && this.day < dateAndTime.day) {
            return true;
        } else if (this.year == dateAndTime.year && this.month == dateAndTime.month && this.day == dateAndTime.day && this.hour < dateAndTime.hour) {
            return true;
        } else if (this.year == dateAndTime.year && this.month == dateAndTime.month && this.day == dateAndTime.day && this.hour == dateAndTime.hour && this.minute < dateAndTime.minute) {
            return true;
        } else {
            return false;
        }
    }

    public boolean after(DateHandler dateAndTime) {
        if (this.year > dateAndTime.year) {
            return true;
        } else if (this.year == dateAndTime.year && this.month > dateAndTime.month) {
            return true;
        } else if (this.year == dateAndTime.year && this.month == dateAndTime.month && this.day > dateAndTime.day) {
            return true;
        } else if (this.year == dateAndTime.year && this.month == dateAndTime.month && this.day == dateAndTime.day && this.hour > dateAndTime.hour) {
            return true;
        } else if (this.year == dateAndTime.year && this.month == dateAndTime.month && this.day == dateAndTime.day && this.hour == dateAndTime.hour && this.minute > dateAndTime.minute) {
            return true;
        } else {
            return false;
        }
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
