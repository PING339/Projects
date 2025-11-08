package com.sky.service;

import com.sky.dto.CategoryQueryDTO;
import com.sky.entity.Category;
import com.sky.entity.SetmealDish;
import com.sky.result.PageResult;

import java.util.List;

public interface CategoryService {

    /**
     * 新增分类
     * @param category
     */
    public void addCategory(Category category);

    /**
     * 更新分类状态
     * @param status
     * @param id
     */
    void updateStatus(Integer status, Long id);

    /**
     * 更新分类
     * @param category
     */
    void updateCategory(Category category);

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    List<Category> queryCategoryByType(Integer type);

    /**
     * 分页查询分类
     * @param categoryQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryQueryDTO categoryQueryDTO);

     /**
      * 删除分类
      * @param id
      */
    void deleteCategory(Long id);
}
