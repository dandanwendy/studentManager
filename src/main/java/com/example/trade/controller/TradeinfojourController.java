package com.example.trade.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.trade.dto.ResponseMsg;
import com.example.trade.entity.Student;
import com.example.trade.entity.Tradeinfojour;
import com.example.trade.service.ITradeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/tradeInfoJour")
public class TradeinfojourController {

    @Autowired
    private ITradeInfoService iTradeInfoService;

    @GetMapping("/list1")
    @ResponseBody/*不加ResponseBody注解无法响应到前端页面*/
    public Tradeinfojour quick(){
        List<Tradeinfojour> tradeinfojours = iTradeInfoService.findAll();
        return tradeinfojours.get(0);
    }

    /*@GetMapping("/getStockJourList")
    @ResponseBody
    public Object getStockJourList(@RequestParam( value = "current",defaultValue = "1",required = false) Integer current,
                                   @RequestParam( value = "size",defaultValue = "10",required = false) Integer size, String year){
        Page page = new Page<>(current,size);
        ResponseMsg responseMsg = iTradeInfoService.getStockJourList(page,year);
        return responseMsg;
    }*/

}
