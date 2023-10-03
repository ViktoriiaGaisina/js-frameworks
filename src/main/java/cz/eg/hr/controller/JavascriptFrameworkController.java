package cz.eg.hr.controller;

import cz.eg.hr.data.JavascriptFramework;
import cz.eg.hr.dto.JavascriptFrameworkDTO;
import cz.eg.hr.rest.service.JavascriptFrameworkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frameworks")
@Api(tags = "info javascriptFramework")
public class JavascriptFrameworkController {

    private final JavascriptFrameworkService javascriptFrameworkService;

    @Autowired
    public JavascriptFrameworkController(JavascriptFrameworkService javascriptFrameworkService) {
        this.javascriptFrameworkService = javascriptFrameworkService;
    }

    @ApiOperation("find data for javascriptFramework")
    @GetMapping
    public List<JavascriptFrameworkDTO> getAllFrameworks() {
        return javascriptFrameworkService.getAll();
    }

    @ApiOperation("save data about javascriptFramework")
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public JavascriptFrameworkDTO save(@RequestBody JavascriptFrameworkDTO dto) {
        return javascriptFrameworkService.save(dto);
    }

    @ApiOperation("update data javascriptFramework by id")
    @PatchMapping("/update/{id}")
    public JavascriptFrameworkDTO updateById(@PathVariable Long id, @RequestBody JavascriptFrameworkDTO dto) {
        return javascriptFrameworkService.updateById(id, dto);
    }

    @ApiOperation("delete data javascriptFramework by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(Long id) {
        javascriptFrameworkService.deleteById(id);
    }


    @ApiOperation("Retrieve a Javascript framework by its name")
    @GetMapping("/by-name")
    public JavascriptFrameworkDTO getFrameworkByName(@RequestParam String name) {
        return javascriptFrameworkService.getFrameworkByName(name);
    }


}
