package cz.eg.hr.rest.service;

import cz.eg.hr.data.JavascriptFramework;
import cz.eg.hr.dto.JavascriptFrameworkDTO;
import cz.eg.hr.mapper.JavascriptFrameworkMapper;
import cz.eg.hr.repository.JavascriptFrameworkRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.List;


@ActiveProfiles("test")
@SpringBootTest(classes = JavascriptFrameworkService.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JavascriptFrameworkServiceTest {
    @Autowired
    private JavascriptFrameworkService javascriptFrameworkService;

    @Autowired
    private JavascriptFrameworkRepository javascriptFrameworkRepository;

    @Autowired
    JavascriptFrameworkMapper javascriptFrameworkMapper;

    @AfterEach
    public void cleanUpEach() {
        javascriptFrameworkRepository.deleteAll();
    }

    @Test
    void getAll() {
        JavascriptFrameworkDTO javascriptFrameworkDTO = createDTO();
        JavascriptFramework javascriptFramework = javascriptFrameworkMapper.toEntity(javascriptFrameworkDTO);
        javascriptFrameworkRepository.save(javascriptFramework);
        javascriptFrameworkService = new JavascriptFrameworkService(javascriptFrameworkMapper, javascriptFrameworkRepository);
        List<JavascriptFrameworkDTO> javascriptFrameworkDTOS = javascriptFrameworkService.getAll();
        Assertions.assertEquals(javascriptFrameworkDTOS.size(), 1);
    }

    @Test
    void save() {JavascriptFrameworkDTO javascriptFrameworkDTO = createDTO();
        JavascriptFramework javascriptFramework = javascriptFrameworkMapper.toEntity(javascriptFrameworkDTO);
        javascriptFrameworkService.save(javascriptFrameworkDTO);
        List<JavascriptFramework> allFrameworks = javascriptFrameworkRepository.findAll();
        Assertions.assertTrue(allFrameworks.contains(javascriptFramework));
    }

    @Test
    void updateById() {
        JavascriptFrameworkDTO javascriptFrameworkDTO = createDTO();
        JavascriptFramework javascriptFramework = javascriptFrameworkMapper.toEntity(javascriptFrameworkDTO);
        javascriptFrameworkRepository.save(javascriptFramework);
        javascriptFrameworkDTO.setVersion(4L);
        javascriptFrameworkService.updateById(javascriptFramework.getId(), javascriptFrameworkDTO);
        JavascriptFramework updatedFramework = javascriptFrameworkRepository.findById(javascriptFramework.getId()).get();
        Assertions.assertEquals(4L, updatedFramework.getVersion());
    }

    @Test
    void deleteById() {
        JavascriptFrameworkDTO javascriptFrameworkDTO = createDTO();
        JavascriptFramework javascriptFramework = javascriptFrameworkMapper.toEntity(javascriptFrameworkDTO);
        javascriptFrameworkRepository.save(javascriptFramework);
        javascriptFrameworkService.deleteById(javascriptFramework.getId());
        boolean exists = javascriptFrameworkRepository.existsById(javascriptFramework.getId());
        Assertions.assertFalse(exists);
    }

    @Test
    void getFrameworkByName() {
        JavascriptFrameworkDTO javascriptFrameworkDTO = createDTO();
        JavascriptFramework javascriptFramework = javascriptFrameworkMapper.toEntity(javascriptFrameworkDTO);
        javascriptFrameworkRepository.save(javascriptFramework);
        JavascriptFrameworkDTO retrievedFramework = javascriptFrameworkService.getFrameworkByName(javascriptFrameworkDTO.getName());
        Assertions.assertEquals(javascriptFrameworkDTO.getName(), retrievedFramework.getName());
    }

    private JavascriptFrameworkDTO createDTO() {
        return JavascriptFrameworkDTO.builder()
            .name("Nikola")
            .reating(3)
            .version(3L).build();
    }
}
