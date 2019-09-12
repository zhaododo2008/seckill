package com.seckill.analysis.auction.service;

import com.seckill.analysis.auction.dto.OrderDto;
import com.seckill.analysis.auction.vo.req.OrderReq;
import com.seckill.analysis.auction.vo.req.TopicReq;

import java.util.List;

/**
 * @author zhaododo
 */
public interface IAuctionService {


    /**
     * 创建主题
     * @param topicReq
     */
    void createTopic(TopicReq topicReq);


    /**
     * 下单
     * @param orderReq
     */
    void order(OrderReq orderReq);


    /**
     * 查询最新下单
     * @return
     */
    OrderDto queryLatestOrder();


    /**
     * 查询已下单列表
     * @param addUserId
     * @return
     */
    List<OrderDto> queryMyOrders(Integer addUserId);


}
