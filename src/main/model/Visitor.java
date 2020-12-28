package model;

public class Visitor {

    public String firstName;
    public int id;
    public int ticketId;

    public Visitor(String firstName, int id, int ticketId){
        this.firstName= firstName;
        this.id = id;
        this.ticketId =ticketId;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
}
