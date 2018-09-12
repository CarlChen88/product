package com.speed.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.speed.product.dataObject.ProductInfo;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
