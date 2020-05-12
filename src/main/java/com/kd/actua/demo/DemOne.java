package com.kd.actua.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kd.actua.entity.Instance;
import com.kd.actua.entity.ServiceIns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class DemOne {

    //@Scheduled(cron = "0 0/1 * * * ? ")
    //kafkaTemplate.send("actuatorsInfo", JSON.toJSONString(actuatorsInfo));
    //http://192.168.30.246:6094/instances/1b14d36ec4aa/actuator/env/PID
    /**
     * @author wyb
     * @date 2020-5-8
     */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    @ResponseBody
    public String aa() {
        String url = "http://192.168.30.246:6094/applications";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept","application/json");
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        System.out.println(restTemplate);
        ResponseEntity<String> jsonObject = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        String body = jsonObject.getBody();
        JSONArray array = JSONArray.parseArray(body);
        String req_url_pre = "http://192.168.30.246:6094/instances/";
        //通过后缀请求CPU、内存等数据
        String[] req_rul_post =
                {"/actuator/metrics/process.uptime",
                "/actuator/metrics/process.cpu.usage",
                "/actuator/metrics/system.cpu.count",
                "/actuator/metrics/system.cpu.usage",
                "jvm.memory.used?tag=area:heap",
                "jvm.memory.used?tag=area:nonheap",
                "jvm.memory.max?tag=area:heap",
                "jvm.memory.max?tag=area:nonheap",
                "jvm.memory.commited?tag=area:heap",
                "jvm.memory.commited?tag=area:nonheap"};
        String req_url = "";
        Iterator iterator = array.iterator();
        List<String> list = new ArrayList<>();
        while (iterator.hasNext()) {
            JSONObject jb = (JSONObject) iterator.next();
            ServiceIns serviceIns = jb.toJavaObject(ServiceIns.class);
            Instance[] instances = serviceIns.getInstances();
            ResponseEntity<String> exchange = null;
            for(Instance instance : instances) {
                String id = instance.getId();
                //获取每一个parameter路径
                for (String post : req_rul_post) {
                    req_url = req_url_pre + id + post;
                    try {
                        exchange = restTemplate.exchange(req_url, HttpMethod.GET, entity, String.class);
                    } catch (HttpClientErrorException http) {
                        list.add(id + "not found");
                        System.out.println(id + " not found");
                        continue;
                    }
                    String body1 = exchange.getBody();
                    list.add(body1);
                    System.out.println(id + body1);
                }
            }
//            System.out.println(serviceIns);
        }
        System.out.println(JSONArray.parseArray(JSONArray.toJSONString(list)));
        return JSONArray.toJSONString(list);
    }

}
