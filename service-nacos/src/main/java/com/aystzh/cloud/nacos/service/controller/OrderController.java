package com.aystzh.cloud.nacos.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhanghuan on 2022/4/18.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 下单
     * @return
     */
    @RequestMapping("/add")
    public String addOrder(){
        System.out.println("下单成功");

        return "订单服务";
    }
}
