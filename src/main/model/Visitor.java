package model;

public class Visitor {

    public String firstName;
    public int id;

    public Visitor(String firstName, int id){
        this.firstName= firstName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

}
