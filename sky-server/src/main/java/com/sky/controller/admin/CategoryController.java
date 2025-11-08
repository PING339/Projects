package com.sky.controller.admin;

import com.sky.dto.CategoryQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     * @param category
     * @return
     */
    @PostMapping
    @ApiOperation("新增分类")
    public Result addCategory(@RequestBody Category category){
        log.info("新增分类:{}",category);
        categoryService.addCategory(category);
        return Result.success();
    }

    /**
     * 更新分类状态
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("更新分类状态")
    public Result updateStatus(@PathVariable Integer status,@RequestParam Long id){
        log.info("更新分类状态:{}",status);
        categoryService.updateStatus(status,id);
        return Result.success();
    }

    @PutMapping
    @ApiOperation("修改分类")
    public Result updateCategory(@RequestBody Category category){
        log.info("修改分类:{}",category);
        categoryService.updateCategory(category);
        return Result.success();
    }

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> queryCategoryByType(@RequestParam Integer type){
        List<Category> list=categoryService.queryCategoryByType(type);
        return Result.success(list);
    }

    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> page
            (CategoryQueryDTO categoryQueryDTO){
        PageResult list=categoryService.pageQuery(categoryQueryDTO);
        return Result.success(list);
    }

    @DeleteMapping
    @ApiOperation("删除分类")
    public Result deleteCategory(@RequestParam Long id){
        log.info("删除分类进行中,id:{}",id);
        categoryService.deleteCategory(id);
        return Result.success();
    }

}
