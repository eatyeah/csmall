package cn.tedu.search;

import cn.tedu.search.entity.Item;
import cn.tedu.search.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SearchApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    // 执行单增
    @Test
    void contextLoads() {
        // 实力化一个Item对象
        // Item item = new Item()
        //         .setId(1L)
        //         .setTitle("华为Mate40")
        //         .setCategory("手机")
        //         .setBrand("华为")
        //         .setPrice(4999.00)
        //         .setImgUrl("http://image.leyou.com/13123.jpg");
        // 实例化Item对象
        Item item = new Item()
                .setId(1L)
                .setTitle("罗技激光无线游戏鼠标")
                .setCategory("鼠标")
                .setBrand("罗技")
                .setPrice(188.0)
                .setImgPath("/1.jpg");
        // 利用SpringDataElasticsearch提供的方法,完成这个实体类新增到Es
        itemRepository.save(item);
        System.out.println("ok");
    }

}
