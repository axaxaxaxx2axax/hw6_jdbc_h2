package org.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MaxSalaryWorker {
    private String name;
    private String birthday;
    private String level;
    private int salary;
    }
