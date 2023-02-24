package cn.tedu.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @Description:
 * @Author: sweeterjava@163.com
 * @Date: 2023/2/24
 * @Time: 15:16
 */

@Data
// 支持链式set赋值
@Accessors(chain = true)
// 自动生成包含全部参数的构造方法
@AllArgsConstructor
// 自动生成无参数的构造方法
@NoArgsConstructor
public class Item implements Serializable {
    // SpringDataJPA通过@Id注解标识主键
    @Id
    private Long id;

    // @Field是SpringData标记普通属性的注解
    // type是定义这个属性的类型,FieldType.Text是支持分词的字符串,后面要定义两个分词器
    @Field(type = FieldType.Text,
            analyzer = "ik_max_word",
            searchAnalyzer = "ik_max_word")
    private String title;

    // Keyword是不需分词的字符串类型
    @Field(type = FieldType.Keyword)
    private String category;

    @Field(type = FieldType.Keyword)
    private String brand;

    // Double是支持小数的数字类型
    @Field(type = FieldType.Double)
    private Double price;

    // index = false表示不需要索引,不需要索引的属性不会被搜索
    @Field(type = FieldType.Keyword, index = false)
    private String imgPath;
}
