package com.fireflyi.gn.gerant.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/22
 * DESC TODO
 */
public class PropertyUtil {

    public static List<String> bindProperties(){
        String guice = "config/guice.properties";
        String cache = "config/cache.properties";

        ArrayList<String> l = new ArrayList<String>();
        l.add(guice);
        l.add(cache);
        return l;
    }


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
