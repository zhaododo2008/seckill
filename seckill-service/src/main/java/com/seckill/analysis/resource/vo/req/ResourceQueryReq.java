package com.seckill.analysis.resource.vo.req;

import com.seckill.analysis.req.PageModel;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * @author zhaododo
 */
@ApiModel(description = "资源分页查询")
public class ResourceQueryReq extends PageModel implements Serializable{
    private static final long serialVersionUID = 8751282105532159742L;

    /**
     * 简述
     */
    private String resume;

    /**
     * 分类 0: 默认值 1: java,2: python
     */
    private Integer type;

    /**
     * 搜索tag
     */
    private String tag;

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}