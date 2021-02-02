package com.example.trade.service.impl;

import com.example.trade.entity.Tradeinfojour;
import com.example.trade.mapper.TradeinfojourMapper;
import com.example.trade.service.ITradeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ITradeInfoServiceImpl implements ITradeInfoService {
    @Resource
    private TradeinfojourMapper tradeinfojourMapper;

    @Override
    public List<Tradeinfojour> findAll() {
        return tradeinfojourMapper.findAll();
    }
}
