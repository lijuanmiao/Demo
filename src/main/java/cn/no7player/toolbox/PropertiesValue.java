package cn.no7player.toolbox;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by lijm on 2017-09-19.
 * 获取配置文件的属性值
 */
public class PropertiesValue {

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("application");

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return key;
        }
    }
}