package net.wincn.core.utils;

import com.jfinal.kit.PathKit;
import net.wincn.core.bean.AppConfig;
import net.wincn.core.bean.Doc;
import net.wincn.core.bean.Menu;
import net.wincn.core.bean.Slider;
import org.apache.commons.lang3.StringUtils;
import org.ho.yaml.Yaml;

/**
 * 获得站点信息的工具类
 * Author: gefangshuai
 * Create: 2014-03-30 09:07
 */
public class AppConfigUtils {
    private static final String YAML_PATH = PathKit.getRootClassPath()+"/resources/config.yaml";
    public static String getTheme() {
        return getConfig().getTheme();
    }

    public static Doc getDoc() {
        Doc doc = new Doc();
        return doc;
    }

    public static Menu getMenu() {
        Menu menu = new Menu();
        return menu;
    }


    public static Slider getSlider() {
        Slider slider = new Slider();
        return slider;
    }

    private static AppConfig getConfig(){
        AppConfig config = Yaml.loadType(YAML_PATH, AppConfig.class);
        return config;
    }

    /**
     * 获得文档输出路径
     * @return
     */
    public static String getDocOutPath(Doc doc) {
        return doc.getPath();
    }

    public static String getPostTemplate(Doc doc) {
        return StringUtils.isBlank(doc.getLayout())?getConfig().getPostVM():doc.getLayout();
    }

    public static Object getSite() {
        return getConfig().getSite();
    }
}
