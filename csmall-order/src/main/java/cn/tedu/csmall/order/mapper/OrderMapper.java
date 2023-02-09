package cn.tedu.csmall.order.mapper;

import cn.tedu.csmall.commons.pojo.pojo.order.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: sweeterjava@163.com
 * @Date: 2023/2/9
 * @Time: 16:03
 */

@Repository
public interface OrderMapper {
    @Insert("insert into order_tbl(user_id, commodity_code, count, money)" +
            "values (#{userId}, #{commodityCode}, #{count}, #{money})")
    int insertOrder(Order order);

}
