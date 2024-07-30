package com.atguigu.service;

import com.atguigu.pojo.Student;

import java.util.List;

/**
 * ClassName: StudentService
 * Package: com.atguigu.service
 * Description: 学生业务接口
 *
 * @Author wk
 * @Create 2024/7/30 22:56
 * @Version 1.0
 */
public interface StudentService {
    /**
     * 查询所有学员数据业务
     * @return
     */
    List<Student> findAll();
}
