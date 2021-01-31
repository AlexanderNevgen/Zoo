package main.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    int id;

    @Column (name = "departmentName")
    int departmentName;

    @ManyToMany(mappedBy = "departmentList")
    List<Ticket> ticketList;

}
