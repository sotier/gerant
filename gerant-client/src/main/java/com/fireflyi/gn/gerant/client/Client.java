package com.fireflyi.gn.gerant.client;

import com.fireflyi.gn.gerant.client.core.GerantSocketclient;
import com.fireflyi.gn.gerant.core.annotation.Gnamed;
import com.fireflyi.gn.gerant.core.aop.GerantMethodInterceptor;
import com.fireflyi.gn.gerant.core.util.PropertyUtil;
import com.google.inject.*;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/24
 * DESC TODO
 */
public class Client {

    @Inject
    GerantSocketclient gerantSocketclient;

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
        GerantSocketclient gcc = injector.getInstance(Client.class).gerantSocketclient;
    }
}
