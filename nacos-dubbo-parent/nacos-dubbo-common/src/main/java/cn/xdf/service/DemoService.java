package cn.xdf.service;

/**
 * @package: cn.xdf.service
 * @description: TODO
 * 我们把接口放置于common工程，这样consumer工程也就可以通过nacos的注册中心找到这个接口名，
 * 然后通过spring的invoke来对于远程的用于具体实现service逻辑的xxxServiceImpl类进行调用了。
 * @author: zhangshuai21
 * @date: 2020年12月22日 18:35
 * @version: v1.0
 */
public interface DemoService {
    String sayHello(String name);

    String service1();
}
