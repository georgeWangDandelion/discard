package com.kd.actua.controller;

import com.kd.actua.entity.PID;
import com.kd.actua.entity.Parameter;
import com.kd.actua.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping("/applications")
    public String getServices() {
        return applicationService.getServices();
    }

    @RequestMapping("/instances/{params}/actuator/env/PID")
    public PID getPID(@PathVariable String params) {
        return applicationService.getPID(params);
    }

    @RequestMapping("/instances/{params}/actuator/metrics/process.uptime")
    public Parameter getUptime(@PathVariable String params) {
        return applicationService.getUpTime(params);
    }

    @RequestMapping("/instances/{params}/actuator/metrics/process.cpu.usage")
    public Parameter getProcessUsage(@PathVariable String params) {
        return applicationService.getProcessUsage(params);
    }

    @RequestMapping("/instances/{params}/actuator/metrics/system.cpu.usage")
    public Parameter getSysUsage(@PathVariable String params) {
        return applicationService.getSysUsage(params);
    }

    @RequestMapping("/instances/{params}/actuator/metrics/system.cpu.count")
    public Parameter getSysCount(@PathVariable String params) {
        return applicationService.getSysCount(params);
    }

    @RequestMapping("/instances/{params}/actuator/metrics/jvm.thread.live")
    public Parameter getThreadLive(@PathVariable String params) {
        return applicationService.getThreadLive(params);
    }

    @RequestMapping("/instances/{params}/actuator/metrics/jvm.threads.peak")
    public Parameter getThreadPeak(@PathVariable String params) {
        return applicationService.getThreadPeak(params);
    }

    @RequestMapping("/instances/{params}/actuator/metrics/jvm.thread.daemon")
    public Parameter getThreadDaemon(@PathVariable String params) {
        return applicationService.getThreadDaemon(params);
    }

    @RequestMapping("/instances/{params}/actuator/metrics/jvm.memory.used?tag=area:heap")
    public Parameter getHeapMemUsed(@PathVariable String params) {
        return applicationService.getHeapMemUsed(params);
    }

    @RequestMapping("/instances/{params}/actuator/metrics/jvm.memory.committed?tag=area:heap")
    public Parameter getHeapMemCommited(@PathVariable String params) {
        return applicationService.getHeapMemCommited(params);
    }

    @RequestMapping("/instances/{params}/actuator/metrics/jvm.memory.max?tag=area:heap")
    public Parameter getHeapMemMax(@PathVariable String params) {
        return applicationService.getHeapMemMax(params);
    }


    @RequestMapping("/instances/{params}/actuator/metrics/jvm.memory.committed?tag=area:nonheap")
    public Parameter getNonHeapMemCommited(@PathVariable String params) {
        return applicationService.getNonHeapMemCommited(params);
    }

    @RequestMapping("/instances/{params}/actuator/metrics/jvm.memory.max?tag=area:nonheap")
    public Parameter getNonHeapMemMax(@PathVariable String params) {
        return applicationService.getNonHeapMemMax(params);
    }

    @RequestMapping("/instances/{params}/actuator/metrics/jvm.memory.used?tag=area:nonheap,id:Metaspace")
    public Parameter getNonHeapMemUsed(@PathVariable String params) {
        return applicationService.getNonHeapMemUsed(params);
    }

    @RequestMapping("/instances/{params}/actuator/mappings")
    public Parameter getMappings(@PathVariable String params) {
        return applicationService.getMappings(params);
    }

}

