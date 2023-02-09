package cn.tedu.csmall.business.service.impl;

import cn.tedu.csmall.business.service.IBusinessService;
import cn.tedu.csmall.commons.pojo.pojo.order.dto.OrderAddDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: sweeterjava@163.com
 * @Date: 2023/2/9
 * @Time: 10:24
 */

@Slf4j
@Service
public class BusinessServiceImpl implements IBusinessService {

    @Override
    public void buy() {
        // 模拟购买业务
        OrderAddDTO orderAddDTO = new OrderAddDTO();
        orderAddDTO.setUserId("UU001");
        orderAddDTO.setCount(1);
        orderAddDTO.setMoney(100);
        orderAddDTO.setCommodityCode("PP001");
        log.info("购买成功,订单信息:{}",orderAddDTO);
    }
}
