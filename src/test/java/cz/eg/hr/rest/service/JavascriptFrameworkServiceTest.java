package cz.eg.hr.rest.service;

import cz.eg.hr.Application;
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
import java.time.LocalDateTime;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
    void testGetAllReturnsAllSavedFrameworks() {
        JavascriptFrameworkDTO javascriptFrameworkDTO = createDTO();
        JavascriptFramework javascriptFramework = javascriptFrameworkMapper.toEntity(javascriptFrameworkDTO);
        javascriptFrameworkRepository.save(javascriptFramework);
        List<JavascriptFrameworkDTO> javascriptFrameworkDTOS = javascriptFrameworkService.getAll();
        Assertions.assertEquals(1, javascriptFrameworkDTOS.size());
    }

    @Test
    void testSaveSavesJavascriptFramework() {
        JavascriptFrameworkDTO javascriptFrameworkDTO = createDTO();
        javascriptFrameworkService.save(javascriptFrameworkDTO);
        List<JavascriptFramework> allFrameworks = javascriptFrameworkRepository.findAll();
        Assertions.assertEquals(1, allFrameworks.size());
        Assertions.assertEquals(javascriptFrameworkDTO.getName(), allFrameworks.get(0).getName());
    }

    @Test
    void testUpdateByIdUpdatesJavascriptFramework() {
        JavascriptFrameworkDTO javascriptFrameworkDTO = createDTO();
        JavascriptFramework javascriptFramework = javascriptFrameworkMapper.toEntity(javascriptFrameworkDTO);
        JavascriptFramework savedJavascriptFramework = javascriptFrameworkRepository.save(javascriptFramework);
        Assertions.assertNotNull(savedJavascriptFramework);
        Assertions.assertNotNull(savedJavascriptFramework.getId());
        javascriptFrameworkDTO.setVersion(4L);
        javascriptFrameworkService.updateById(savedJavascriptFramework.getId(), javascriptFrameworkDTO);
        JavascriptFramework updatedFramework = javascriptFrameworkRepository.findById(savedJavascriptFramework.getId()).get();
        Assertions.assertEquals(4L, updatedFramework.getVersion());
    }

    @Test
    void testDeleteByIdDeletesJavascriptFramework() {
        JavascriptFrameworkDTO javascriptFrameworkDTO = createDTO();
        JavascriptFramework javascriptFramework = javascriptFrameworkMapper.toEntity(javascriptFrameworkDTO);
        JavascriptFramework savedJavascriptFramework = javascriptFrameworkRepository.save(javascriptFramework);
        Assertions.assertNotNull(savedJavascriptFramework);
        Assertions.assertNotNull(savedJavascriptFramework.getId());
        boolean existsBeforeDelete = javascriptFrameworkRepository.existsById(savedJavascriptFramework.getId());
        Assertions.assertTrue(existsBeforeDelete);
        javascriptFrameworkService.deleteById(savedJavascriptFramework.getId());
        boolean existsAfterDelete = javascriptFrameworkRepository.existsById(savedJavascriptFramework.getId());
        Assertions.assertFalse(existsAfterDelete);
    }

    @Test
    void testGetFrameworkByNameReturnsFrameworkByName() {
        JavascriptFrameworkDTO javascriptFrameworkDTO = createDTO();
        JavascriptFramework javascriptFramework = javascriptFrameworkMapper.toEntity(javascriptFrameworkDTO);
        javascriptFrameworkRepository.save(javascriptFramework);
        JavascriptFrameworkDTO retrievedFramework = javascriptFrameworkService.getFrameworkByName(javascriptFrameworkDTO.getName());
        Assertions.assertEquals(javascriptFrameworkDTO.getName(), retrievedFramework.getName());
    }

    private JavascriptFrameworkDTO createDTO() {
        JavascriptFrameworkDTO dto = new JavascriptFrameworkDTO();
        dto.setId(1L);
        dto.setName("Nikola");
        dto.setReating(3);
        dto.setVersion(3L);
        dto.setDate(LocalDateTime.now());
        return dto;
    }
}
