import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class ContactPIR extends PIR{

    String name;
    String address;
    String mobileNo;

    ContactPIR(String type, int id,String topic,String name,String address, String mobileNo){
        super(type, id, topic);
        this.name = name;
        this.address = address;
        this.mobileNo = mobileNo;
    }

    void store(){
        String fileName = "A"+id+".pim";
        String heading = "=== Contact ===\n";
        String topic = "Topic: "+super.topic+"\n";
        String contentName = "Name: "+name+"\n";
        String contentAddress = "Address: "+address+"\n";
        String contentMobileNo = "Mobile Number: "+mobileNo+"\n";
        String closing = "--- End of "+fileName+" PIR ---\n=====================";
        try{
            File file = new File(path+"/"+fileName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(heading+topic+contentName+contentAddress+contentMobileNo+closing);
            fileWriter.close();
            System.out.println("=== File created successfully ===");
        } catch (IOException e){
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    void print(){
        String fileName = "A"+id+".pim";
        String heading = "=== Contact ===\n";
        String topic = "Topic: "+super.topic+"\n";
        String contentName = "Name: "+name+"\n";
        String contentAddress = "Address: "+address+"\n";
        String contentMobileNo = "Mobile Number: "+mobileNo+"\n";
        String closing = "--- End of "+fileName+" PIR ---\n=====================";
        System.out.println(heading+contentName+contentAddress+contentMobileNo+closing);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setMobileNo(String mobileNo){
        this.mobileNo = mobileNo;
    }

    public String getMobileNo(){
        return mobileNo;
    }
}
