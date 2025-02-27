/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.demo.DemoService;
import org.apache.dubbo.demo.HelloReply;
import org.apache.dubbo.demo.HelloRequest;

import org.apache.dubbo.demo.HealthService;
import org.apache.dubbo.demo.HealthReply;
import org.apache.dubbo.demo.HealthRequest;

import org.apache.dubbo.demo.provider.api.HealthHttpApiService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerApplication {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
        context.start();
//        DemoService demoService = context.getBean("demoService", DemoService.class);
//        HelloRequest request = HelloRequest.newBuilder().setName("Hello").build();
//        HelloReply reply = demoService.sayHello(request);

        HealthService healthService = context.getBean("healthService", HealthService.class);
        HealthRequest request = HealthRequest.newBuilder().setName("Health").build();
        HealthReply reply = healthService.healthy(request);
        System.out.println("result: " + reply.getMessage());

        HealthHttpApiService healthHttpApiService = (HealthHttpApiService) context.getBean("healthHttpApiService");
        String result = healthHttpApiService.isHealthy("world");
        System.out.println(result);

        System.in.read();
    }
}
