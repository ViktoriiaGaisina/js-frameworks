package cz.eg.hr.mapper;

import cz.eg.hr.data.JavascriptFramework;
import cz.eg.hr.dto.JavascriptFrameworkDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JavascriptFrameworkMapper {

    public JavascriptFrameworkDTO toDto(JavascriptFramework javascriptFramework) {
        if (javascriptFramework == null) {
            return null;
        }

        JavascriptFrameworkDTO dto = new JavascriptFrameworkDTO();
        dto.setId(javascriptFramework.getId());
        dto.setName(javascriptFramework.getName());
        dto.setVersion(javascriptFramework.getVersion());
        dto.setDate(javascriptFramework.getDate());
        dto.setReating(javascriptFramework.getReating());

        return dto;
    }

    public JavascriptFramework toEntity(JavascriptFrameworkDTO dto) {
        if (dto == null) {
            return null;
        }

        JavascriptFramework javascriptFramework = new JavascriptFramework();
        javascriptFramework.setId(dto.getId());
        javascriptFramework.setName(dto.getName());
        javascriptFramework.setVersion(dto.getVersion());
        javascriptFramework.setDate(dto.getDate());
        javascriptFramework.setReating(dto.getReating());

        return javascriptFramework;
    }

    public List<JavascriptFrameworkDTO> toDto(List<JavascriptFramework> javascriptFrameworks) {
        return javascriptFrameworks.stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }

    public List<JavascriptFramework> toEntity(List<JavascriptFrameworkDTO> javascriptFrameworkDTO) {
        return javascriptFrameworkDTO.stream()
            .map(this::toEntity)
            .collect(Collectors.toList());
    }
}
