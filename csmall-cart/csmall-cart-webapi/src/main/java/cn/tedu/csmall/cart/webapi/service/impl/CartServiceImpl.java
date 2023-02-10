package cn.tedu.csmall.cart.webapi.service.impl;

import cn.tedu.csmall.cart.service.ICartService;
import cn.tedu.csmall.cart.webapi.mapper.CartMapper;
import cn.tedu.csmall.commons.pojo.cart.dto.CartAddDTO;
import cn.tedu.csmall.commons.pojo.cart.model.Cart;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: sweeterjava@163.com
 * @Date: 2023/2/9
 * @Time: 15:26
 */

@Slf4j
@Service
@DubboService
public class CartServiceImpl implements ICartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public void cartAdd(CartAddDTO cartAddDTO) {
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartAddDTO, cart);
        int row = cartMapper.insertCart(cart);
        log.info("新增购物车商品完成：{}",cart);
    }

    @Override
    public void deleteUserCart(String userId, String commodityCode) {
        cartMapper.deleteCartByUserIdAndCommodityCode(userId, commodityCode);
        log.info("购物车商品删除成功");
    }
}
