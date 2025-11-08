package com.sky.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryQueryDTO {
    //页码
    private  Integer page;

    //煤业记录数
    private Integer pageSize;

    //分类名称
    private String name;

    //分类类型
    private Integer type;
}
