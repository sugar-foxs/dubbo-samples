package org.apache.dubbo.demo.provider.impl;

import org.apache.dubbo.demo.provider.api.HealthHttpApiService;
import org.apache.dubbo.rpc.RpcContext;

/**
 * @author guchunhui01
 * 2021/11/22
 **/
public class HealthHttpApiServiceImpl implements HealthHttpApiService {
    @Override
    public String isHealthy(String name) {
        return "Hello " + name + ",http is healthy, response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}
