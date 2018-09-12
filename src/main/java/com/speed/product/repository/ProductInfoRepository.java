package com.speed.product.repository;

import com.speed.product.dataObject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String > {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
