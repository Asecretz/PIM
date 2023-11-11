import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;
import static java.lang.System.in;

public class PIM {

    List<PIR> pirList = new ArrayList<>();
    PIR pir;
    static String path = "C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM";  // path

    public PIM(){
        PIR pir;
    }
    public void run() throws IOException {
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
        System.out.println("===== Create =====");
        System.out.print("Which type of PIR you want to create?\n1.Contact\n2.Note\n3.To-do\n4.Event\nEnter a number: ");
        int input = sc.nextInt();
        sc.nextLine();
        if(input == 1){
            String type = "Contact";
            int id = getCountNo();
            System.out.print("Please enter the topic of the ContactPIR: ");
            String topic = sc.nextLine();
            System.out.print("Please enter the name of contact: ");
            String name = sc.nextLine();
            System.out.print("Please enter the address of contact: ");
            String address = sc.nextLine();
            System.out.print("Please enter the mobile number of contact: ");
            String mobileNo = sc.nextLine();
            pir = new ContactPIR(type,id,topic,name,address,mobileNo);
            pir.store();
            pirList.add(pir);
        } else if(input == 2){
            String type = "Note";
            int id = getCountNo();
            System.out.print("Please enter the topic of the NotePIR: ");
            String topic = sc.nextLine();
            System.out.print("Please enter the title of note: ");
            String title = sc.nextLine();
            System.out.print("Please enter the content of note: ");
            String content = sc.nextLine();
            pir = new NotePIR(type,id,topic,title,content);
            pir.store();
            pirList.add(pir);
        } else if(input == 3){
            String type = "todo";
            int id = getCountNo();
            System.out.print("Please enter the topic of the TodoPIR: ");
            String topic = sc.nextLine();
            System.out.print("Please enter the title of to-do: ");
            String title = sc.nextLine();
            System.out.print("Please enter the description of to-do: ");
            String description = sc.nextLine();
            System.out.print("Please enter the date (DD-MM-YY): ");
            String date = sc.nextLine();
            pir = new ToDoPIR(type,id,topic,title,description,date);
            pir.store();
            pirList.add(pir);
        } else if(input == 4){
            String type = "Event";
            int id = getCountNo();
            System.out.print("Please enter the topic of the EventPIR: ");
            String topic = sc.nextLine();
            System.out.print("Please enter the title of event: ");
            String title = sc.nextLine();
            System.out.print("Please enter the description of event: ");
            String description = sc.nextLine();
            System.out.print("Please enter the date of event (DD-MM-YY): ");
            String date = sc.nextLine();
            System.out.print("Please enter the start time of the event (hh-mm): ");
            String startTime = sc.nextLine();
            System.out.print("Please enter the end time of the event (hh-mm): ");
            String endTime = sc.nextLine();
            pir = new EventPIR(type,id,topic,title,description,date,startTime,endTime);
            pir.store();
            pirList.add(pir);
        }
    }

    public void modify(){
        Scanner sc = new Scanner(System.in);
        int fileCounter = 1;
        System.out.println("===== Modify =====");
        System.out.println("There are "+getCountNo()+" PIRs");
        for(PIR pir:pirList){
            System.out.println(fileCounter+". "+pir.topic);
            fileCounter++;
        }
        System.out.print("Please enter which PIR you want to modify: ");
        int input = sc.nextInt();
        sc.nextLine();
        PIR pir = pirList.get(input-1);
        if(pir.type.equals("Contact")){
            // Contact Part
            ContactPIR contactPIR = (ContactPIR) pir;
            System.out.print("1. Topic\n2. Name\n3. Address\n4. Mobile number\nPlease enter a number: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1){
                // Topic modify
                System.out.println("This is you current topic: "+contactPIR.topic);
                System.out.print("Please enter your new topic: ");
                contactPIR.topic = sc.nextLine();
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\"+"A"+contactPIR.id+".pim"); // path
                if(fileToDelete.delete()){
                    contactPIR.store();
                    pirList.remove(input-1);
                    pirList.add(contactPIR);
                } else{
                    System.out.println("=== Modify function occur error ===");
                }
            } else if(choice == 2){
                // Name modify
                System.out.println("This is you current name: "+contactPIR.getName());
                System.out.print("Please enter your new name: ");
                contactPIR.setName(sc.nextLine());
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\"+"A"+contactPIR.id+".pim"); // path
                if(fileToDelete.delete()){
                    contactPIR.store();
                    pirList.remove(input-1);
                    pirList.add(contactPIR);
                } else{
                    System.out.println("=== Modify function occur error ===");
                }
            } else if(choice == 3){
                // Address modify
                System.out.println("This is you current address: "+contactPIR.getAddress());
                System.out.print("Please enter your new address: ");
                contactPIR.setAddress(sc.nextLine());
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\"+"A"+contactPIR.id+".pim"); // path
                if(fileToDelete.delete()){
                    contactPIR.store();
                    pirList.remove(input-1);
                    pirList.add(contactPIR);
                } else{
                    System.out.println("=== Modify function occur error ===");
                }
            } else if(choice == 4){
                // Mobile Number modify
                System.out.println("This is you current mobile number: "+contactPIR.getMobileNo());
                System.out.print("Please enter your new mobile number: ");
                contactPIR.setMobileNo(sc.nextLine());
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\"+"A"+contactPIR.id+".pim"); // path
                if(fileToDelete.delete()){
                    contactPIR.store();
                    pirList.remove(input-1);
                    pirList.add(contactPIR);
                } else{
                    System.out.println("=== Modify function occur error ===");
                }
            } else{
                System.out.println("===== Wrong Input ======");
            }
        } else if(pir.type.equals("Note")){
            // Note Part
            NotePIR notePIR = (NotePIR) pir;
            System.out.print("1. Topic\n2. Title\n3. texts\nPlease enter a number: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1) {
                // Topic modify
                System.out.println("This is you current topic: " + notePIR.topic);
                System.out.print("Please enter your new topic: ");
                notePIR.topic = sc.nextLine();
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\" + "B" + notePIR.id + ".pim"); // path
                if (fileToDelete.delete()) {
                    notePIR.store();
                    pirList.remove(input-1);
                    pirList.add(notePIR);
                } else {
                    System.out.println("=== Modify function occur error ===");
                }
            } else if(choice == 2){
                // Title modify
                System.out.println("This is you current title: " + notePIR.getTitle());
                System.out.print("Please enter your new title: ");
                notePIR.setTitle(sc.nextLine());
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\" + "B" + notePIR.getTitle() + ".pim"); // path
                if (fileToDelete.delete()) {
                    notePIR.store();
                    pirList.remove(input-1);
                    pirList.add(notePIR);
                } else {
                    System.out.println("=== Modify function occur error ===");
                }
            } else if(choice == 3) {
                // Title modify
                System.out.println("This is you current texts: " + notePIR.getTexts());
                System.out.print("Please enter your new texts: ");
                notePIR.setTexts(sc.nextLine());
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\" + "B" + notePIR.getTexts() + ".pim"); // path
                if (fileToDelete.delete()) {
                    notePIR.store();
                    pirList.remove(input-1);
                    pirList.add(notePIR);
                } else {
                    System.out.println("=== Modify function occur error ===");
                }
            } else{
                System.out.println("===== Wrong Input ======");
            }
        } else if(pir.type.equals("Todo")){
            // Todo Part
            ToDoPIR toDoPIR = (ToDoPIR) pir;
            System.out.print("1. Topic\n2. Title\n3. Description\n4. Deadline\nPlease enter a number: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1) {
                // Topic modify
                System.out.println("This is you current topic: " + toDoPIR.topic);
                System.out.print("Please enter your new topic: ");
                toDoPIR.topic = sc.nextLine();
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\" + "C" + toDoPIR.id + ".pim"); // path
                if (fileToDelete.delete()) {
                    toDoPIR.store();
                    pirList.remove(input-1);
                    pirList.add(toDoPIR);
                } else {
                    System.out.println("=== Modify function occur error ===");
                }
            } else if(choice == 2){
                // Title modify
                System.out.println("This is you current title: " + toDoPIR.getTitle());
                System.out.print("Please enter your new title: ");
                toDoPIR.setTitle(sc.nextLine());
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\" + "C" + toDoPIR.id + ".pim"); // path
                if (fileToDelete.delete()) {
                    toDoPIR.store();
                    pirList.remove(input-1);
                    pirList.add(toDoPIR);
                } else {
                    System.out.println("=== Modify function occur error ===");
                }
            } else if(choice == 3){
                // Description modify
                System.out.println("This is you current description: " + toDoPIR.getDescription());
                System.out.print("Please enter your new description: ");
                toDoPIR.setDescription(sc.nextLine());
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\" + "C" + toDoPIR.id + ".pim"); // path
                if (fileToDelete.delete()) {
                    toDoPIR.store();
                    pirList.remove(input-1);
                    pirList.add(toDoPIR);
                } else {
                    System.out.println("=== Modify function occur error ===");
                }
            } else if(choice == 4){
                // Deadline modify
                System.out.println("This is you current deadline: " + toDoPIR.getDeadline());
                System.out.print("Please enter your new deadline: ");
                toDoPIR.setDeadline(sc.nextLine());
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\" + "C" + toDoPIR.id + ".pim"); // path
                if (fileToDelete.delete()) {
                    toDoPIR.store();
                    pirList.remove(input-1);
                    pirList.add(toDoPIR);
                } else {
                    System.out.println("=== Modify function occur error ===");
                }
            } else{
                System.out.println("===== Wrong Input ======");
            }
        } else if(pir.type.equals("Event")){
            // Event Part
            EventPIR eventPIR = (EventPIR) pir;
            System.out.print("1. Topic\n2. Title\n3. Description\n4. Date\n5. Start Time\n6. End Time\nPlease enter a number: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1) {
                // Topic modify
                System.out.println("This is you current topic: " + eventPIR.topic);
                System.out.print("Please enter your new topic: ");
                eventPIR.topic = sc.nextLine();
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\" + "D" + eventPIR.id + ".pim"); // path
                if (fileToDelete.delete()) {
                    eventPIR.store();
                    pirList.remove(input-1);
                    pirList.add(eventPIR);
                } else {
                    System.out.println("=== Modify function occur error ===");
                }
            } else if(choice == 2) {
                // Title modify
                System.out.println("This is you current Title: " + eventPIR.getTitle());
                System.out.print("Please enter your new Title: ");
                eventPIR.setTitle(sc.nextLine());
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\" + "D" + eventPIR.id + ".pim"); // path
                if (fileToDelete.delete()) {
                    eventPIR.store();
                    pirList.remove(input-1);
                    pirList.add(eventPIR);
                } else {
                    System.out.println("=== Modify function occur error ===");
                }
            } else if(choice == 3) {
                // Description modify
                System.out.println("This is you current Description: " + eventPIR.getDescription());
                System.out.print("Please enter your new Description: ");
                eventPIR.setDescription(sc.nextLine());
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\" + "D" + eventPIR.id + ".pim"); // path
                if (fileToDelete.delete()) {
                    eventPIR.store();
                    pirList.remove(input - 1);
                    pirList.add(eventPIR);
                } else {
                    System.out.println("=== Modify function occur error ===");
                }
            } else if(choice == 4) {
                // Date modify
                System.out.println("This is you current Date: " + eventPIR.getDate());
                System.out.print("Please enter your new Date (DD-MM-YY): ");
                eventPIR.setDate(sc.nextLine());
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\" + "D" + eventPIR.id + ".pim"); // path
                if (fileToDelete.delete()) {
                    eventPIR.store();
                    pirList.remove(input - 1);
                    pirList.add(eventPIR);
                } else {
                    System.out.println("=== Modify function occur error ===");
                }
            } else if(choice == 5) {
                // Start Time modify
                System.out.println("This is you current Start Time: " + eventPIR.getStartTime());
                System.out.print("Please enter your new Start Time (DD-MM-YY): ");
                eventPIR.setStartTime(sc.nextLine());
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\" + "D" + eventPIR.id + ".pim"); // path
                if (fileToDelete.delete()) {
                    eventPIR.store();
                    pirList.remove(input - 1);
                    pirList.add(eventPIR);
                } else {
                    System.out.println("=== Modify function occur error ===");
                }
            } else if(choice == 6) {
                // End Time modify
                System.out.println("This is you current End Time: " + eventPIR.getEndTime());
                System.out.print("Please enter your new End Time (DD-MM-YY): ");
                eventPIR.setEndTime(sc.nextLine());
                File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\" + "D" + eventPIR.id + ".pim"); // path
                if (fileToDelete.delete()) {
                    eventPIR.store();
                    pirList.remove(input - 1);
                    pirList.add(eventPIR);
                } else {
                    System.out.println("=== Modify function occur error ===");
                }
            } else {
                System.out.println("===== Wrong Input ======");
            }
        } else {
            System.out.println("===== Wrong Input ======");
        }
    }

    public void search(){

    }

    public void print(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Print =====");
        System.out.print("1.Contact\n2.Note\n3.To-do\n4.Event\n5.All\nPlease enter a number: ");
        int input = sc.nextInt();
        sc.nextLine();
        if(input == 1){
            for(PIR pir: pirList){
                if(pir.type.equals("Contact")){
                    pir.print();
                }
            }
        } else if(input == 2){
            for(PIR pir:pirList){
                if(pir.type.equals("Note")){
                    pir.print();
                }
            }
        } else if(input == 3){
            for(PIR pir:pirList){
                if(pir.type.equals("Todo")){
                    pir.print();
                }
            }
        } else if(input == 4){
            for(PIR pir:pirList){
                if(pir.type.equals("Event")){
                    pir.print();
                }
            }
        } else if(input == 5){
            for(PIR pir:pirList){
                pir.print();
            }
        }
    }

    public void delete(){
        Scanner sc = new Scanner(System.in);
        int fileCounter = 1;
        System.out.println("===== Delete =====");
        System.out.println("There are "+getCountNo()+" PIRs");
        for(PIR pir:pirList){
            System.out.println(fileCounter+". "+pir.topic);
            fileCounter++;
        }
        System.out.print("Please enter which PIR you want to delete: ");
        int input = sc.nextInt();
        sc.nextLine();
        PIR pir = pirList.get(input-1);
        String type = null;
        if(pir.type.equals("Contact")){
            type = "A";
        } else if(pir.type.equals("Note")){
            type = "B";
        } else if(pir.type.equals("Todo")){
            type = "C";
        } else if(pir.type.equals("Event")){
            type = "D";
        } else {
            System.out.println("=== Delete function occur error ===");
        }
        File fileToDelete = new File("C:\\Users\\user\\Documents\\Java\\COMP3211\\PIM\\" + type + pir.id + ".pim"); // path
        if (fileToDelete.delete()) {
            pirList.remove(input - 1);
            System.out.println("=== Delete Successfully ===");
        } else {
            System.out.println("=== Delete function occur error ===");
        }
    }

    public void load(){
        // Philbert's gf Part
        // enter "I give up" to earn 3 pts
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Load =====");
        System.out.print("Please enter the path of PIM file: ");
        String pimPath = sc.nextLine();
        File file = new File(pimPath);
        if (file.getName().contains("A")) {
            // Create ContactPIR
            String fileNameA = file.getName();
            Pattern idPatternA = Pattern.compile("[A-Za-z]*(\\d+).*");
            Matcher idMatcherA = idPatternA.matcher(fileNameA);
            if (idMatcherA.matches()) {
                String id = idMatcherA.group(1);
                String type = "Contact";
                String topic = null;
                String name = null;
                String address = null;
                String mobileNo = null;
                Pattern pattern = Pattern.compile(":\\s*(.*)");
                try (BufferedReader br = new BufferedReader(new FileReader((file)))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        Matcher matcher = pattern.matcher(line);
                        if (matcher.find()) {
                            String information = matcher.group(1);
                            if(line.contains("Topic: ")){
                                topic = information;
                            } else if (line.contains("Name: ")) {
                                name = information;
                            } else if (line.contains("Address: ")) {
                                address = information;
                            } else if (line.contains("Mobile Number: ")) {
                                mobileNo = information;
                            }
                        }
                    }
                    PIR pir = new ContactPIR(type, Integer.parseInt(id), topic, name, address, mobileNo);
                    pir.store();
                    pirList.add(pir);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (file.getName().contains("B")) {
            // Create NotePIR
            String fileNameB = file.getName();
            Pattern idPatternB = Pattern.compile("[A-Za-z]*(\\d+).*");
            Matcher idMatcherB = idPatternB.matcher(fileNameB);
            if (idMatcherB.matches()) {
                String id = idMatcherB.group(1);
                String type = "Note";
                String topic = null;
                String title = null;
                String text = null;
                Pattern pattern = Pattern.compile(":\\s*(.*)");
                try (BufferedReader br = new BufferedReader(new FileReader((file)))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        Matcher matcher = pattern.matcher(line);
                        if (matcher.find()) {
                            String information = matcher.group(1);
                            if(line.contains("Topic: ")){
                                topic = information;
                            }else if (line.contains("Title: ")) {
                                title = information;
                            } else if (line.contains("Texts: ")) {
                                text = information;
                            }
                        }
                    }
                    PIR pir = new NotePIR(type, Integer.parseInt(id), topic, title, text);
                    pir.store();
                    pirList.add(pir);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (file.getName().contains("C")) {
            // Create ToDoPIR
            String fileNameC = file.getName();
            Pattern idPatternC = Pattern.compile("[A-Za-z]*(\\d+).*");
            Matcher idMatcherC = idPatternC.matcher(fileNameC);
            if (idMatcherC.matches()) {
                String id = idMatcherC.group(1);
                String type = "ToDo";
                String topic = null;
                String title = null;
                String description = null;
                String deadline = null;
                Pattern pattern = Pattern.compile(":\\s*(.*)");
                try (BufferedReader br = new BufferedReader(new FileReader((file)))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        Matcher matcher = pattern.matcher(line);
                        if (matcher.find()) {
                            String information = matcher.group(1);
                            if(line.contains("Topic: ")) {
                                topic = information;
                            }else if (line.contains("Title: ")) {
                                title = information;
                            } else if (line.contains("Description: ")) {
                                description = information;
                            } else if (line.contains("Deadline:")) {
                                deadline = information;
                            }
                        }
                    }
                    PIR pir = new ToDoPIR(type, Integer.parseInt(id), topic,title, description, deadline);
                    pir.store();
                    pirList.add(pir);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (file.getName().contains("D")) {
            // Create EventPIR
            String fileNameD = file.getName();
            Pattern idPatternD = Pattern.compile("[A-Za-z]*(\\d+).*");
            Matcher idMatcherD = idPatternD.matcher(fileNameD);
            if (idMatcherD.matches()) {
                String id = idMatcherD.group(1);
                String type = "Event";
                String topic = null;
                String title = null;
                String description = null;
                String date = null;
                String startTime = null;
                String endTime = null;
                Pattern pattern = Pattern.compile(":\\s*(.*)");
                try (BufferedReader br = new BufferedReader(new FileReader((file)))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        Matcher matcher = pattern.matcher(line);
                        if (matcher.find()) {
                            String information = matcher.group(1);
                            if(line.contains("Topic: ")){
                                topic = information;
                            }else if (line.contains("Title: ")) {
                                title = information;
                            } else if (line.contains("Description: ")) {
                                description = information;
                            } else if (line.contains("Date: ")) {
                                date = information;
                            } else if (line.contains("Start Time: ")) {
                                startTime = information;
                            } else if (line.contains("End Time: ")) {
                                endTime = information;
                            }
                        }
                    }
                    PIR pir = new EventPIR(type, Integer.parseInt(id), topic,title, description, date, startTime, endTime);
                    pir.store();
                    pirList.add(pir);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("=== Wrong FileName Detected ===");
            }
        }
    }

    public void initial() throws IOException {
        File directory = new File(path);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.getName().contains("A")) {
                    // Create ContactPIR
                    String fileNameA = file.getName();
                    Pattern idPatternA = Pattern.compile("[A-Za-z]*(\\d+).*");
                    Matcher idMatcherA = idPatternA.matcher(fileNameA);
                    if (idMatcherA.matches()) {
                        String id = idMatcherA.group(1);
                        String type = "Contact";
                        String topic = null;
                        String name = null;
                        String address = null;
                        String mobileNo = null;
                        Pattern pattern = Pattern.compile(":\\s*(.*)");
                        try (BufferedReader br = new BufferedReader(new FileReader((file)))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                Matcher matcher = pattern.matcher(line);
                                if (matcher.find()) {
                                    String information = matcher.group(1);
                                    if(line.contains("Topic: ")){
                                        topic = information;
                                    } else if (line.contains("Name: ")) {
                                        name = information;
                                    } else if (line.contains("Address: ")) {
                                        address = information;
                                    } else if (line.contains("Mobile Number: ")) {
                                        mobileNo = information;
                                    }
                                }
                            }
                            PIR pir = new ContactPIR(type, Integer.parseInt(id), topic, name, address, mobileNo);
                            pirList.add(pir);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (file.getName().contains("B")) {
                    // Create NotePIR
                    String fileNameB = file.getName();
                    Pattern idPatternB = Pattern.compile("[A-Za-z]*(\\d+).*");
                    Matcher idMatcherB = idPatternB.matcher(fileNameB);
                    if (idMatcherB.matches()) {
                        String id = idMatcherB.group(1);
                        String type = "Note";
                        String topic = null;
                        String title = null;
                        String text = null;
                        Pattern pattern = Pattern.compile(":\\s*(.*)");
                        try (BufferedReader br = new BufferedReader(new FileReader((file)))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                Matcher matcher = pattern.matcher(line);
                                if (matcher.find()) {
                                    String information = matcher.group(1);
                                    if(line.contains("Topic: ")){
                                        topic = information;
                                    }else if (line.contains("Title: ")) {
                                        title = information;
                                    } else if (line.contains("Texts: ")) {
                                        text = information;
                                    }
                                }
                            }
                            PIR pir = new NotePIR(type, Integer.parseInt(id), topic, title, text);
                            pirList.add(pir);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (file.getName().contains("C")) {
                    // Create ToDoPIR
                    String fileNameC = file.getName();
                    Pattern idPatternC = Pattern.compile("[A-Za-z]*(\\d+).*");
                    Matcher idMatcherC = idPatternC.matcher(fileNameC);
                    if (idMatcherC.matches()) {
                        String id = idMatcherC.group(1);
                        String type = "ToDo";
                        String topic = null;
                        String title = null;
                        String description = null;
                        String deadline = null;
                        Pattern pattern = Pattern.compile(":\\s*(.*)");
                        try (BufferedReader br = new BufferedReader(new FileReader((file)))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                Matcher matcher = pattern.matcher(line);
                                if (matcher.find()) {
                                    String information = matcher.group(1);
                                    if(line.contains("Topic: ")) {
                                        topic = information;
                                    }else if (line.contains("Title: ")) {
                                        title = information;
                                    } else if (line.contains("Description: ")) {
                                        description = information;
                                    } else if (line.contains("Deadline:")) {
                                        deadline = information;
                                    }
                                }
                            }
                        PIR pir = new ToDoPIR(type, Integer.parseInt(id), topic,title, description, deadline);
                        pirList.add(pir);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (file.getName().contains("D")) {
                    // Create EventPIR
                    String fileNameD = file.getName();
                    Pattern idPatternD = Pattern.compile("[A-Za-z]*(\\d+).*");
                    Matcher idMatcherD = idPatternD.matcher(fileNameD);
                    if (idMatcherD.matches()) {
                        String id = idMatcherD.group(1);
                        String type = "Event";
                        String topic = null;
                        String title = null;
                        String description = null;
                        String date = null;
                        String startTime = null;
                        String endTime = null;
                        Pattern pattern = Pattern.compile(":\\s*(.*)");
                        try (BufferedReader br = new BufferedReader(new FileReader((file)))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                Matcher matcher = pattern.matcher(line);
                                if (matcher.find()) {
                                    String information = matcher.group(1);
                                    if(line.contains("Topic: ")){
                                        topic = information;
                                    }else if (line.contains("Title: ")) {
                                        title = information;
                                    } else if (line.contains("Description: ")) {
                                        description = information;
                                    } else if (line.contains("Date: ")) {
                                        date = information;
                                    } else if (line.contains("Start Time: ")) {
                                        startTime = information;
                                    } else if (line.contains("End Time: ")) {
                                        endTime = information;
                                    }
                                }
                            }
                            PIR pir = new EventPIR(type, Integer.parseInt(id), topic,title, description, date, startTime, endTime);
                            pirList.add(pir);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("=== Wrong FileName Detected ===");
                        break;
                    }
                }
            }
        }
    }

    public int getCountNo(){
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
