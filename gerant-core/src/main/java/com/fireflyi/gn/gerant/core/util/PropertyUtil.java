package com.fireflyi.gn.gerant.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/22
 * DESC TODO
 */
public class PropertyUtil {

    /**
     *
     * @param prefix
     * @param cla
     * @return
     */
    public static Properties loadFile(String prefix, Class<?> cla) {
        String fileName = prefix;
        Properties prop = new Properties();
        InputStream in = null;
        try {
            in = cla.getResource("/" + fileName).openStream();
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

}
