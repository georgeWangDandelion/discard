package com.kd.actua.service;

import com.kd.actua.entity.PID;
import com.kd.actua.entity.Parameter;


public interface ApplicationService {

    public String getServices();

    public PID getPID(String id);

    public Parameter getUpTime(String id);

    public Parameter getProcessUsage(String id);

    public Parameter getSysUsage(String id);

    public Parameter getSysCount(String id);

    public Parameter getThreadLive(String id);

    public Parameter getThreadPeak(String id);

    public Parameter getThreadDaemon(String id);

    public Parameter getHeapMemUsed(String id);

    public Parameter getHeapMemCommited(String id);

    public Parameter getHeapMemMax(String id);

    public Parameter getNonHeapMemCommited(String id);

    public Parameter getNonHeapMemMax(String id);

    public Parameter getNonHeapMemUsed(String id);

    public Parameter getMappings(String id);
}
