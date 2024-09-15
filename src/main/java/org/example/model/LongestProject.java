package org.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LongestProject {
    private int id;
    private int monthCount;
}
