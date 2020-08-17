package com.pm.common.bean.page;

import cn.hutool.core.collection.CollUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@ApiModel("分页")
@Data
public class PageInfo<T> {
    @ApiModelProperty(
            value = "当前页",
            position = 1
    )
    private int pageNum;
    @ApiModelProperty(
            value = "每页的数量",
            position = 2
    )
    private int pageSize;
    @ApiModelProperty(
            value = "当前页的数量",
            position = 3
    )
    private int size;
    @ApiModelProperty(
            value = "总记录数",
            position = 4
    )
    private int total;
    @ApiModelProperty(
            value = "总页数",
            position = 5
    )
    private int pages;
    @ApiModelProperty(
            value = "当前页面第一个元素在数据库中的行号",
            position = 6
    )
    private int startRow;
    @ApiModelProperty(
            value = "当前页面最后一个元素在数据库中的行号",
            position = 7
    )
    private int endRow;
    @ApiModelProperty(
            value = "前一页",
            position = 8
    )
    private int prePage;
    @ApiModelProperty(
            value = "下一页",
            position = 9
    )
    private int nextPage;
    @ApiModelProperty(
            value = "是否为第一页",
            position = 10
    )
    private boolean isFirstPage = false;
    @ApiModelProperty(
            value = "是否为最后一页",
            position = 11
    )
    private boolean isLastPage = false;
    @ApiModelProperty(
            value = "是否有前一页",
            position = 12
    )
    private boolean hasPreviousPage = false;
    @ApiModelProperty(
            value = "是否有下一页",
            position = 13
    )
    private boolean hasNextPage = false;
    @ApiModelProperty(
            value = "查询数据列表",
            position = 14
    )
    private List<T> records = Collections.emptyList();

    public PageInfo() {
    }

    public PageInfo(int pageNum, int pageSize, int total, List<T> records) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        if (CollUtil.isNotEmpty(records)) {
            this.records = records;
            this.size = records.size();
        } else {
            this.size = 0;
        }

        this.prePage = pageNum - 1;
        this.calculatePages();
        this.calculateStartAndEndRow();
        this.calcPage();
        this.judgePageBoundary();
    }

    private void calculatePages() {
        if (this.getPageSize() == 0) {
            this.pages = 0;
        }

        int pages = this.getTotal() / this.getPageSize();
        if (this.getTotal() % this.getPageSize() != 0) {
            ++pages;
        }

        this.pages = pages;
    }

    private void calculateStartAndEndRow() {
        if (this.pageNum > 0) {
            this.startRow = (this.pageNum - 1) * this.pageSize + 1;
        } else {
            this.startRow = 0;
        }

        this.endRow = this.startRow - 1 + this.size;
    }

    private void calcPage() {
        if (this.pageNum > 1) {
            this.prePage = this.pageNum - 1;
        } else {
            this.prePage = 1;
        }

        if (this.pageNum < this.pages) {
            this.nextPage = this.pageNum + 1;
        } else {
            this.nextPage = this.pages;
        }

    }

    private void judgePageBoundary() {
        this.isFirstPage = this.pageNum == 1;
        this.isLastPage = this.pageNum == this.pages || this.pages == 0;
        this.hasPreviousPage = this.pageNum > 1;
        this.hasNextPage = this.pageNum < this.pages;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageInfo)) {
            return false;
        } else {
            PageInfo<?> other = (PageInfo)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getPageNum() != other.getPageNum()) {
                return false;
            } else if (this.getPageSize() != other.getPageSize()) {
                return false;
            } else if (this.getSize() != other.getSize()) {
                return false;
            } else if (this.getTotal() != other.getTotal()) {
                return false;
            } else if (this.getPages() != other.getPages()) {
                return false;
            } else if (this.getStartRow() != other.getStartRow()) {
                return false;
            } else if (this.getEndRow() != other.getEndRow()) {
                return false;
            } else if (this.getPrePage() != other.getPrePage()) {
                return false;
            } else if (this.getNextPage() != other.getNextPage()) {
                return false;
            } else if (this.isFirstPage() != other.isFirstPage()) {
                return false;
            } else if (this.isLastPage() != other.isLastPage()) {
                return false;
            } else if (this.isHasPreviousPage() != other.isHasPreviousPage()) {
                return false;
            } else if (this.isHasNextPage() != other.isHasNextPage()) {
                return false;
            } else {
                Object this$records = this.getRecords();
                Object other$records = other.getRecords();
                if (this$records == null) {
                    if (other$records != null) {
                        return false;
                    }
                } else if (!this$records.equals(other$records)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageInfo;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 59 + this.getPageNum();
        result = result * 59 + this.getPageSize();
        result = result * 59 + this.getSize();
        result = result * 59 + this.getTotal();
        result = result * 59 + this.getPages();
        result = result * 59 + this.getStartRow();
        result = result * 59 + this.getEndRow();
        result = result * 59 + this.getPrePage();
        result = result * 59 + this.getNextPage();
        result = result * 59 + (this.isFirstPage() ? 79 : 97);
        result = result * 59 + (this.isLastPage() ? 79 : 97);
        result = result * 59 + (this.isHasPreviousPage() ? 79 : 97);
        result = result * 59 + (this.isHasNextPage() ? 79 : 97);
        Object $records = this.getRecords();
        result = result * 59 + ($records == null ? 43 : $records.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PageInfo(pageNum=" + this.getPageNum() + ", pageSize=" + this.getPageSize() + ", size=" + this.getSize() + ", total=" + this.getTotal() + ", pages=" + this.getPages() + ", startRow=" + this.getStartRow() + ", endRow=" + this.getEndRow() + ", prePage=" + this.getPrePage() + ", nextPage=" + this.getNextPage() + ", isFirstPage=" + this.isFirstPage() + ", isLastPage=" + this.isLastPage() + ", hasPreviousPage=" + this.isHasPreviousPage() + ", hasNextPage=" + this.isHasNextPage() + ", records=" + this.getRecords() + ")";
    }
}
