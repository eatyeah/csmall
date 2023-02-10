package cn.tedu.csmall.order.service;

import cn.tedu.csmall.commons.pojo.pojo.order.dto.OrderAddDTO;

/**
 * @Description:
 * @Author: sweeterjava@163.com
 * @Date: 2023/2/9
 * @Time: 16:07
 */
public interface IOrderService {
    void orderAdd(OrderAddDTO orderAddDTO);
}
