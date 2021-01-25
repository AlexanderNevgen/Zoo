package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "visitors")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column (name = "ticketCount")
    private int ticketCount;

    @Column (name = "age")
    private int age;

    @OneToMany(mappedBy = "visitors", cascade = CascadeType.ALL, orphanRemoval = true)
    public static List<Ticket> ticketList = new LinkedList<>();

    public List<Ticket> getTicketList(){
        return ticketList;
    }
}
