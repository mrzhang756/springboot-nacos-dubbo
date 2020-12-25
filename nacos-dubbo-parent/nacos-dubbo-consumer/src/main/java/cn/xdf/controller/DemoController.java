package cn.xdf.controller;

import cn.xdf.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @package: cn.xdf.controller
 * @description: TODO 服务发现方 测试 调用服务提供方
 * @author: zhangshuai21
 * @date: 2020年12月22日 18:47
 * @version: v1.0
 */
@RestController
public class DemoController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference//(check = false, group = "provider", version = "${demo.service.version}")
    private DemoService demoService;

    /**
     * @Description: TODO http://localhost:9082//service1
     * @Author: zhangshuai21
     * @Date: 2020/12/22 19:00
     */
    @GetMapping(value = "/service1")
    private String service1() {
        logger.info("consumer--调用-->provider");
        String hello = demoService.sayHello("mercyblitz");
        logger.info("sayHello():", hello);
        return demoService.service1();
    }

    @Bean
    public ApplicationRunner runner() {

        return args -> logger.info(demoService.sayHello("mercyblitz"));
    }

}
