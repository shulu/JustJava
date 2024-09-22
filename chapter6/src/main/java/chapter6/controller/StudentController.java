package chapter6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import chapter6.entity.Result;
import chapter6.entity.Student;
import chapter6.service.IStudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    IStudentService iStudentService;

    @GetMapping
    public Result<?> findPage(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(name = "search", defaultValue = "", required = false) String search) {
        Page<Student> page = iStudentService.page(new Page<>(pageNum, pageSize),
                Wrappers.<Student>lambdaQuery().like(Student::getStudentname, search));
        return Result.success(page);
    }

    // @GetMapping
    // public Result<?> findAllStudents() {
    // List<Student> students = iStudentService.list();
    // return Result.success(students);
    // }

    @PostMapping
    public Result<?> save(@RequestBody Student student) {
        System.out.println(student);
        iStudentService.save(student);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody Student student) {
        System.out.println(student);
        iStudentService.updateById(student);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable("id") long id) {
        System.out.println(id);
        iStudentService.removeById(id);
        return Result.success();
    }
}
