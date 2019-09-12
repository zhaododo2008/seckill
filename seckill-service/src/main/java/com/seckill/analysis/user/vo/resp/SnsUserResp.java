package com.seckill.analysis.user.vo.resp;

/**
 * @author zhaododo
 **/

public class SnsUserResp {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * token
     */
    private String token;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
