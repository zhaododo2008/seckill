package com.seckill.analysis.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seckill.analysis.user.po.SnsUser;
import com.seckill.analysis.user.vo.req.SnsUserQueryReq;

/**
 * @author zhaododo
 **/

public interface ISnsUserService extends IService<SnsUser> {


    /**
     * 按参数查询
     * @param queryReq
     * @return
     */
    SnsUser getOneByQuery(SnsUserQueryReq queryReq);



}
