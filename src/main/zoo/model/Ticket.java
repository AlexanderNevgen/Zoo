package main.zoo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Table (name = "ticket")
public class Ticket {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;

    //@Column (name = "date")
    private Date date;

   // @Column (name = "id")
    private int visitorId;

   // @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "idvisitor")
    private Visitor visitor;

    public Ticket(int ticketId, Date date, int visitorId){
        this.ticketId = ticketId;
        this.date = date;
        this.visitorId = visitorId;
    }
}
