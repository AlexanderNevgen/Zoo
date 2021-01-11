package mapper;

import model.Visitor;

public class VisitorMapper {

    public static Visitor mapperVisitor(String firstName, int ticketCount){

        Visitor visitor = new Visitor(ticketCount, firstName);

        return visitor;
    }
}
