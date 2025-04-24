package com.atguigu.gmall.publisher.service;

import com.atguigu.gmall.publisher.bean.TrafficVisitorStatsPerHour;
import com.atguigu.gmall.publisher.bean.TrafficVisitorTypeStats;

import java.util.List;

public interface TrafficVisitorStatsService {
    // 获取分时流量数据
    List<TrafficVisitorStatsPerHour> getVisitorPerHrStats(Integer date);
    List<TrafficVisitorTypeStats> getVisitorTypeStats(Integer date);
}