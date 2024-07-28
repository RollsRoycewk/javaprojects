package com.atguigu.test;

import com.atguigu.ioc_03.A;
import com.atguigu.ioc_03.HappyComponent;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: SpringIoCtest
 * Package: com.atguigu.test
 * Description: ioc容器创建和读取组件的测试类
 *
 * @Author wk
 * @Create 2024/7/28 20:38
 * @Version 1.0
 */
public class SpringIoCtest {
    /**
     * 讲解如何创建ioc容器并且读取配置文件
     */
    public void createIoC(){
        //创建容器 选择合适的容器实现即可!
        /**
         * 接口
         *    BeanFactory
         *
         *    ApplicationContext
         *
         * 实现类
         *    可以直接通过构造函数实例化!
         *    ClassPathXmlApplicationContext  读取类路径下的xml配置方式  classes
         *    FileSystemXmlApplicationContext 读取指定文件位置的xml配置方式
         *    AnnotationConfigApplicationContext 读取配置类方式的ioc容器
         *    WebApplicationContext           web项目专属的配置的ioc容器
         *
         */

        //方式1: 直接创建容器并且指定配置文件即可 [推荐]
        // 构造函数(String...配置文件) 可以填写一个或者多个
        // ioc di
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        //方式2: 先创建ioc容器对象,再指定配置文件,再刷新!
        //源码的配置过程!  创建容器 [spring] 和 配置文件指定分开 [自己指定]
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        //外部配置文件的设置
        applicationContext1.setConfigLocations("spring-03.xml");
        //调用ioc和di的流程
        applicationContext1.refresh();
    }

    /**
     * 讲解如何在IoC容器中获取组件Bean
     */
    @Test
    public void getBeanFromIoC(){
        //1.创建ioc容器对象
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocations("spring-03.xml");
        //ioc di的动作
        applicationContext.refresh();

        //2.读取ioc容器的组件
        //方案1: 直接根据beanId获取即可  返回值类型是Object 需要强转 [不推荐]
        HappyComponent happyComponent = (HappyComponent) applicationContext.getBean("happyComponent");

        //方案2: 根据beanId,同时指定bean的类型 Class
        HappyComponent happyComponent1 = applicationContext.getBean("happyComponent", HappyComponent.class);

        //方案3: 直接根据类型获取
        //TODO: 根据bean的类型获取,同一个类型,在ioc容器中只能有一个bean!!!
        //TODO: 如果ioc容器存在多个同类型的Bean 会出现: NoUniqueBeanDefinitionException
        //TODO: ioc的配置一定是实现类,但是可以根据接口类型获取值!   getBean(类型);  instanceof  ioc容器的类型  == true
        A happyComponent2 = applicationContext.getBean(A.class);
        happyComponent2.doWork();

        System.out.println(happyComponent == happyComponent1);
        System.out.println(happyComponent2 == happyComponent1);

    }
}
