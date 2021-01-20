package main.zoo.mapper;

import main.zoo.model.Visitor;

public class VisitorMapper {

    public static Visitor mapperVisitor(String firstName, int ticketCount){

        return new Visitor(ticketCount, firstName);
    }
}
