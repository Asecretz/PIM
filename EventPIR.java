import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class EventPIR extends PIR{

    String title;
    String description;
    String date;  // year, month, day

    String startTime; // hour, minutes
    String endTime; // hour, minutes

    EventPIR(String type, int id,String title,String description,String date,String startTime,String endTime){
        super(type, id);
        this.title = title;
        this.description = description;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    void store(){
        String createDateYear = String.valueOf(createDate.getYear());
        String createDateMonth = String.valueOf(createDate.getMonth());
        String createDateDay = String.valueOf(createDate.getDay());
        String lastModifyYear = String.valueOf(lastModify.getYear());
        String lastModifyMonth = String.valueOf(lastModify.getMonth());
        String lastModifyDay = String.valueOf(lastModify.getDay());
        String fileName = "D"+id+".pim";
        String heading = "=== Event ===\n";
        String contentTitle = "Title: "+title+"\n";
        String contentDescription = "Description: "+description+"\n";
        String contentDate = "Date: "+date+"\n";
        String contentStartTime = "Start Time: "+startTime+"\n";
        String contentEndTime = "End Time: "+endTime+"\n";
        String contentCreateDate = "Create Date: "+createDateYear+"-"+createDateMonth+"-"+createDateDay+"\n"+"Last Modify Date: "+lastModifyYear+"-"+lastModifyMonth+"-"+lastModifyDay+"\n";
        String closing = "--- End of "+fileName+" PIR ---\n=====================";
        try{
            File file = new File(path+"/"+fileName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(heading+contentTitle+contentDescription+contentDate+contentStartTime+contentEndTime+contentCreateDate+closing);
            fileWriter.close();
            System.out.println("=== File created successfully ===");
        } catch (IOException e){
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
}
