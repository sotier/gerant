package com.gerant.msync;

import com.fireflyi.gn.gerant.common.util.PropertyUtil;
import com.fireflyi.gn.gerant.core.annotation.Gnamed;
import com.fireflyi.gn.gerant.core.aop.GerantMethodInterceptor;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/26
 * DESC 异步消息同步服务
 */
public class MsyncLaunches {


    public static void main(String[] a){

        final String file = "config/guice.properties";
        final String cacheFile = "config/cache.properties";

        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                Names.bindProperties(binder, PropertyUtil.loadFile(file, getClass()));
                Names.bindProperties(binder, PropertyUtil.loadFile(cacheFile, getClass()));
                binder.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Gnamed.class), new GerantMethodInterceptor());
            }
        });
        //McenterApplication mscs = injector.getInstance(MsyncLaunches.class).mcenterApplication;
    }


}
