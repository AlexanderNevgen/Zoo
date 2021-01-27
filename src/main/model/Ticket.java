package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table (name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int ticketId;

    @Column (name = "date")
    private Date date;

    @Column (name = "idvisitor")
    private int visitorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idvisitor")
    private static Visitor visitor;

    public static Visitor getVisitor() {
        return visitor;
    }
}
