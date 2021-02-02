package com.example.trade.service;


import com.example.trade.entity.Tradeinfojour;

import java.util.List;

public interface ITradeInfoService {
    List<Tradeinfojour> findAll();

    //ResponseMsg getStockJourList(Page<Tradeinfojour> page, String year);
}
