package cn.tedu.csmall.cart.service;

import cn.tedu.csmall.commons.pojo.cart.dto.CartAddDTO;

/**
 * @Description:
 * @Author: sweeterjava@163.com
 * @Date: 2023/2/9
 * @Time: 15:24
 */
public interface IcartService {
    // 新增购物车
    void cartAdd(CartAddDTO cartAddDTO);
    // 删除购物车
    void deleteUserCart(String userId, String commodityCode);
}
