package model;
import lombok.Data;
@Data
public class Visitor {

    private String firstName;
    private int id;
    private int ticketCount;

    public Visitor (String firstName, int id){
        this.id = id;
        this.firstName = firstName;
    }

    public Visitor(int ticketCount, String firstName){
        this.firstName = firstName;
        this.ticketCount = ticketCount;

    }
}
