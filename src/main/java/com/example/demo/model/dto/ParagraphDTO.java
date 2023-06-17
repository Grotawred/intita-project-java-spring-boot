package com.example.demo.model.dto;

import com.example.demo.model.UserData;
import jakarta.persistence.*;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParagraphDTO {
    private Long id;
    private Set<UserData> userData;
    private String header;
    private String content;
}
