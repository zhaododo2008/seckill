package com.seckill.analysis.auction.vo.req;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhaojun
 */
public class TopicReq implements Serializable {

    /**
     *  主题Id
     */
    private Long topicId;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 结束时间
     */
    private Date endingTime;

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Date endingTime) {
        this.endingTime = endingTime;
    }
}
