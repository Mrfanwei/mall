package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.*;
import com.macro.mall.portal.domain.HomeContentResult;
import com.macro.mall.portal.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 首页内容管理Controller
 * Created by macro on 2019/1/28.
 */
@Controller
@Api(tags = "HomeController", description = "首页内容管理")
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @ApiOperation("首页内容页信息展示")
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<HomeContentResult> content() {
        HomeContentResult contentResult = homeService.content();
        return CommonResult.success(contentResult);
    }

    @ApiOperation("获取分类信息")
    @RequestMapping(value = "/brand", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrand() {
        return CommonResult.success( homeService.getBrand());
    }

    @ApiOperation("获取品牌类商品信息")
    @RequestMapping(value = "/product/{brandId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProduct>> getProduct(@PathVariable Long brandId) {
        return CommonResult.success( homeService.getProduct(brandId));
    }

    @ApiOperation("获取All商品信息")
    @RequestMapping(value = "/product/all", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProduct>> getAllProduct() {
        return CommonResult.success( homeService.getAllProduct());
    }

    @ApiOperation("获取单个商品详细信息")
    @RequestMapping(value = "/product/detail/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsProduct> getProductDetail(@PathVariable Long productId) {
        return CommonResult.success( homeService.getProductDetail(productId));
    }

    @ApiOperation("获取商品库存信息")
    @RequestMapping(value = "/product/sku/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsSkuStock> getSkuStock(@PathVariable Long productId) {
        return CommonResult.success( homeService.getSkuStock(productId));
    }

    @ApiOperation("分页获取推荐商品")
    @RequestMapping(value = "/recommendProductList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProduct>> recommendProductList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProduct> productList = homeService.recommendProductList(pageSize, pageNum);
        return CommonResult.success(productList);
    }

    @ApiOperation("获取首页商品分类")
    @RequestMapping(value = "/productCateList/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProductCategory>> getProductCateList(@PathVariable Long parentId) {
        List<PmsProductCategory> productCategoryList = homeService.getProductCateList(parentId);
        return CommonResult.success(productCategoryList);
    }

    @ApiOperation("根据分类获取专题")
    @RequestMapping(value = "/subjectList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> getSubjectList(@RequestParam(required = false) Long cateId,
                                                         @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<CmsSubject> subjectList = homeService.getSubjectList(cateId,pageSize,pageNum);
        return CommonResult.success(subjectList);
    }
}
