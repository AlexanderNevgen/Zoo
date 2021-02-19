package main.dto;

import lombok.Data;
import java.util.Date;

@Data
public class TicketDTO {
    private Date dateOfVisit;
    private String firstName;
    private String lastName;
}
