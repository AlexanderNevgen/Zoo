package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table (name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long ticketId;

    @Column (name = "date")
    private Date date;

    @Column (name = "idvisitor")
    private Long visitorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idvisitor")
    private Visitor visitor;

    @ManyToMany
    @JoinTable(
            name = "departmentInTicket",
            joinColumns = @JoinColumn(name = "ticket_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id"))
    List<Department> departmentList;
}
