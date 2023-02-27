package cn.tedu.search;

import cn.tedu.search.entity.Item;
import cn.tedu.search.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SearchApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    // 执行单增
    @Test
    void addOne() {
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

    @Test
    void getOne() {
        // 根据id查询
        // findById方法返回值是Optional对象,声明了泛型,泛型就是查询的实体类，理解为只能保存一个该泛型对象的集合
        Optional<Item> optional = itemRepository.findById(1L);
        Item item = optional.get();
        System.out.println(item);
    }

    @Test
    void addList() {
        // 批量新增
        // 实例化一个List,把要保存到Es中的数据都添加到这个集合中
        List<Item> list = new ArrayList<>();
        list.add(new Item(2L, "罗技激光有线办公鼠标", "鼠标",
                "罗技", 9.9, "/2.jpg"));
        list.add(new Item(3L, "雷蛇机械无线游戏键盘", "键盘",
                "雷蛇", 268.0, "/3.jpg"));
        list.add(new Item(4L, "微软有线静音办公鼠标", "鼠标",
                "微软", 199.0, "/4.jpg"));
        list.add(new Item(5L, "罗技机械有线背光键盘", "键盘",
                "罗技", 228.0, "/5.jpg"));
        itemRepository.saveAll(list);
        System.out.println("ok");
    }

}
