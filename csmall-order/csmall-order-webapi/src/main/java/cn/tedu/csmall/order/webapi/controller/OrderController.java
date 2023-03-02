package cn.tedu.csmall.order.webapi.controller;

import cn.tedu.csmall.commons.pojo.order.model.Order;
import cn.tedu.csmall.commons.restful.JsonResult;
import cn.tedu.csmall.order.service.IOrderService;
import cn.tedu.csmall.order.webapi.service.impl.OrderServiceImpl;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.tedu.csmall.commons.pojo.order.dto.OrderAddDTO;

@RestController
@RequestMapping("/base/order")
@Api(tags = "订单管理模块")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/add")
    @ApiOperation("新增订单功能")
    public JsonResult orderAdd(OrderAddDTO orderAddDTO){
        orderService.orderAdd(orderAddDTO);
        return JsonResult.ok("新增订单完成!");
    }

    @GetMapping
    @ApiOperation("分页查询所有订单")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码",name="page",example ="1" ),
            @ApiImplicitParam(value = "每页条数",name="pageSize",example ="10" )
    })
    public JsonResult<PageInfo<Order>> pageOrder(Integer page,Integer pageSize){
        PageInfo<Order> pageInfo=
                orderService.getAllOrdersByPage(page, pageSize);
        return JsonResult.ok("查询完成",pageInfo);
    }

}
