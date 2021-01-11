package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Ticket {

    private Date date;
    private int ticketId;
    private int visitorId;

}
