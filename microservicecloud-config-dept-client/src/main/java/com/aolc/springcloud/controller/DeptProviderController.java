package com.aolc.springcloud.controller;

import com.aolc.springcloud.entity.DeptEntity;
import com.aolc.springcloud.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门服务提供
 *
 * @Auther: L.C
 * @Date: 2019-07-02 09:55
 */
@RestController
public class DeptProviderController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean addDept(@RequestBody DeptEntity deptEntity) {
        return deptService.addDept(deptEntity);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public DeptEntity getDeptById(@PathVariable("id") Long id) {
        return deptService.getDeptById(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET )
    public List<DeptEntity> getDeptList() {
        return deptService.getDeptList();
    }

    @RequestMapping("/dept/discovery")
    public Object dicorvery() {
        List<String> list = client.getServices();

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance server : srvList) {
            logger.info(server.getServiceId() + "\t" + server.getHost() + "\t" + server.getPort() + "\t" + server.getUri());
        }
        return this.client;
    }

}
