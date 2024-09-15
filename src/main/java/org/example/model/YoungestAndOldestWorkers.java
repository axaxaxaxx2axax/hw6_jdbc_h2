package org.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class YoungestAndOldestWorkers {
    private String type;
    private String name;
    private String birthday;
}
