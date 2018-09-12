package com.speed.product.repository;

import com.speed.product.ProductApplicationTests;
import com.speed.product.dataObject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;



public class ProductInfoRepositoryTest extends ProductApplicationTests {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfoList=productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(productInfoList.size()>0);
    }
}