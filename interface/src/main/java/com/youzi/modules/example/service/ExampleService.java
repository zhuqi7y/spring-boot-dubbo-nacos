package com.youzi.modules.example.service;

import com.github.pagehelper.PageInfo;
import com.youzi.common.query.DeleteQuery;
import com.youzi.modules.example.entity.Example;
import com.youzi.modules.example.query.ExampleQuery;
import com.youzi.modules.example.vo.ExampleVo;

/**
 * @Description: 实例对象服务
 * @author: zhuqi
 * @date: 2020年07月22日 10:48
 */
public interface ExampleService {

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
    Integer addAndGetId(Example example);

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
    * @date: 2020/7/22 16:10
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
    PageInfo<ExampleVo> selectPage(ExampleQuery exampleQuery);

    /**
     * @Description: 判断id记录是否存在
     * @author: zhuqi
     * @date: 2020/8/26 14:52
     * @param id:
     * @Return: boolean
     */
    boolean existById(Integer id);

}
