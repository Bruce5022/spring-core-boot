package com.sky.boot.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;
/**
 * 执行流程:
 * 1.IOC容器创建对象
 * 2.invokeBeanFactoryPostProcessors(beanFactory);执行BeanFactoryPostProcessor
 *  如何找到所有的BeanFactoryPostProcessor并执行他们的方法:
 *  a.直接在beanFactory中找到所有的类型是执行BeanFactoryPostProcessor的组件,并执行他们的方法
 *  b.源码看,在初始化创建其它组件前面执行
 */

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        System.out.println(".........调用了后置处理器.........");
        System.out.println("Bean数量:"+beanFactory.getBeanDefinitionCount());
        Iterator<String> beanNames = beanFactory.getBeanNamesIterator();
        while (beanNames.hasNext()){
            System.out.println("--->"+beanNames.next());
        }



        System.out.println("后置处理器数量:"+beanFactory.getBeanPostProcessorCount());
        System.out.println("单例数量:"+beanFactory.getSingletonCount());
        System.out.println("===============调用了后置处理器end===============");
    }
}
