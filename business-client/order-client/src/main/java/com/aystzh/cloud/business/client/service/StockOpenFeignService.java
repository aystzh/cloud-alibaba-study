package com.aystzh.cloud.business.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 库存服务接口
 * name:指定调用rest接口所对应的服务名
 * path:指定调用rest接口所在的StockController指定的@RequestMapping
 */
@FeignClient(name = "service-stock",path = "stock")
public interface StockOpenFeignService {

    //声明需要调用的rest接口对应的方法
    /**
     * 库存扣减
     * @return
     */
    @RequestMapping("/subStock")
    String subStock();

    /**
     * 库存新增
     * @return
     */
    @RequestMapping("/addStock")
    String addStock();
}
