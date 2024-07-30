package com.atguigu.dao;

import com.atguigu.pojo.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * ClassName: StudentDao
 * Package: com.atguigu.dao
 * Description: 数据层的接口
 *
 * @Author wk
 * @Create 2024/7/30 22:33
 * @Version 1.0
 */
public interface StudentDao {

    /**
     * 数据库查询全部学生数据
     * @return
     */
    List<Student> queryAll();
}
