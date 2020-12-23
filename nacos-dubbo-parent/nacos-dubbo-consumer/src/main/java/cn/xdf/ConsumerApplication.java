package cn.xdf;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @package: cn.xdf
 * @description: TODO 服务发现方
 * @author: zhangshuai21
 * @date: 2020年12月22日 18:21
 * @version: v1.0
 */
@SpringBootApplication
@EnableDubbo(scanBasePackages = "cn.xdf.service")
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
        System.err.println("Consumer 启动成功！");
    }

}
