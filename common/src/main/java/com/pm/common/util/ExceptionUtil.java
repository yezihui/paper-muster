package com.pm.common.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.pm.common.exception.AbstractBaseExceptionEnum;
import com.pm.common.exception.ServiceException;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

/**
 * @Desc
 * @Author yejx
 * @Date 2020/6/7
 */
public class ExceptionUtil {
    public ExceptionUtil() {
    }

    public static void isTrue(boolean expression, AbstractBaseExceptionEnum e) {
        if (!expression) {
            throw new ServiceException(e);
        }
    }

    public static void isFalse(boolean expression, AbstractBaseExceptionEnum e) {
        if (expression) {
            throw new ServiceException(e);
        }
    }

    public static void isNull(Object obj, AbstractBaseExceptionEnum e) {
        if (ObjectUtil.isNotNull(obj)) {
            throw new ServiceException(e);
        }
    }

    public static void isNotNull(Object obj, AbstractBaseExceptionEnum e) {
        if (ObjectUtil.isNull(obj)) {
            throw new ServiceException(e);
        }
    }

    public static void isEmpty(CharSequence str, AbstractBaseExceptionEnum e) {
        if (StrUtil.isNotEmpty(str)) {
            throw new ServiceException(e);
        }
    }

    public static void isNotEmpty(CharSequence str, AbstractBaseExceptionEnum e) {
        if (StrUtil.isEmpty(str)) {
            throw new ServiceException(e);
        }
    }

    public static void isBlank(CharSequence str, AbstractBaseExceptionEnum e) {
        if (StrUtil.isNotBlank(str)) {
            throw new ServiceException(e);
        }
    }

    public static void isNotBlank(CharSequence str, AbstractBaseExceptionEnum e) {
        if (StrUtil.isBlank(str)) {
            throw new ServiceException(e);
        }
    }

    public static void isNotEmpty(Collection<?> collection, AbstractBaseExceptionEnum e) {
        if (CollUtil.isEmpty(collection)) {
            throw new ServiceException(e);
        }
    }

    public static void isNotEmpty(Map<?, ?> map, AbstractBaseExceptionEnum e) {
        if (CollUtil.isEmpty(map)) {
            throw new ServiceException(e);
        }
    }

    public static void isNotEmpty(Iterable<?> iterable, AbstractBaseExceptionEnum e) {
        if (CollUtil.isEmpty(iterable)) {
            throw new ServiceException(e);
        }
    }

    public static void isNotEmpty(Iterator<?> iterator, AbstractBaseExceptionEnum e) {
        if (CollUtil.isNotEmpty(iterator)) {
            throw new ServiceException(e);
        }
    }

    public static void isNotEmpty(Enumeration<?> enumeration, AbstractBaseExceptionEnum e) {
        if (CollUtil.isNotEmpty(enumeration)) {
            throw new ServiceException(e);
        }
    }

    public static void isEmpty(Collection<?> collection, AbstractBaseExceptionEnum e) {
        if (CollUtil.isNotEmpty(collection)) {
            throw new ServiceException(e);
        }
    }

    public static void isEmpty(Map<?, ?> map, AbstractBaseExceptionEnum e) {
        if (CollUtil.isNotEmpty(map)) {
            throw new ServiceException(e);
        }
    }

    public static void isEmpty(Iterable<?> iterable, AbstractBaseExceptionEnum e) {
        if (CollUtil.isNotEmpty(iterable)) {
            throw new ServiceException(e);
        }
    }

    public static void isEmpty(Iterator<?> iterator, AbstractBaseExceptionEnum e) {
        if (CollUtil.isNotEmpty(iterator)) {
            throw new ServiceException(e);
        }
    }

    public static void isEmpty(Enumeration<?> enumeration, AbstractBaseExceptionEnum e) {
        if (CollUtil.isNotEmpty(enumeration)) {
            throw new ServiceException(e);
        }
    }
}
