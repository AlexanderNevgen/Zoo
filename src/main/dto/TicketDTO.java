package main.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TicketDTO {

    Date dateOfVisit;
    String firstName;
    String lastName;

}
