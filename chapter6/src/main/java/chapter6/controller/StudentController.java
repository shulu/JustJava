package chapter6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chapter6.entity.Result;
import chapter6.entity.Student;
import chapter6.service.IStudentService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    IStudentService iStudentService;

    @GetMapping
    public Result<?> findAllStudents() {
        List<Student> students = iStudentService.list();
        return Result.success(students);
    }

    @PostMapping
    public Result<?> save(@RequestBody Student student) {
        iStudentService.save(student);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody Student student) {
        iStudentService.updateById(student);
        return Result.success();
    }

    @DeleteMapping
    public Result<?> delete(@PathVariable long id) {
        iStudentService.removeById(id);
        return Result.success();
    }
}
