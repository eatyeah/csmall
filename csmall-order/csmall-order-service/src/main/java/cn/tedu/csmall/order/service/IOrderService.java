package cn.tedu.csmall.order.service;


import cn.tedu.csmall.commons.pojo.order.dto.OrderAddDTO;
import cn.tedu.csmall.commons.pojo.order.model.Order;
import cn.tedu.csmall.commons.restful.JsonPage;

public interface IOrderService {

    // 声明新增订单的业务逻辑层方法
    void orderAdd(OrderAddDTO orderAddDTO);

    // 返回JsonPage类型的分页查询订单的方法
    JsonPage<Order> getAllOrdersByPage(Integer page, Integer pageSize);

}
