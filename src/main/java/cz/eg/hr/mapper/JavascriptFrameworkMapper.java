package cz.eg.hr.mapper;

import cz.eg.hr.data.JavascriptFramework;
import cz.eg.hr.dto.JavascriptFrameworkDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JavascriptFrameworkMapper {
    JavascriptFrameworkDTO toDto(JavascriptFramework javascriptFramework);
    JavascriptFramework toEntity(JavascriptFrameworkDTO dto);
    List<JavascriptFrameworkDTO> toDto(List<JavascriptFramework> javascriptFrameworks);
    List<JavascriptFramework> toEntity(List<JavascriptFrameworkDTO> javascriptFrameworkDTO);
}
