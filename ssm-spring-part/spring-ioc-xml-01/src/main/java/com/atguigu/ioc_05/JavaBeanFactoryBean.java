package com.atguigu.ioc_05;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Factory;

/**
 * ClassName: JavaBeanFactoryBean
 * Package: com.atguigu.ioc_05
 * Description:
 *
 * @Author wk
 * @Create 2024/7/29 23:13
 * @Version 1.0
 */
public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public JavaBean getObject() throws Exception {
        //使用你自己的方式实例化对象就可以了!
        JavaBean javaBean = new JavaBean();
        javaBean.setName(value);
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }
}
