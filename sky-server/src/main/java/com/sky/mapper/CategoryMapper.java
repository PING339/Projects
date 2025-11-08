package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface CategoryMapper {

    /**
     * 新增分类
     * @param category
     */
    @Insert("insert into category(type, name, sort, status, create_time, update_time, create_user, update_user)" +
            "values(#{type}, #{name}, #{sort}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    public void insert(Category category);

    /**
     * 更新分类状态
     * @param category
     */
    void update(Category category);

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    @Select("select * from category where type=#{type} order by sort")
    List<Category> get(Integer type);

    /**
     * 分类分页查询
     * @param categoryQueryDTO
     * @return
     */
    Page<Category> pageQuery(CategoryQueryDTO categoryQueryDTO);

     /**
      * 删除分类
      * @param id
      */
     @Delete("delete from category where id = #{id}")
    void deleteCategory(Long id);
}
