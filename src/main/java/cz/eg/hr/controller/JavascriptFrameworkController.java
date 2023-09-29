package cz.eg.hr.controller;

import cz.eg.hr.data.JavascriptFramework;
import cz.eg.hr.repository.JavascriptFrameworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavascriptFrameworkController {

    private final JavascriptFrameworkRepository repository;

    @Autowired
    public JavascriptFrameworkController(JavascriptFrameworkRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/frameworks")
    public Iterable<JavascriptFramework> frameworks() {
        return repository.findAll();
    }

}
