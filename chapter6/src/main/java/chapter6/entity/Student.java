package chapter6.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String studentname;
    private String gender;
    private Integer age;
    private String address;
}
