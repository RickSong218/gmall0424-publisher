package com.atguigu.gmall.publisher.service;

import com.atguigu.gmall.publisher.bean.TrafficUvCt;

import java.util.List;

/*
 流量域统计service接口
 */
public interface TrafficStatsService {
    //获取某天各个渠道独立访客
    List<TrafficUvCt> getChUvCt(Integer date,Integer limit);
}