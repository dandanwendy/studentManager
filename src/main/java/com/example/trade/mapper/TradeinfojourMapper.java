package com.example.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.trade.dto.StatisticalResult;
import com.example.trade.entity.Student;
import com.example.trade.entity.Tradeinfojour;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TradeinfojourMapper extends BaseMapper<Tradeinfojour> {
    public List<Tradeinfojour> findAll();

    List<StatisticalResult> getStockJourList(long current, long size , Integer year, Integer year1, Integer year2);
}
