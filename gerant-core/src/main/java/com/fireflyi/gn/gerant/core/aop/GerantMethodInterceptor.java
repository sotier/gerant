package com.fireflyi.gn.gerant.core.aop;

import com.fireflyi.gn.gerant.core.annotation.Gnamed;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ResourceBundle;


/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/22
 * DESC TODO
 */
public class GerantMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //读取配置文件属性值
//        ResourceBundle resource = ResourceBundle.getBundle("guice");
//        String key = resource.getString("xqx.port");

        System.out.println("Before"+methodInvocation.getMethod().getName());

        Object result = methodInvocation.proceed();
        return result;

    }


}
