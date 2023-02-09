package cn.tedu.csmall.order.service.impl;

import cn.tedu.csmall.commons.pojo.pojo.order.dto.OrderAddDTO;
import cn.tedu.csmall.commons.pojo.pojo.order.model.Order;
import cn.tedu.csmall.order.mapper.OrderMapper;
import cn.tedu.csmall.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: sweeterjava@163.com
 * @Date: 2023/2/9
 * @Time: 16:07
 */

@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void orderAdd(OrderAddDTO orderAddDTO) {
        Order order = new Order();
        BeanUtils.copyProperties(orderAddDTO, order);
        orderMapper.insertOrder(order);
        log.info("新增订单信息为：{}",order);

    }
}
