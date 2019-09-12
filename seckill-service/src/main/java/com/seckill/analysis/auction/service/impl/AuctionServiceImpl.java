package com.seckill.analysis.auction.service.impl;

import com.google.common.collect.Lists;
import com.seckill.analysis.auction.dto.OrderDto;
import com.seckill.analysis.auction.service.IAuctionService;
import com.seckill.analysis.auction.vo.req.OrderReq;
import com.seckill.analysis.auction.vo.req.TopicReq;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhaododo
 *
 */

@Component
public class AuctionServiceImpl implements IAuctionService {
    @Override
    public void createTopic(TopicReq topicReq) {

    }

    @Override
    public void order(OrderReq orderReq) {

    }

    @Override
    public OrderDto queryLatestOrder() {
        return null;
    }

    @Override
    public List<OrderDto> queryMyOrders(Integer addUserId) {
        return Lists.newArrayList();
    }
}
