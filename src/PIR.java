import java.time.LocalDate;

abstract public class PIR {
    String type;    // notes, to-dos, events, contacts
    int id;
    String topic;
    static String path = "./src/PIM"; // path

    PIR(String type, int id, String topic){
        this.type = type;
        this.id = id;
        this.topic = topic;
    }

    abstract void store();

    abstract void print();

}
