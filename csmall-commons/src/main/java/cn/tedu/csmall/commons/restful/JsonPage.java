package cn.tedu.csmall.commons.restful;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: sweeterjava@163.com
 * @Date: 2023/3/2
 * @Time: 14:45
 */

@Data
public class JsonPage<T> implements Serializable {
    // 当前类是Page\PageInfo类的代替品,应该既能保存分页数据,又能保存分页信息
    // 也就是要将分页数据和分页信息声明出属性,至于声明出哪些属性,是我们自己定义的
    // 原则就是满足前端的需要,现在我们只编写最基本的分页信息,今后有需要再添加

    @ApiModelProperty(value = "总页数", name = "totalPages")
    private Integer totalPages;

    @ApiModelProperty(value = "总条数", name = "totalCount")
    private Long totalCount;

    @ApiModelProperty(value = "页码", name = "page")
    private Integer page;

    @ApiModelProperty(value = "每页条数", name = "pageSize")
    private Integer pageSize;

    // JsonPage中能够保存分页数据的集合对象
    @ApiModelProperty(value = "分页数据", name = "list")
    private List<T> list;

    // 下面要编写一个方法,能够实现将PageInfo类型转换成JsonPage对象返回
    // 如果还需要将其他分页类型(例如SpringData的Page类型)转换为JsonPage,再编写另外的方法即可
    public static <T> JsonPage<T> restPage(PageInfo<T> pageInfo){
        // 因为BeanUtils.copyProperties方法只能给同名属性赋值,
        // 又因为JsonPage和PageInfo属性同名属性有限,所以我们使用手动赋值的方式完成转换
        JsonPage<T> jsonPage = new JsonPage<>();
        jsonPage.setTotalCount(pageInfo.getTotal());
        jsonPage.setTotalPages(pageInfo.getPages());
        jsonPage.setPage(pageInfo.getPageNum());
        jsonPage.setPageSize(pageInfo.getPageSize());

        // 上面是分页信息的赋值,别忘了还有分页数据的赋值
        jsonPage.setList(pageInfo.getList());

        // 最终返回转换完成的jsonPage对象
        return jsonPage;
    }

}










