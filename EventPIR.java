import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class EventPIR extends PIR{

    String title;
    String description;
    String date;  // year, month, day

    String startTime; // hour, minutes
    String endTime; // hour, minutes

    EventPIR(String type, int id,String topic,String title,String description,String date,String startTime,String endTime){
        super(type, id, topic);
        this.title = title;
        this.description = description;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    void store(){
        String fileName = "D"+id+".pim";
        String heading = "=== Event ===\n";
        String topic = "Topic: "+super.topic+"\n";
        String contentTitle = "Title: "+title+"\n";
        String contentDescription = "Description: "+description+"\n";
        String contentDate = "Date: "+date+"\n";
        String contentStartTime = "Start Time: "+startTime+"\n";
        String contentEndTime = "End Time: "+endTime+"\n";
        String closing = "--- End of "+fileName+" PIR ---\n=====================";
        try{
            File file = new File(path+"/"+fileName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(heading+topic+contentTitle+contentDescription+contentDate+contentStartTime+contentEndTime+closing);
            fileWriter.close();
            System.out.println("=== File created successfully ===");
        } catch (IOException e){
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    void print(){
        String fileName = "D"+id+".pim";
        String heading = "=== Event ===\n";
        String topic = "Topic: "+super.topic+"\n";
        String contentTitle = "Title: "+title+"\n";
        String contentDescription = "Description: "+description+"\n";
        String contentDate = "Date: "+date+"\n";
        String contentStartTime = "Start Time: "+startTime+"\n";
        String contentEndTime = "End Time: "+endTime+"\n";
        String closing = "--- End of "+fileName+" PIR ---\n=====================";
        System.out.println(heading+contentTitle+contentDescription+contentDate+contentStartTime+contentEndTime+closing);
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    public void setStartTime(String startTime){
        this.startTime = startTime;
    }

    public String getStartTime(){
        return startTime;
    }

    public void setEndTime(String endTime){
        this.endTime = endTime;
    }

    public String getEndTime(){
        return endTime;
    }
}
