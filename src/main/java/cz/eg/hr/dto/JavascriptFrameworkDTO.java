package cz.eg.hr.dto;

import cz.eg.hr.mapper.JavascriptFrameworkMapper;
import lombok.*;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class JavascriptFrameworkDTO {
    private Long id;
    private String name;
    private Long version;
    private LocalDateTime date;
    private int reating;
}

