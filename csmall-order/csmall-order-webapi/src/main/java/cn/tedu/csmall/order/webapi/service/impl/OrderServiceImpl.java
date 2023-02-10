package cn.tedu.csmall.order.webapi.service.impl;

import cn.tedu.csmall.cart.service.ICartService;
import cn.tedu.csmall.commons.pojo.pojo.order.dto.OrderAddDTO;
import cn.tedu.csmall.commons.pojo.pojo.order.model.Order;
import cn.tedu.csmall.order.service.IOrderService;
import cn.tedu.csmall.order.webapi.mapper.OrderMapper;
import cn.tedu.csmall.stock.service.IStockService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
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
@DubboService
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    /**
     *添加@DubboReference注解,表示当前业务逻辑层中要消费其他模块的服务了
     * 注解后面声明的应该是Dubbo注册到Nacos其他模块声明的业务逻辑层接口
     * 业务逻辑层接口实现类会在Dubbo框架下自动获取
     */
    @DubboReference
    private IStockService stockService;
    @DubboReference
    private ICartService cartService;

    @Override
    public void orderAdd(OrderAddDTO orderAddDTO) {
        Order order = new Order();
        BeanUtils.copyProperties(orderAddDTO, order);
        orderMapper.insertOrder(order);
        log.info("新增订单信息为：{}",order);

    }
}
