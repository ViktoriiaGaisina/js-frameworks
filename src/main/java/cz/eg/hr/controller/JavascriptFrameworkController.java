package cz.eg.hr.controller;

import cz.eg.hr.dto.JavascriptFrameworkDTO;
import cz.eg.hr.rest.service.JavascriptFrameworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frameworks")
public class JavascriptFrameworkController {

    private final JavascriptFrameworkService javascriptFrameworkService;

    @Autowired
    public JavascriptFrameworkController(JavascriptFrameworkService javascriptFrameworkService) {
        this.javascriptFrameworkService = javascriptFrameworkService;
    }

    @GetMapping
    public List<JavascriptFrameworkDTO> getAllFrameworks() {
        return javascriptFrameworkService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public JavascriptFrameworkDTO save(@RequestBody JavascriptFrameworkDTO dto) {
        return javascriptFrameworkService.save(dto);
    }

    @PatchMapping("/update/{id}")
    public JavascriptFrameworkDTO updateById(@PathVariable Long id, @RequestBody JavascriptFrameworkDTO dto) {
        return javascriptFrameworkService.updateById(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(Long id) {
        javascriptFrameworkService.deleteById(id);
    }

    @GetMapping("/by-name")
    public JavascriptFrameworkDTO getFrameworkByName(@RequestParam String name) {
        return javascriptFrameworkService.getFrameworkByName(name);
    }
}
