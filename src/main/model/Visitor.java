package main.model;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String lastName;

    private int ticketCount;

    private int age;

    //@OneToMany(mappedBy = "visitor", cascade = CascadeType.ALL, orphanRemoval = true)
    public static List<Ticket> ticketList = new LinkedList<>();

    public Visitor (String firstName,String lastName, int age, int id){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Visitor(int ticketCount, String firstName, String lastName, int age){
        this.firstName = firstName;
        this.ticketCount = ticketCount;
        this.lastName = lastName;
        this.age = age;

    }
}
