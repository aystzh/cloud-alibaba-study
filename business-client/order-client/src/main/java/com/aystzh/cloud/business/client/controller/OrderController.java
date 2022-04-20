package com.aystzh.cloud.business.client.controller;

import com.aystzh.cloud.business.client.service.StockOpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by zhanghuan on 2022/4/18.
 */
@RefreshScope //配置此类接口动态刷新
@RestController
@RequestMapping("/order")
public class OrderController {

    private  String userName;
    private String total_number;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private StockOpenFeignService stockOpenFeignService;

    @Value("${order.price}")
    public String orderPrice;

    /**
     * 新增订单
     *
     * @return
     */
    @GetMapping("/addOrder")
    public String addOrder() {

        System.out.println("订单新增成功");
        System.out.println("orderPrice:" + orderPrice);
        //调用库存扣减
        //String apiReqResult = restTemplate.getForObject("http://service-stock/stock/subStock", String.class);
        String subStock = stockOpenFeignService.subStock();
        return "订单服务-订单新增成功:" + subStock+"\n 动态数据刷新："+orderPrice;
    }
}
