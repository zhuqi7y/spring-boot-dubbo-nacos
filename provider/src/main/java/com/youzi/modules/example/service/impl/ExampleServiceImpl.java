package com.youzi.modules.example.service.impl;

import com.github.pagehelper.PageInfo;
import com.youzi.common.query.DeleteQuery;
import com.youzi.modules.example.entity.Example;
import com.youzi.modules.example.mapper.ExampleMapper;
import com.youzi.modules.example.query.ExampleQuery;
import com.youzi.modules.example.service.ExampleService;
import com.youzi.modules.example.vo.ExampleVo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年07月22日 15:55
 */
@DubboService
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleMapper exampleMapper;

    /**
     * @Description: 新增一条记录，返回影响行数
     * @author: zhuqi
     * @date: 2020/7/22 15:58
     * @param example:
     * @Return: int
     */
    @Override
    public int add(Example example) {
        return exampleMapper.add(example);
    }

    /**
     * @Description: 新增一条记录，返回主键id
     * @author: zhuqi
     * @date: 2020/7/22 15:59
     * @param example:
     * @Return: int
     */
    @Override
    public Long addAndGetId(Example example) {
        if(exampleMapper.addAndGetId(example) > 0) {
            return example.getId();
        }
        return null;
    }

    /**
     * @Description: 修改一条记录，返回影响行数
     * @author: zhuqi
     * @date: 2020/7/22 16:00
     * @param example:
     * @Return: int
     */
    @Override
    public int update(Example example) {
        return exampleMapper.update(example);
    }

    /**
     * @Description: 删除一条记录，返回影响行数
     * @author: zhuqi
     * @date: 2020/7/22 16:10
     * @param deleteQuery:
     * @Return: int
     */
    @Override
    public int delete(DeleteQuery deleteQuery) {
        return exampleMapper.delete(deleteQuery);
    }

    /**
     * @Description: 根据主键id返回对象
     * @author: zhuqi
     * @date: 2020/7/22 16:01
     * @param id:
     * @Return: com.youzi.modules.example.entity.ExampleVo
     */
    @Override
    public ExampleVo selectById(Long id) {
        return exampleMapper.selectById(id);
    }

    /**
     * @Description: 根据查询条件，查询多条记录并分页
     * @author: zhuqi
     * @date: 2020/7/22 16:01
     * @param exampleQuery:
     * @Return: com.github.pagehelper.PageInfo<com.youzi.modules.example.entity.ExampleVo>
     */
    @Override
    public PageInfo<ExampleVo> selectPage(ExampleQuery exampleQuery) {
        List<ExampleVo> list = exampleMapper.selectPage(exampleQuery);
        return new PageInfo<>(list);
    }
}
