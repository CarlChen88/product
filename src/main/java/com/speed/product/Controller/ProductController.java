package com.speed.product.Controller;

import com.speed.product.dataObject.ProductCategory;
import com.speed.product.dataObject.ProductInfo;
import com.speed.product.service.CategoryService;
import com.speed.product.service.ProductService;
import com.speed.product.vo.ProductInfoVO;
import com.speed.product.vo.ProductVO;
import com.speed.product.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @since 2018.09.09
 * @author chenxiang
 * @version 1.0.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 1.查询所有在架的商品
     * 2.获取类目type列表
     * 3.查询类目
     * 4.构造数据
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
        //1.查询所有在架的商品
      List<ProductInfo> productInfoList= productService.findUpAll();
        //2.获取类目type列表
      List<Integer> categoryTypeList= productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        // 3.查询类目
      List<ProductCategory> productCategoryList= categoryService.findByCategoryTypeIn(categoryTypeList);
        //4.构造数据
      List<ProductVO> productVOList=new ArrayList<>();
      for(ProductCategory productCategory:productCategoryList){
          ProductVO productVO=new ProductVO();
          productVO.setCategoryName(productCategory.getCategoryName());
          productVO.setCategoryType(productCategory.getCategoryType());
          List<ProductInfoVO> productInfoVOList=new ArrayList<>();
          for(ProductInfo productInfo:productInfoList){
              if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                  ProductInfoVO productInfoVO=new ProductInfoVO();
                  //原类复制属性值到目标类，两个类属性值一致
                  BeanUtils.copyProperties(productInfo,productInfoVO);
                  productInfoVOList.add(productInfoVO);
              }
          }
          productVO.setProductInfoVOList(productInfoVOList);
          productVOList.add(productVO);
      }
      ResultVO resultVO=new ResultVO();
      resultVO.setCode(0);
      resultVO.setMessage("success");
      resultVO.setData(productVOList);
      return resultVO;
    }
}
