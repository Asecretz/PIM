import java.time.LocalDate;

abstract public class PIR {
    String type;    // notes, to-dos, events, contacts
    int id;
    static String path = "C:\\Users\\85255\\OneDrive - The Hong Kong Polytechnic University\\Documents\\java\\COMP3211";

    PIR(String type, int id){
        this.type = type;
        this.id = id;
    }

    abstract void store();

    abstract void print();

    public String getType(){ return type; }

    public int getId(){ return id; }

}
