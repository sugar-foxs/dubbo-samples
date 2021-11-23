package org.apache.dubbo.demo.provider;

import org.apache.dubbo.demo.HealthService;
import org.apache.dubbo.demo.HealthReply;
import org.apache.dubbo.demo.HealthRequest;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * @author guchunhui01
 * 2021/11/22
 **/
public class HealthServiceImpl implements HealthService {

    private static final Logger logger = LoggerFactory.getLogger(HealthServiceImpl.class);

    @Override
    public HealthReply healthy(HealthRequest request) {
        logger.info("Hello " + request.getName() + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return HealthReply.newBuilder()
                .setMessage("Hello " + request.getName() + ", i am healthy, response from provider: "
                        + RpcContext.getContext().getLocalAddress())
                .build();
    }

    @Override
    public CompletableFuture<HealthReply> healthyAsync(HealthRequest request) {
        return CompletableFuture.completedFuture(healthy(request));
    }
}
