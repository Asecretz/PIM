import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ToDoPIR extends PIR{
    String title;
    String description;
    String deadline;    // DD-MM-YY hh-mm
    boolean alarm;

    ToDoPIR(String type, int id,String topic ,String title, String description, String deadline){
        super(type, id, topic);
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    void store(){
        String fileName = "C"+id+".pim";
        String heading = "=== To-do ===\n";
        String topic = "Topic: "+super.topic+"\n";
        String contentTitle = "Title: "+title+"\n";
        String contentDescription = "Description: "+description+"\n";
        String contentDeadline = "Deadline: "+deadline+"\n";
        String closing = "--- End of "+fileName+" PIR ---\n=====================";
        try{
            File file = new File(path+"/"+fileName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(heading+topic+contentTitle+contentDescription+contentDeadline+closing);
            fileWriter.close();
            System.out.println("=== File created successfully ===");
        } catch (IOException e){
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    void print(){
        String fileName = "C"+id+".pim";
        String heading = "=== To-do ===\n";
        String topic = "Topic: "+super.topic+"\n";
        String contentTitle = "Title: "+title+"\n";
        String contentDescription = "Description: "+description+"\n";
        String contentDeadline = "Deadline: "+deadline+"\n";
        String closing = "--- End of "+fileName+" PIR ---\n=====================";
        System.out.println(heading+topic+contentTitle+contentDescription+contentDeadline+closing);
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

    public void setDeadline(String deadline){
        this.deadline = deadline;
    }

    public String getDeadline(){
        return deadline;
    }
}
