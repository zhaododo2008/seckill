package com.seckill.analysis.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.analysis.user.mapper.IUserMapper;
import com.seckill.analysis.user.po.User;
import com.seckill.analysis.user.service.IUserService;
import org.springframework.stereotype.Component;

/**
 * @author zhaododo
 **/

@Component
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {
}
