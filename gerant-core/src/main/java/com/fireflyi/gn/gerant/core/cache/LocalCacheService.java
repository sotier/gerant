package com.fireflyi.gn.gerant.core.cache;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/7
 * DESC 本地缓存服务
 */
public interface LocalCacheService<T> {

    public Boolean set(T var1, T var2);

    public T get(T var);
}
