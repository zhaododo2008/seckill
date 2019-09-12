package com.seckill.analysis.user.facade;

import com.seckill.analysis.user.vo.req.SnsUserSaveReq;
import com.seckill.analysis.user.vo.resp.SnsUserResp;

/**
 * @author zhaododo
 **/

public interface IUserFacade {

    /**
     * 保存微信账户，生成uid
     * @param saveReq
     * @return
     */
    SnsUserResp addWxUser(SnsUserSaveReq saveReq);

}
