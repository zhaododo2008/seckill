package com.seckill.analysis.resource.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seckill.analysis.resource.po.Resource;
import com.seckill.analysis.resource.vo.req.ResourceQueryReq;

/**
 * @author zhaododo
 **/

public interface IResourceService extends IService<Resource> {

    /**
     * 分页查询
     * @param queryReq
     * @return
     */
    IPage<Resource> queryByPage(ResourceQueryReq queryReq);
}
