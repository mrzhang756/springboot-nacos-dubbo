package cn.xdf;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @package: cn.xdf
 * @description: TODO
 * @author: zhangshuai21
 * @date: 2020年12月22日 18:21
 * @version: v1.0
 */
@SpringBootApplication
@NacosPropertySource(dataId = "nacos-dubbo-provider-dev.yml", autoRefreshed = true)
@EnableDubbo(scanBasePackages = "cn.xdf.service")
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
        System.err.println("Provider 启动成功！");
    }

}
