package cn.tedu.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Data
@Accessors(chain = true)    // 支持链式set赋值
@AllArgsConstructor         // 自动生成包含全部参数的构造方法
@NoArgsConstructor          // 自动生成无参数的构造方法

// @Document注解标记当前类是ES框架对应的实体类
// 属性indexName指定ES中对应的索引名称,运行时,如果这个索引不存在,SpringData会自动创建它
@Document(indexName = "items")
public class Item implements Serializable {

    // SpringData通过@Id标记当前实体类的主键属性
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
    @Field(type = FieldType.Double)
    private Double price;
    // imgPath是图片路径,路径不会成为搜索条件,所以这个列可以不创建索引,节省空间
    // index = false,就是不创建索引的设置
    // 但是需要注意,不创建索引并不是不保存这个数据,ES中仍然保存imgPath的值
    @Field(type = FieldType.Keyword,index = false)
    private String imgPath;

    // images/2022/11/28/18239adc-8ae913-abbf91.jpg


//    public Item setId(Long id){
//        this.id=id;
//        return this;
//    }



}
