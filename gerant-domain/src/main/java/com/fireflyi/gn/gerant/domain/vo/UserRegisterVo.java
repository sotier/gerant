package com.fireflyi.gn.gerant.domain.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/6
 * DESC TODO
 */
@Data
public class UserRegisterVo {

    //注册id
    private String uid;

    //注册时间
    private Timestamp createTime;

}
