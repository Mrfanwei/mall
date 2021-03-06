package com.macro.mall.portal.service;

import com.macro.mall.model.*;
import com.macro.mall.portal.domain.HomeContentResult;

import java.util.List;

/**
 * 首页内容管理Service
 * Created by macro on 2019/1/28.
 */
public interface HomeService {

    /**
     * 获取首页内容
     */
    HomeContentResult content();

    /**
     * 首页商品推荐
     */
    List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum);

    /**
     * 获取品牌信息
     * */
    public List<PmsBrand> getBrand();

    /**
     * 获取商品信息
     * */
    public List<PmsProduct> getProduct(Long brandId);

    /**
     * 获取全部商品信息
     * */
    public List<PmsProduct> getAllProduct();

    /**
     * 获取商品详细信息
     * */
    public PmsProduct getProductDetail(Long productId);

    /**
     * 获取商品详细信息
     * */
    public PmsSkuStock getSkuStock(Long productId);

    /**
     * 获取商品分类
     * @param parentId 0:获取一级分类；其他：获取指定二级分类
     */
    List<PmsProductCategory> getProductCateList(Long parentId);

    /**
     * 根据专题分类分页获取专题
     * @param cateId 专题分类id
     */
    List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum);
}
