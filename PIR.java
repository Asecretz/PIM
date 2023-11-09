import java.time.LocalDate;

abstract public class PIR {
    String type;    // notes, to-dos, events, contacts
    int id;
    Date createDate;
    Date lastModify;
    static String path = "C:/Users/user/Documents/Java/COMP3211-master/PIM";

    PIR(String type, int id){
        this.type = type;
        this.id = id;
        createDate = new Date(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
        lastModify = new Date(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
    }

    abstract void store();

    public void setCreateDate(Date createDate){
        this.createDate = createDate;
    }

    public Date getCreateDate(){
        return this.createDate;
    }

    public void setLastModify(Date lastModify){
        this.lastModify = lastModify;
    }

    public Date getLastModify(){
        return this.lastModify;
    }

}
