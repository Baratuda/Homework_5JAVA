import java.util.List;

public class Contact {
    private String name;
    private List<String> number;

    public Contact(String name, List<String> number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  List<String> getNumber() {
        return number;
    }
    
    public  Integer countPhoneNumber() {
        return number.size();
    }

    public void setNumber( List<String> number) {
        this.number = number;
    }
}