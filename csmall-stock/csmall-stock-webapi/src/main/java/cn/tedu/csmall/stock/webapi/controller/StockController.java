package cn.tedu.csmall.stock.webapi.controller;

import cn.tedu.csmall.commons.pojo.stock.dto.StockReduceCountDTO;
import cn.tedu.csmall.commons.restful.JsonResult;
import cn.tedu.csmall.stock.service.IStockService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
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
    // @SentinelResource注解需要标记在控制层方法上,在该方法第一次运行后,会被Sentinel仪表台检测
    // 该方法在运行前,不会出现在仪表台中
    // 括号中"减少库存数"这个描述会出现在仪表台上,代表这个方法
    @SentinelResource("减少库存数")
    public JsonResult reduceStockCount(StockReduceCountDTO stockReduceCountDTO){
        // 调用减少库存的业务逻辑方法
        stockService.reduceCommodityCount(stockReduceCountDTO);
        return JsonResult.ok("减少库存成功");
    }

}
