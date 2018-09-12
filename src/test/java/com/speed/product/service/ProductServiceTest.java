package com.speed.product.service;

import com.speed.product.dataObject.ProductInfo;
import com.speed.product.repository.ProductInfoRepositoryTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;



public class ProductServiceTest extends ProductInfoRepositoryTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
       List<ProductInfo> productInfoList= productService.findUpAll();
        Assert.assertTrue(productInfoList.size()>0);
    }
}