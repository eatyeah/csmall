package cn.tedu.search.repository;

import cn.tedu.search.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: sweeterjava@163.com
 * @Date: 2023/2/24
 * @Time: 15:41
 */

// Repository是Spring家族对持久层包名\类名\接口名的规范
@Repository
public interface ItemRepository extends ElasticsearchRepository<Item,Long> {
    // ItemRepository接口要继承SpringData框架提供的父接口ElasticsearchRepository
    // 一旦继承,当前接口就可以编写使用父接口中提供的连接ES的方法了
    // 继承父接口后,SpringData会根据我们在泛型中指定的Item实体类,找到对应的索引
    // 并生成操作这个索引的基本增删改查方法,我们自己无需编写
    // ElasticsearchRepository<[要操作的实体类名称],[实体类主键的类型]>
}
