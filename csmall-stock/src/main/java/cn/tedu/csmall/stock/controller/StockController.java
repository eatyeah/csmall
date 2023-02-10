package cn.tedu.csmall.stock.controller;

import cn.tedu.csmall.commons.pojo.pojo.stock.dto.StockReduceCountDTO;
import cn.tedu.csmall.commons.restful.JsonResult;
import cn.tedu.csmall.stock.service.IStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: sweeterjava@163.com
 * @Date: 2023/2/10
 * @Time: 13:57
 */

@RestController
@RequestMapping("/base/stock")
@Api(tags = "库存管理模块")
public class StockController {
    @Autowired
    private IStockService stockService;

    @PostMapping("/reduce/count")
    @ApiOperation("减少库存数")
    public JsonResult reduceStockCount(StockReduceCountDTO stockReduceCountDTO){
        // 调用减少库存的业务逻辑方法
        stockService.reducecommodityCount(stockReduceCountDTO);
        return JsonResult.ok("减少库存成功");
    }

}
