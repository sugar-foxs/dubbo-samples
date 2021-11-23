package org.apache.dubbo.consumer.controller;

import org.apache.dubbo.common.constants.ClusterRules;
import org.apache.dubbo.common.constants.LoadbalanceRules;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.provider.service.HealthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guchunhui01
 * 2021/11/22
 **/
@RestController
public class HealthController {
    @DubboReference(interfaceClass = HealthService.class
//            , timeout = 100
//            , loadbalance = LoadbalanceRules.SHORTEST_RESPONSE
            , cluster = ClusterRules.FAIL_OVER
//            , retries = 1
    )
    private HealthService healthService;

    @RequestMapping("/health")
    public String healthy(@RequestParam(value = "name", required = false, defaultValue = "default") String name) {
        long start = System.currentTimeMillis();
        String res = healthService.healthy(name);
        System.out.println(res + " cost: " + (System.currentTimeMillis() - start));
        return res;
    }
}
