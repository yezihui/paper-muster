package com.pm.common.bean.page;

import io.swagger.annotations.ApiModelProperty;

import java.util.Arrays;

public class PageQuery<T> {
    @ApiModelProperty(
            value = "页码",
            example = "1",
            position = 1
    )
    private Integer pageNo;
    @ApiModelProperty(
            value = "每页的条数",
            example = "10",
            position = 2
    )
    private Integer pageSize;
    @ApiModelProperty(
            value = "排序(asc 或者 desc)",
            position = 3
    )
    private String[] sort;
    @ApiModelProperty(
            value = "排序字段名称",
            position = 4
    )
    private String[] orderField;
    @ApiModelProperty(
            value = "分页查询条件",
            position = 5
    )
    private T condition;

    public Integer getPageNo() {
        return this.pageNo;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public String[] getSort() {
        return this.sort;
    }

    public String[] getOrderField() {
        return this.orderField;
    }

    public T getCondition() {
        return this.condition;
    }

    public PageQuery<T> setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public PageQuery<T> setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public PageQuery<T> setSort(String[] sort) {
        this.sort = sort;
        return this;
    }

    public PageQuery<T> setOrderField(String[] orderField) {
        this.orderField = orderField;
        return this;
    }

    public PageQuery<T> setCondition(T condition) {
        this.condition = condition;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageQuery)) {
            return false;
        } else {
            PageQuery<?> other = (PageQuery)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label55: {
                    Object this$pageNo = this.getPageNo();
                    Object other$pageNo = other.getPageNo();
                    if (this$pageNo == null) {
                        if (other$pageNo == null) {
                            break label55;
                        }
                    } else if (this$pageNo.equals(other$pageNo)) {
                        break label55;
                    }

                    return false;
                }

                Object this$pageSize = this.getPageSize();
                Object other$pageSize = other.getPageSize();
                if (this$pageSize == null) {
                    if (other$pageSize != null) {
                        return false;
                    }
                } else if (!this$pageSize.equals(other$pageSize)) {
                    return false;
                }

                if (!Arrays.deepEquals(this.getSort(), other.getSort())) {
                    return false;
                } else if (!Arrays.deepEquals(this.getOrderField(), other.getOrderField())) {
                    return false;
                } else {
                    Object this$condition = this.getCondition();
                    Object other$condition = other.getCondition();
                    if (this$condition == null) {
                        if (other$condition != null) {
                            return false;
                        }
                    } else if (!this$condition.equals(other$condition)) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageQuery;
    }

    @Override
    public int hashCode() {
        int result = 1;
        Object $pageNo = this.getPageNo();
         result = result * 59 + ($pageNo == null ? 43 : $pageNo.hashCode());
        Object $pageSize = this.getPageSize();
        result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
        result = result * 59 + Arrays.deepHashCode(this.getSort());
        result = result * 59 + Arrays.deepHashCode(this.getOrderField());
        Object $condition = this.getCondition();
        result = result * 59 + ($condition == null ? 43 : $condition.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PageQuery(pageNo=" + this.getPageNo() + ", pageSize=" + this.getPageSize() + ", sort=" + Arrays.deepToString(this.getSort()) + ", orderField=" + Arrays.deepToString(this.getOrderField()) + ", condition=" + this.getCondition() + ")";
    }

    public PageQuery() {
    }

    public PageQuery(Integer pageNo, Integer pageSize, String[] sort, String[] orderField, T condition) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.sort = sort;
        this.orderField = orderField;
        this.condition = condition;
    }
}
