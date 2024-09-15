package org.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MaxProjectsClient {
    private String name;
    private int projectCount;
}
