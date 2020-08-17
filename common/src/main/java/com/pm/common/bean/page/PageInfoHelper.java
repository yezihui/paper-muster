package com.pm.common.bean.page;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public class PageInfoHelper {

    public PageInfoHelper() {
    }

    public static <T> PageInfo<T> build(IPage<T> page) {
        PageInfo<T> pageInfo = new PageInfo((int) page.getCurrent(), (int) page.getSize(), (int) page.getTotal(), page.getRecords());
        return pageInfo;
    }

    public static <T> PageInfo<T> build(int pageNum, int pageSize, int total, List<T> records) {
        return new PageInfo(pageNum, pageSize, total, records);
    }
}
