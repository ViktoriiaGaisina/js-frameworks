package cz.eg.hr.rest.service;

import cz.eg.hr.data.JavascriptFramework;
import cz.eg.hr.dto.JavascriptFrameworkDTO;
import cz.eg.hr.mapper.JavascriptFrameworkMapper;
import cz.eg.hr.repository.JavascriptFrameworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JavascriptFrameworkService {
    private final JavascriptFrameworkMapper javascriptFrameworkMapper;
    private final JavascriptFrameworkRepository javascriptFrameworkRepository;

    @Autowired
    public JavascriptFrameworkService(JavascriptFrameworkMapper javascriptFrameworkMapper, JavascriptFrameworkRepository javascriptFrameworkRepository) {
        this.javascriptFrameworkMapper = javascriptFrameworkMapper;
        this.javascriptFrameworkRepository = javascriptFrameworkRepository;
    }
    public List<JavascriptFrameworkDTO> getAll() {
        return javascriptFrameworkRepository.findAll().stream()
            .map(javascriptFrameworkMapper::toDto)
            .collect(Collectors.toList());
    }
    public JavascriptFrameworkDTO save(JavascriptFrameworkDTO dto) {
        JavascriptFramework javascriptFramework = javascriptFrameworkMapper.toEntity(dto);
        JavascriptFramework javascriptFrameworkEntity = javascriptFrameworkRepository.save(javascriptFramework);
        return javascriptFrameworkMapper.toDto(javascriptFrameworkEntity);
    }
    public JavascriptFrameworkDTO updateById(Long id, JavascriptFrameworkDTO dto) {
        JavascriptFramework javascriptFramework = javascriptFrameworkRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("javascriptFramework not found"));
        javascriptFramework.setDate(dto.getDate());
        javascriptFramework.setVersion(dto.getVersion());
        JavascriptFramework javascriptFramework1 = javascriptFrameworkRepository.save(javascriptFramework);
        return javascriptFrameworkMapper.toDto(javascriptFramework1);
    }
    public void deleteById(Long id) {
        JavascriptFramework javascriptFramework = javascriptFrameworkRepository.findById(id)
            .orElseThrow(() ->new EntityNotFoundException("javascriptFramework not found"));
        javascriptFrameworkRepository.delete(javascriptFramework);
    }
    public JavascriptFrameworkDTO getFrameworkByName(String name) {
        JavascriptFramework javascriptFramework = javascriptFrameworkRepository.findByNameContainingIgnoreCase(name)
            .orElseThrow(() -> new EntityNotFoundException("javascriptFramework not found"));
        return javascriptFrameworkMapper.toDto(javascriptFramework);
    }

}
