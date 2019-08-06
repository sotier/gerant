package com.fireflyi.gerant.route.ucenter.service;

import com.fireflyi.gerant.route.ucenter.service.impl.UcenterServiceImpl;
import com.fireflyi.gn.gerant.domain.vo.UserRegisterVo;
import com.google.inject.ImplementedBy;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/6
 * DESC TODO
 */
@ImplementedBy(UcenterServiceImpl.class)
public interface UcenterService {

    boolean register(UserRegisterVo var1);




}
