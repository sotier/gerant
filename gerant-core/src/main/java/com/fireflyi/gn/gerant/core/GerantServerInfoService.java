package com.fireflyi.gn.gerant.core;

import com.fireflyi.gn.gerant.core.impl.GerantServerInfoServiceImpl;
import com.fireflyi.gn.gerant.domain.GerantServerInfoEntity;
import com.google.inject.ImplementedBy;

/**
 * 服务端信息
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/24
 * DESC TODO
 */
@ImplementedBy(GerantServerInfoServiceImpl.class)
public interface GerantServerInfoService {

    GerantServerInfoEntity getServerInfo();
}
