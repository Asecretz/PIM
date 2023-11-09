import java.util.*;
import java.io.File;

import static java.lang.System.exit;

public class PIM {

    List<PIR> pirList = new ArrayList<>();
    static PIR pir;
    static String path = "C:/Users/user/Documents/Java/COMP3211-master/PIM";  // for demonstration

    public PIM(){
        PIR pir;
    }
    public void run(){
        Scanner sc = new Scanner(System.in);
        initial();
        while(true){
            System.out.print("Welcome to Personal Information Manager\n1.Create\n2.Modify\n3.Search\n4.Print\n5.Delete\n6.Load\n7.Exit\nPlease enter a number: ");
            int input = sc.nextInt();
            select(input);
        }
    }

    public void select(int input){
        if(input == 1){
            create();
        } else if (input == 2) {
            modify();
        } else if (input == 3){
            search();
        } else if (input == 4){
            print();
        } else if (input == 5){
            delete();
        } else if (input == 6){
            load();
        } else if(input == 7){
            System.out.println("=== Exit Successfully ===");
            exit(0);
        } else{
            System.out.println("=== Wrong input ===");
        }
    }

    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Which type of PIR you want to create?\n1.Contact\n2.Note\n3.To-do\n4.Event\nEnter a number: ");
        int input = sc.nextInt();
        sc.nextLine();
        if(input == 1){
            String type = "Contact";
            int id = getId();
            System.out.print("Please enter the name of contact: ");
            String tmpName = sc.nextLine();
            System.out.print("Please enter the address of contact: ");
            String tmpAddress = sc.nextLine();
            System.out.print("Please enter the mobile number of contact: ");
            String tmpMobileNo = sc.nextLine();
            pir = new ContactPIR(type,id,tmpName,tmpAddress,tmpMobileNo);
            pir.store();
            pirList.add(pir);
        } else if(input == 2){
            String type = "Note";
            int id = getId();
            System.out.print("Please enter the title of note: ");
            String tmpTitle = sc.nextLine();
            System.out.print("Please enter the content of note: ");
            String tempContent = sc.nextLine();
            pir = new NotePIR(type,id,tmpTitle,tempContent);
            pir.store();
            pirList.add(pir);
        } else if(input == 3){
            String type = "todo";
            int id = getId();
            System.out.print("Please enter the title of to-do: ");
            String tmpTitle = sc.nextLine();
            System.out.print("Please enter the description of to-do: ");
            String tmpDescription = sc.nextLine();
            System.out.print("Please enter the date (DD-MM-YY): ");
            String tmpDate = sc.nextLine();
            pir = new ToDoPIR(type,id,tmpTitle,tmpDescription,tmpDate);
            pir.store();
            pirList.add(pir);
        } else if(input == 4){
            String type = "Event";
            int id = getId();
            System.out.print("Please enter the title of event: ");
            String tmpTitle = sc.nextLine();
            System.out.print("Please enter the description of event: ");
            String tmpDescription = sc.nextLine();
            System.out.print("Please enter the date of event (DD-MM-YY): ");
            String tmpDate = sc.nextLine();
            System.out.print("Please enter the start time of the event (hh-mm): ");
            String tmpStartTime = sc.nextLine();
            System.out.print("Please enter the end time of the event (hh-mm): ");
            String tmpEndTime = sc.nextLine();
            pir = new EventPIR(type,id,tmpTitle,tmpDescription,tmpDate,tmpStartTime,tmpEndTime);
            pir.store();
            pirList.add(pir);
        }
    }

    public void modify(){
        // ____ Part
        // search file name then ask for user modify what
    }

    public void search(){
        // ___ Part
        // take it as reference
        /*public class FileSearchExample {
            public static void main(String[] args) {
                File file = new File("path/to/file.txt");
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains("searchWord")) {
                            System.out.println("Found the word: " + line);
                        }
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }*/
    }

    public void print(){
        // ___ Part
        // search file then ask user want to print specific file or printall

    }

    public void delete(){
        // ___ Part
        // delete file easy part
    }

    public void load(){
        // Philbert's gf Part?
        // enter "I give up" to earn 3 pts
        // ask user to enter path and filename then save it to the file

    }

    public void initial(){
        // Testing
    }

    public int getId(){
        File directory = new File(path);
        if(directory.exists() && directory.isDirectory()){
            File[] files = directory.listFiles();
            int documentCount = 0;
            for(File file: files){
                if(file.isFile()){
                    documentCount++;
                }
            }
            return documentCount;
        } else{
            return 0;
        }
    }


}
