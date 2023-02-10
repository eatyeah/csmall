package cn.tedu.csmall.stock.webapi.service.Impl;

import cn.tedu.csmall.commons.exception.CoolSharkServiceException;
import cn.tedu.csmall.commons.pojo.pojo.stock.dto.StockReduceCountDTO;
import cn.tedu.csmall.commons.restful.ResponseCode;
import cn.tedu.csmall.stock.service.IStockService;
import cn.tedu.csmall.stock.webapi.mapper.StockMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: sweeterjava@163.com
 * @Date: 2023/2/10
 * @Time: 13:54
 */
@Slf4j
@Service
@DubboService
// @DubboService注解,标记的业务逻辑层实现类,其中的所有方法都会注册到Nacos
// 在其他服务启动"订阅"后,就会"发现"当前类中的所有服务,随时可以调用
public class StockServiceImpl implements IStockService {
    @Autowired
    private StockMapper stockMapper;

    @Override
    public void reduceCommodityCount(StockReduceCountDTO stockReduceCountDTO) {
        // 调用减少库存的持久层方法
        int row = stockMapper.updateStockCount(
                stockReduceCountDTO.getCommodityCode(),
                stockReduceCountDTO.getReduceCount());
        // 判断是否减少成功
        if (row == 0) {
            throw new CoolSharkServiceException(ResponseCode.BAD_REQUEST, "库存不足");
        }
        log.info("减少库存成功");
    }
}
