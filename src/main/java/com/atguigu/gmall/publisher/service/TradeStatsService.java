package com.atguigu.gmall.publisher.service;

import com.atguigu.gmall.publisher.bean.TradeProvinceOrderAmount;
import com.atguigu.gmall.publisher.bean.TradeProvinceOrderCt;
import com.atguigu.gmall.publisher.bean.TradeStats;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Felix
 * @date 2024/12/11
 *  交易域统计service接口
 */
public interface TradeStatsService {
    //获取某天总交易额
    //BigDecimal getGMV(Integer date);

    Double getTotalAmount(Integer date);

    List<TradeStats> getTradeStats(Integer date);

    List<TradeProvinceOrderCt> getTradeProvinceOrderCt(Integer date);

    List<TradeProvinceOrderAmount> getTradeProvinceOrderAmount(Integer date);
}
