package cn.xdf.service.impl;

import cn.xdf.service.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @package: cn.xdf.yn.report.service.impl
 * @description: TODO
 * @author: zhangshuai21
 * @date: 2020年12月21日 16:35
 * @version: v1.0
 */

@Service
public class DemoServiceImpl implements DemoService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }

    @Override
    public String service1() {
        return "调用了provider的service1";
    }
}
