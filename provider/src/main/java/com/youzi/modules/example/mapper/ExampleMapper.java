package com.youzi.modules.example.mapper;

import com.youzi.common.query.DeleteQuery;
import com.youzi.modules.example.entity.Example;
import com.youzi.modules.example.query.ExampleQuery;
import com.youzi.modules.example.vo.ExampleVo;

import java.util.List;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月22日 15:54
 */
public interface ExampleMapper {
    /**
     * @Description: 新增一条记录，返回影响行数
     * @author: zhuqi
     * @date: 2020/7/22 15:58
     * @param example:
     * @Return: int
     */
    int add(Example example);

    /**
     * @Description: 新增一条记录，返回主键id
     * @author: zhuqi
     * @date: 2020/7/22 15:59
     * @param example:
     * @Return: int
     */
    int addAndGetId(Example example);

    /**
     * @Description: 修改一条记录，返回影响行数
     * @author: zhuqi
     * @date: 2020/7/22 16:00
     * @param example:
     * @Return: int
     */
    int update(Example example);

    /**
     * @Description: 删除一条记录，返回影响行数
     * @author: zhuqi
     * @date: 2020/7/22 16:00
     * @param deleteQuery:
     * @Return: int
     */
    int delete(DeleteQuery deleteQuery);

    /**
     * @Description: 根据主键id返回对象
     * @author: zhuqi
     * @date: 2020/7/22 16:01
     * @param id:
     * @Return: com.youzi.modules.example.entity.ExampleVo
     */
    ExampleVo selectById(Integer id);

    /**
     * @Description: 根据查询条件，查询多条记录并分页
     * @author: zhuqi
     * @date: 2020/7/22 16:01
     * @param exampleQuery:
     * @Return: com.github.pagehelper.PageInfo<com.youzi.modules.example.entity.ExampleVo>
     */
    List<ExampleVo> selectPage(ExampleQuery exampleQuery);

    /**
    * @Description: 判断id是否存在
    * @author: zhuqi
    * @date: 2020/8/18 17:30
    * @param id:
    * @Return: java.lang.Boolean
    */
    Boolean existById(Integer id);
}
