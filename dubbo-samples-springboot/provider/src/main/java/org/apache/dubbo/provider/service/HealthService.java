package org.apache.dubbo.provider.service;

/**
 * @author guchunhui01
 * 2021/11/22
 **/
public interface HealthService {

    String healthy(String name) throws Exception;

}
