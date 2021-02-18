package main.dto;

import lombok.Data;
import main.model.Department;
import main.model.Visitor;

@Data
public class SaveVisitorDTO {
    private Visitor visitor;
    private Department department;
}
