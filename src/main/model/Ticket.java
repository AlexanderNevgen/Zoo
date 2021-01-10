package model;

import java.util.Date;

public class Ticket {

    Date date;
    int ticketId;
    int visitorId;

    public Ticket(Date date, int ticketId, int visitorId){
        this.ticketId = ticketId;
        this.visitorId = visitorId;
        this.date = date;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Date getDate() {
        return date;
    }

    public int getVisitorId() {
        return visitorId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }
}
