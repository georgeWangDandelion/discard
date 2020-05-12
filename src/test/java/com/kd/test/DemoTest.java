package com.kd.test;

import com.kd.actua.ActuatorDemo;
import com.kd.actua.demo.DemOne;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ActuatorDemo.class})
public class DemoTest {


    @Test
    public void test1() {
        new DemOne().aa();
    }
}
