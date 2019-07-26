package com.fireflyi.gn.gerant.core.impl;

import com.fireflyi.gn.gerant.core.GerantServerInfoService;
import com.fireflyi.gn.gerant.domain.GerantServerInfoEntity;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * 本机测试实现类
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/24
 * DESC TODO
 */
@Singleton
public class GerantServerInfoServiceImpl implements GerantServerInfoService {

    @Inject
    @Named("base.server.ip")
    private String ip;

    @Inject
    @Named("base.server.port")
    private Integer port;

    @Override
    public GerantServerInfoEntity getServerInfo() {
        GerantServerInfoEntity gi = new GerantServerInfoEntity();
        gi.setIp("127.0.0.1");
        gi.setPort(6288);
        return gi;
    }
}
