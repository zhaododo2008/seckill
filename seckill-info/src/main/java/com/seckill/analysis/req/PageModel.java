package com.seckill.analysis.req;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhaododo
 **/

public class PageModel {
    private static final long serialVersionUID = -2601885197956626599L;

    @ApiModelProperty(value = "第几页")
    private int pageNo = 1;

    @ApiModelProperty(value = "每页大小")
    private int pageSize = 10;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return (this.pageNo - 1) * this.pageSize;
    }
}
