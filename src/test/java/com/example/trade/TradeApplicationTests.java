package com.example.trade;

import com.example.trade.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class TradeApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private IStudentService iStudentService;
    @Test
    public void testStudent(){
        System.out.println("测啊hi");
        System.out.println(iStudentService.selectByCourse(13,"语文"));
    }

}
