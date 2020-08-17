package com.pm.common.bean.page;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public class PageFactory {
    private static final String ASC = "asc";
    private static final String PAGE_SIZE_PARAM_NAME = "pageSize";
    private static final String PAGE_NO_PARAM_NAME = "pageNo";
    private static final String SORT_PARAM_NAME = "sort";
    private static final String ORDER_BY_PARAM_NAME = "orderField";

    public PageFactory() {
    }

    public static <T> Page<T> createPage(PageQuery pageQuery) {
        int pageSize = 20;
        int pageNo = 1;
        if (pageQuery != null && ObjectUtil.isNotNull(pageQuery.getPageSize())) {
            pageSize = pageQuery.getPageSize();
        }

        if (pageQuery != null && ObjectUtil.isNotNull(pageQuery.getPageNo())) {
            pageNo = pageQuery.getPageNo();
        }

        Page page;
        if (pageQuery == null) {
            page = new Page((long)pageNo, (long)pageSize);
            return page;
        } else {
            page = new Page((long)pageNo, (long)pageSize);
            String[] sorts = pageQuery.getSort();
            String[] orderFields = pageQuery.getOrderField();
            if (ArrayUtil.isEmpty(sorts)) {
                return page;
            } else {
                if (ArrayUtil.isNotEmpty(orderFields) && sorts.length == orderFields.length) {
                    int i = 0;

                    for(int len = sorts.length; i < len; ++i) {
                        if ("asc".equalsIgnoreCase(sorts[i])) {
                            page.setAsc(new String[]{orderFields[i]});
                        } else {
                            page.setDesc(new String[]{orderFields[i]});
                        }
                    }
                }

                return page;
            }
        }
    }

    public static <T> Page<T> createPage(PageQuery pageQuery, boolean isToSymbolCase) {
        int pageSize = 20;
        int pageNo = 1;
        if (pageQuery != null && ObjectUtil.isNotNull(pageQuery.getPageSize())) {
            pageSize = pageQuery.getPageSize();
        }

        if (pageQuery != null && ObjectUtil.isNotNull(pageQuery.getPageNo())) {
            pageNo = pageQuery.getPageNo();
        }

        Page page;
        if (pageQuery == null) {
            page = new Page((long)pageNo, (long)pageSize);
            return page;
        } else {
            page = new Page((long)pageNo, (long)pageSize);
            String[] sorts = pageQuery.getSort();
            String[] orderFields = pageQuery.getOrderField();
            if (ArrayUtil.isEmpty(sorts)) {
                return page;
            } else {
                if (ArrayUtil.isNotEmpty(orderFields) && sorts.length == orderFields.length) {
                    int i = 0;

                    for(int len = sorts.length; i < len; ++i) {
                        if ("asc".equalsIgnoreCase(sorts[i])) {
                            if (isToSymbolCase) {
                                page.setAsc(new String[]{StrUtil.toSymbolCase(orderFields[i], '_')});
                            } else {
                                page.setAsc(new String[]{orderFields[i]});
                            }
                        } else if (isToSymbolCase) {
                            page.setDesc(new String[]{StrUtil.toSymbolCase(orderFields[i], '_')});
                        } else {
                            page.setDesc(new String[]{orderFields[i]});
                        }
                    }
                }

                return page;
            }
        }
    }
}
