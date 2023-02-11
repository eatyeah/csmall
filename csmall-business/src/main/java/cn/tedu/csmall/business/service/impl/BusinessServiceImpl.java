package cn.tedu.csmall.business.service.impl;

import cn.tedu.csmall.business.service.IBusinessService;
import cn.tedu.csmall.commons.pojo.order.dto.OrderAddDTO;
import cn.tedu.csmall.order.service.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: sweeterjava@163.com
 * @Date: 2023/2/9
 * @Time: 10:24
 */

@Service
@Slf4j
public class BusinessServiceImpl implements IBusinessService {

    // Dubbo调用order模块的新增订单的功能
    // business是单纯的消费者,不需要再类上编写@DubboService
    @DubboReference
    private IOrderService dubboOrderService;

    // Global:全局  Transactional:事务
    // 一旦这个方法标记为 @GlobalTransactional
    // 就相当于设置了分布式事务运行的起点,相当于AT事务模型中的TM(事务管理器)
    // 最终效果就是当前方法开始后,所有远程调用操作数据库的功能,都在同一个事务中
    // 也就是这些远程调用的数据库操作要么都执行,要么都不执行
    @GlobalTransactional
    @Override
    public void buy() {
        // 模拟购买业务
        // 先实例化一个用于新增订单的DTO对象
        OrderAddDTO orderAddDTO=new OrderAddDTO();
        orderAddDTO.setUserId("UU100");
        orderAddDTO.setCommodityCode("PC100");
        orderAddDTO.setCount(5);
        orderAddDTO.setMoney(100);
        // 因为是模拟购买,所以暂时只做输出信息效果即可
        log.info("新增订单信息为:{}",orderAddDTO);

        // dubbo调用,将上面实例化的对象生成订单,真实影响数据库
        dubboOrderService.orderAdd(orderAddDTO);

    }
}
