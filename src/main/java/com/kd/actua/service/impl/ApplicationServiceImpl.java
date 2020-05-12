package com.kd.actua.service.impl;

import com.alibaba.fastjson.JSON;
import com.kd.actua.entity.PID;
import com.kd.actua.entity.Parameter;
import com.kd.actua.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private RestTemplate restTemplate;

    public String getServices() {
        String url = "http://192.168.30.246:6094/applications";
        String body = this.getBody(url,"Accept","application/json");
        return body;
    }

    @Override
    public PID getPID(String id) {
        String url = "http://192.168.30.246:6094/instances/"+id+"/actuator/env/PID";
        String body = this.getBody(url,"Accept","application/json");
        return JSON.parseObject(body, PID.class);
    }

    @Override
    public Parameter getUpTime(String id) {
        String url = "http://192.168.30.246:6094/instances/"+id+"/actuator/metrics/process.uptime";
        String body = this.getBody(url,"Accept","application/json");
        System.out.println(body);
        return JSON.parseObject(body, Parameter.class);
    }

    @Override
    public Parameter getProcessUsage(String id) {
        String url = "http://192.168.30.246:6094/instances/"+id+"/actuator/metrics/process.cpu.usage";
        String body = this.getBody(url,"Accept","application/json");
        return JSON.parseObject(body, Parameter.class);
    }

    @Override
    public Parameter getSysUsage(String id) {
        String url = "http://192.168.30.246:6094/instances/"+id+"/actuator/metrics/system.cpu.usage";
        String body = this.getBody(url,"Accept","application/json");
        return JSON.parseObject(body, Parameter.class);
    }

    @Override
    public Parameter getSysCount(String id) {
        String url = "http://192.168.30.246:6094/instances/"+id+"/actuator/metrics/system.cpu.count";
        String body = this.getBody(url,"Accept","application/json");
        return JSON.parseObject(body, Parameter.class);
    }

    @Override
    public Parameter getThreadLive(String id) {
        String url = "http://192.168.30.246:6094/instances/"+id+"/actuator/metrics/jvm.thread.live";
        String body = this.getBody(url,"Accept","application/json");
        return JSON.parseObject(body, Parameter.class);
    }

    @Override
    public Parameter getThreadPeak(String id) {
        String url = "http://192.168.30.246:6094/instances/"+id+"/actuator/metrics/jvm.threads.peak";
        String body = this.getBody(url,"Accept","application/json");
        return JSON.parseObject(body, Parameter.class);
    }

    @Override
    public Parameter getThreadDaemon(String id) {
        String url = "http://192.168.30.246:6094/instances/"+id+"/actuator/metrics/jvm.thread.daemon";
        String body = this.getBody(url,"Accept","application/json");
        return JSON.parseObject(body, Parameter.class);
    }

    @Override
    public Parameter getHeapMemUsed(String id) {
        String url = "http://192.168.30.246:6094/instances/"+id+"/actuator/metrics/jvm.memory.used?tag=area:heap";
        String body = this.getBody(url,"Accept","application/json");
        return JSON.parseObject(body, Parameter.class);
    }

    @Override
    public Parameter getHeapMemCommited(String id) {
        String url = "http://192.168.30.246:6094/instances/"+id+"/actuator/metrics/jvm.memory.committed?tag=area:heap";
        String body = this.getBody(url,"Accept","application/json");
        return JSON.parseObject(body, Parameter.class);
    }

    @Override
    public Parameter getHeapMemMax(String id) {
        String url = "http://192.168.30.246:6094/instances/"+id+"/actuator/metrics/jvm.memory.max?tag=area:heap";
        String body = this.getBody(url,"Accept","application/json");
        return JSON.parseObject(body, Parameter.class);
    }

    @Override
    public Parameter getNonHeapMemCommited(String id) {
        String url = "http://192.168.30.246:6094/instances/"+id+"/actuator/metrics/jvm.memory.committed?tag=area:nonheap";
        String body = this.getBody(url,"Accept","application/json");
        return JSON.parseObject(body, Parameter.class);
    }

    @Override
    public Parameter getNonHeapMemMax(String id) {
        String url = "http://192.168.30.246:6094/instances/"+id+"/actuator/metrics/jvm.memory.max?tag=area:nonheap";
        String body = this.getBody(url,"Accept","application/json");
        return JSON.parseObject(body, Parameter.class);
    }

    @Override
    public Parameter getNonHeapMemUsed(String id) {
        String url = "http://192.168.30.246:6094/instances/"+id+"/actuator/metrics/jvm.memory.used?tag=area:nonheap,id:Metaspace";
        String body = this.getBody(url,"Accept","application/json");
        return JSON.parseObject(body, Parameter.class);
    }

    @Override
    public Parameter getMappings(String id) {
        String url = "http://192.168.30.246:6094/instances/"+id+"/actuator/mappings";
        String body = this.getBody(url,"Accept","application/json");
        return JSON.parseObject(body, Parameter.class);
    }

    private String getBody(String url, String headerName, String headerValue) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(headerName,headerValue);
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        } catch (HttpClientErrorException he) {
            return "{'description':'not found'}";
        }
        return responseEntity.getBody();
    }



}
