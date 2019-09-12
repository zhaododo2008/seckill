package com.seckill.analysis.user.vo.req;

import java.io.Serializable;

/**
 * @author zhaododo
 */
public class SnsUserSaveReq implements Serializable{
    private static final long serialVersionUID = 8751282105532159742L;

    /**
     * session_key
     */
    private String sessionKey;

    /**
     * open_id
     */
    private String openId;


    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

}