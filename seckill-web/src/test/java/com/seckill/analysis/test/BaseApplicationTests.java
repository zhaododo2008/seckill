package com.seckill.analysis.test;

import com.seckill.analysis.web.SecKillApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author zhaododo
 **/


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SecKillApplication.class})
@WebAppConfiguration
public class BaseApplicationTests {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void alive(){
       logger.debug("BaseApplicationTests is ok");
    }


}
