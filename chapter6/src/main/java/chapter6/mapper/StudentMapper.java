package chapter6.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import chapter6.entity.Student;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
