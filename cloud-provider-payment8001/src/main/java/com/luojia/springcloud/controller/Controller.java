package com.luojia.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luojia.springcloud.entities.CommonResult;
import com.luojia.springcloud.entities.Payment;
import com.luojia.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Controller {

    @Resource
    private PaymentService paymentService;
    
    @PostMapping(value="payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("******插入结果：" + result);
        
        if(result > 0) {
            return new CommonResult(200, "插入数据库成功", result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }
    
    @GetMapping(value="payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("******插入结果：" + paymentById);
        
        if(paymentById != null) {
            return new CommonResult(200, "查询成功", paymentById);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID：" + id, null);
        }
    }
    
}
