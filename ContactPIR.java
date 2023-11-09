import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class ContactPIR extends PIR{

    String name;
    String address;
    String mobileNo;

    ContactPIR(String type, int id,String name,String address, String mobileNo){
        super(type, id);
        this.name = name;
        this.address = address;
        this.mobileNo = mobileNo;
    }

    void store(){
        String createDateYear = String.valueOf(createDate.getYear());
        String createDateMonth = String.valueOf(createDate.getMonth());
        String createDateDay = String.valueOf(createDate.getDay());
        String lastModifyYear = String.valueOf(lastModify.getYear());
        String lastModifyMonth = String.valueOf(lastModify.getMonth());
        String lastModifyDay = String.valueOf(lastModify.getDay());
        String fileName = "A"+id+".pim";
        String heading = "=== Contact ===\n";
        String contentName = "Name: "+name+"\n";
        String contentAddress = "Address: "+address+"\n";
        String contentMobileNo = "Mobile Number: "+mobileNo+"\n";
        String contentCreateDate = "Create Date: "+createDateYear+"-"+createDateMonth+"-"+createDateDay+"\n"+"Last Modify Date: "+lastModifyYear+"-"+lastModifyMonth+"-"+lastModifyDay+"\n";
        String closing = "--- End of "+fileName+" PIR ---\n=====================";
        try{
            File file = new File(path+"/"+fileName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(heading+contentName+contentAddress+contentMobileNo+contentCreateDate+closing);
            fileWriter.close();
            System.out.println("=== File created successfully ===");
        } catch (IOException e){
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
}