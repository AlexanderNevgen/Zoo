package model;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

//@Entity
@NoArgsConstructor
@Data
//@Table (name = "visitors")
public class Visitor {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   // @Column(name = "name")
    private String firstName;

    private int ticketCount;

    //@OneToMany(mappedBy = "visitor", cascade = CascadeType.ALL, orphanRemoval = true)
    public static List<Ticket> ticketList = new LinkedList<>();

    public Visitor (String firstName, int id){
        this.id = id;
        this.firstName = firstName;
    }

    public Visitor(int ticketCount, String firstName){
        this.firstName = firstName;
        this.ticketCount = ticketCount;

    }
}
