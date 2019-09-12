package com.seckill.analysis.resource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.analysis.resource.mapper.IResourceMapper;
import com.seckill.analysis.resource.po.Resource;
import com.seckill.analysis.resource.service.IResourceService;
import com.seckill.analysis.resource.vo.req.ResourceQueryReq;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author zhaododo
 **/

@Component
@Service(version = "1.0.0")
public class ResourceServiceImpl extends ServiceImpl<IResourceMapper, Resource> implements IResourceService {

    @Override
    public IPage<Resource> queryByPage(ResourceQueryReq queryReq) {

        Page<Resource> page = new Page<>(queryReq.getPageNo(),queryReq.getPageSize());
        QueryWrapper<Resource> queryWrapper = new QueryWrapper<>();

        return getBaseMapper().selectPage(page,queryWrapper);
    }
}
