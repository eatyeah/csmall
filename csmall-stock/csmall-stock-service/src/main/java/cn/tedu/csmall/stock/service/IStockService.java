package cn.tedu.csmall.stock.service;

import cn.tedu.csmall.commons.pojo.stock.dto.StockReduceCountDTO;

/**
 * @Description: 减少库存的业务逻辑方法
 * @Author: sweeterjava@163.com
 * @Date: 2023/2/10
 * @Time: 13:52
 */
public interface IStockService {
    void reduceCommodityCount(StockReduceCountDTO stockReduceCountDTO);
}
