import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NotePIR extends PIR{

    String title;
    String texts;

    NotePIR(String type, int id, String title, String texts){
        super(type, id);
        this.title = title;
        this.texts = texts;
    }

    void store(){
        String createDateYear = String.valueOf(createDate.getYear());
        String createDateMonth = String.valueOf(createDate.getMonth());
        String createDateDay = String.valueOf(createDate.getDay());
        String lastModifyYear = String.valueOf(lastModify.getYear());
        String lastModifyMonth = String.valueOf(lastModify.getMonth());
        String lastModifyDay = String.valueOf(lastModify.getDay());
        String fileName = "B"+id+".pim";
        String heading = "=== Note ===\n";
        String contentTitle = "Title: "+title+"\n";
        String contentText = "Texts: "+texts+"\n";
        String contentCreateDate = "Create Date: "+createDateYear+"-"+createDateMonth+"-"+createDateDay+"\n"+"Last Modify Date: "+lastModifyYear+"-"+lastModifyMonth+"-"+lastModifyDay+"\n";
        String closing = "--- End of "+fileName+" PIR ---\n=====================";
        try{
            File file = new File(path+"/"+fileName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(heading+contentTitle+contentText+contentCreateDate+closing);
            fileWriter.close();
            System.out.println("=== File created successfully ===");
        } catch (IOException e){
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }

    }
}