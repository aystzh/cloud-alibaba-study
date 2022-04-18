package com.aystzh.cloud.business.service.controller;

/**
 * Created by zhanghuan on 2022/4/18.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存服务
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Value("${server.port}")
    private String port;

    /**
     * 库存新增
     * @return
     */
    @RequestMapping("/addStock")
    public String addStock(){
        System.out.println("库存新增成功");

        return "库存服务-库存新增成功";
    }

    /**
     * 库存扣减
     * @return
     */
    @RequestMapping("/subStock")
    public String subStock(){
        System.out.println("库存扣减成功");

        return "库存服务-库存扣减成功 - 端口：" + port;
    }
}