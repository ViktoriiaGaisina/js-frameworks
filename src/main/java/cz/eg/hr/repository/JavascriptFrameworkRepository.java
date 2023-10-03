package cz.eg.hr.repository;


import cz.eg.hr.data.JavascriptFramework;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface JavascriptFrameworkRepository extends CrudRepository<JavascriptFramework, Long> {
    @Override
    List<JavascriptFramework> findAll();

    Optional<JavascriptFramework> findByNameContainingIgnoreCase(String name);
}
