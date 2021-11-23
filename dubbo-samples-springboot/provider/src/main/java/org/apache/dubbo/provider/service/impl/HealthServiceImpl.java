package org.apache.dubbo.provider.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.provider.service.HealthService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author guchunhui01
 * 2021/11/22
 **/
@DubboService
public class HealthServiceImpl implements HealthService {

    @Value("${dubbo.protocol.port}")
    int port;

    @Override
    public String healthy(String name) throws Exception {
//        Thread.sleep(200);
        System.out.println(name);
        return "i am ok." + name + " port: " + port;
    }
}
