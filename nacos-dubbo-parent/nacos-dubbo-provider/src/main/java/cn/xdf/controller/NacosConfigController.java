package cn.xdf.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @package: cn.xdf.controller
 * @description: TODO
 * @author: zhangshuai21
 * @date: 2020年12月23日 9:26
 * @version: v1.0
 */
@Controller
@RequestMapping("config")
public class NacosConfigController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    //默认本地yml配置中的值，然后动态刷新nacos配置中的值，以上都没设置的话默认这里的值
    @NacosValue(value = "${threadpool.thread-name-prefix:test01-}", autoRefreshed = true)
    private String threadNamePrefix;


    //@Value(value = "${config.apps:001}") 也可以取到nacos配置，但不能自动刷新
    @NacosValue(value = "${config.apps:001}", autoRefreshed = true)
    private String apps;

    // 如果配置文件中没初始化值，这里要初始化(:456),否则报错
    @NacosValue(value = "${pageWidth:456}", autoRefreshed = true)
    String pageWidth;


    //http://127.0.0.1:9081/config/get
    @GetMapping(value = "/get")
    @ResponseBody
    public boolean get() {
        System.out.println("useLocalCache = " + useLocalCache);
        System.out.println("threadNamePrefix = " + threadNamePrefix);
        System.err.println("apps=" + apps);
        System.err.println("pageWidth=" + pageWidth);
        return useLocalCache;
    }
}