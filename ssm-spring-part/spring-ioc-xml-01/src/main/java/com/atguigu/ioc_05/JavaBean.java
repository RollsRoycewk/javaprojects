package com.atguigu.ioc_05;

/**
 * ClassName: JavaBean
 * Package: com.atguigu.ioc_05
 * Description:
 *
 * @Author wk
 * @Create 2024/7/29 23:11
 * @Version 1.0
 */
public class JavaBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
