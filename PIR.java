import java.time.LocalDate;

abstract public class PIR {
    String type;    // notes, to-dos, events, contacts
    int id;
    static String path = "C:/Users/user/Documents/Java/COMP3211/PIM";

    PIR(String type, int id){
        this.type = type;
        this.id = id;
    }

    abstract void store();

    public String getType(){ return type; }

    public int getId(){ return id; }

}
