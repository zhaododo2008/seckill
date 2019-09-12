package com.seckill.analysis.user.facade.impl;

import com.seckill.analysis.core.util.CodeHelperUtil;
import com.seckill.analysis.exception.GlobalException;
import com.seckill.analysis.user.facade.IUserFacade;
import com.seckill.analysis.user.po.SnsUser;
import com.seckill.analysis.user.po.User;
import com.seckill.analysis.user.service.ISnsUserService;
import com.seckill.analysis.user.service.IUserService;
import com.seckill.analysis.user.vo.req.SnsUserQueryReq;
import com.seckill.analysis.user.vo.req.SnsUserSaveReq;
import com.seckill.analysis.user.vo.resp.SnsUserResp;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhaojun on 2019-06-13.
 **/

@Component
public class UserFacadeImpl implements IUserFacade {

    @Autowired
    private ISnsUserService snsUserService;

    @Autowired
    private IUserService userService;

    @Override
    public SnsUserResp addWxUser(SnsUserSaveReq saveReq) {
        SnsUser snsUser = querySnsUser(saveReq);
        if (null == snsUser){
            User user = createUser();
            if (CodeHelperUtil.isPositive(user.getId())){
                snsUser = new SnsUser();
                snsUser.setUserId(user.getId());
                buildSnsUser(saveReq, snsUser);
            }
            else{
                throw new GlobalException("创建用户失败");
            }
        }
        else{
            buildSnsUser(saveReq, snsUser);
        }

        snsUserService.saveOrUpdate(snsUser);
        return buildSnsUserResp(snsUser);
    }

    private SnsUserResp buildSnsUserResp(SnsUser snsUser) {
        SnsUserResp resp = new SnsUserResp();
        resp.setUserId(snsUser.getUserId());
        resp.setToken(snsUser.getToken());
        return resp;
    }

    private void buildSnsUser(SnsUserSaveReq saveReq, SnsUser snsUser) {
        snsUser.setNonce(String.valueOf(System.currentTimeMillis()));
        snsUser.setSessionKey(saveReq.getSessionKey());
        snsUser.setOpenId(saveReq.getOpenId());
        snsUser.setToken(DigestUtils.md5Hex(String.format("%d%s",snsUser.getUserId(),snsUser.getNonce())));
    }

    private User createUser() {
        User user = new User();
        user.setUserName("");
        user.setLocked(0);
        userService.save(user);
        return user;
    }

    private SnsUser querySnsUser(SnsUserSaveReq saveReq) {
        SnsUserQueryReq queryReq = new SnsUserQueryReq();
        queryReq.setOpenId(saveReq.getOpenId());
        return snsUserService.getOneByQuery(queryReq);
    }
}
