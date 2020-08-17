package com.pm.cache.constants;

/**
 * <p>
 * Redis目录常量
 * </p>
 *
 * @author yejx
 * @date 2019-12-13 11:17
 */
public interface RedisDirConstants {

    /**
     * Website用户登录的TOKEN目录
     */
    String WEBSITE_LOGIN_USER_TOKEN_PREFIX = "security:website:token:";

    /**
     * 后台用户登录的TOKEN
     */
    String WEB_LOGIN_USER_TOKEN_PREFIX = "security:web:token:";

    /**
     * 系统菜单
     */
    String SYSTEM_MENU_LIST_KEY = "system:menu";

    /**
     * 字典树目录
     */
    String DICTIONARY_TREE_KEY = "dictionary:tree";

    /**
     * 全国区域地区列表
     */
    String REGION_LIST_KEY = "region:tree";

    /**
     * 全国区域地区列表
     */
    String DOMAIN_REGION_LIST_KEY = "domain:region:tree";

    /**
     * 用户账号密码错误次数
     * 第一个参数 代表是后台-还是网站应用
     * 第二个参数 代表用户id
     */
    String USER_PASSWORD_ERROR = "security:{}:pwd:error:{}";

    /**
     * 用户账号错误5次 锁定标识 半小时过期
     * 第一个参数 代表是后台-还是网站应用
     * 第二个参数 代表用户id
     */
    String USER_PASSWORD_LOCK = "security:{}:lock:{}";


    /**
     * 企业区域权限信息
     */
    String COMPANY_REGION_AUTH = "company:region:auth";

    /**
     * 企业区域权限列表
     */
    String COMPANY_REGION_LIST = "company:region:list";

    /**
     * bannerLsit
     */
    String BANNER_LIST = "banner:list";

}
