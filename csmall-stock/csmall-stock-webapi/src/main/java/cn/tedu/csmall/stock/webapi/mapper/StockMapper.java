package cn.tedu.csmall.stock.webapi.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: sweeterjava@163.com
 * @Date: 2023/2/10
 * @Time: 13:47
 */

@Repository
public interface StockMapper {
    @Update("update stock_tbl set count=count-#{reduceCount} " +
            " where commodity_code=#{commodityCode} and count>=#{reduceCount}")
    int updateStockCount(@Param("commodityCode") String commodityCode,
                         @Param("reduceCount") Integer reduceCount);
}
