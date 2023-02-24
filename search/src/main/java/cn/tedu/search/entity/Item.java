package cn.tedu.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

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
public class Item implements Serializable {
    private Long id;
    private String title;
    private String category;
    private String brand;
    private Double price;
    private String imgUrl;
}
