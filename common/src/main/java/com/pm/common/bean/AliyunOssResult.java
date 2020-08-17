package com.pm.common.bean;

import lombok.Data;

/**
 * <p>
 * 阿里云对象存储操作返回对象
 * </p>
 */
@Data
public class AliyunOssResult {

    /**
     * 是否上传成功
     */
    private Boolean success = false;

    /**
     * 源文件名称
     */
    private String sourceFileName;

    /**
     * 文件保存名称
     */
    private String fileSaveName;

    /**
     * 文件在云端保存全路径
     */
    private String fileSaveFullPath;

    /**
     * 文件保存相对路径
     */
    private String fileSavePath;

    /**
     * 文件扩展名
     */
    private String fileExtension;

    /**
     * 文件大小：单位kb
     */
    private long fileSize;
}
