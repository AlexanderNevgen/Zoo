package main.mapper;

import main.model.Visitor;

public class VisitorMapper {

    public static Visitor mapperVisitor(String firstName, int ticketCount, String lastName, int age){

        return new Visitor(ticketCount, firstName, lastName, age);
    }
}
