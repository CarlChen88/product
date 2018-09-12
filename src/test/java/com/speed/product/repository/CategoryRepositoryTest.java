package com.speed.product.repository;

import com.speed.product.dataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CategoryRepositoryTest extends ProductInfoRepositoryTest{

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findByCategoryTypeIn() {

        List<ProductCategory> productCategoryList=categoryRepository.findByCategoryTypeIn(Arrays.asList(1,2));
        Assert.assertTrue(productCategoryList.size()>0);
    }
}