package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryQueryDTO;
import com.sky.entity.Category;
import com.sky.entity.Employee;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import com.sky.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 新增分类
     * @param category
     */
    @Override
    public void addCategory(Category category) {
        category.setStatus(0);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        Long currentId= BaseContext.getCurrentId();
        category.setCreateUser(currentId);
        category.setUpdateUser(currentId);
        categoryMapper.insert(category);
    }

    /**
     * 更新分类状态
     * @param status
     * @param id
     */
    @Override
    public void updateStatus(Integer status, Long id) {
        Category category=new Category();
        category.setUpdateUser(BaseContext.getCurrentId());
        category.setUpdateTime(LocalDateTime.now());
        category.setId(id);
        category.setStatus(status);
        categoryMapper.update(category);
    }

    /**
     * 更新分类
     * @param category
     */
    @Override
    public void updateCategory(Category category) {
        category.setUpdateTime(LocalDateTime.now());
        category.setUpdateUser(BaseContext.getCurrentId());
        categoryMapper.update(category);
    }

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    @Override
    public List<Category> queryCategoryByType(Integer type) {
        return categoryMapper.get(type);
    }

     /**
      * 分类分页查询
      * @param categoryQueryDTO
      * @return
      */
    @Override
    public PageResult pageQuery(CategoryQueryDTO categoryQueryDTO) {
        PageHelper.startPage(categoryQueryDTO.getPage(),categoryQueryDTO.getPageSize());
        //查询列表
        Page<Category> page=categoryMapper.pageQuery(categoryQueryDTO);
        //获得分页信息
        long total=page.getTotal();
        List<Category> categoryList=page.getResult();
        return new PageResult(total,categoryList);
    }

    /**
     * 删除分类
     * @param id
     */
    @Override
    public void deleteCategory(Long id) {
        categoryMapper.deleteCategory(id);
    }
}
