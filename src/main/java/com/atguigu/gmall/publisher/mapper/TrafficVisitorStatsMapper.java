package com.atguigu.gmall.publisher.mapper;

import com.atguigu.gmall.publisher.bean.TrafficVisitorStatsPerHour;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.atguigu.gmall.publisher.bean.TrafficVisitorTypeStats;

import java.util.List;

public interface TrafficVisitorStatsMapper {

    // 分时流量数据查询
    @Select("select hour(stt)                                                                    hr,\n" +
            "       sum(uv_ct)                                                                   uv_ct,\n" +
            "       sum(pv_ct)                                                                   pv_ct,\n" +
            "       sum(if(is_new = '1', dws_traffic_vc_ch_ar_is_new_page_view_window.uv_ct, 0)) new_uv_ct\n" +
            "from dws_traffic_vc_ch_ar_is_new_page_view_window\n" +
            "         partition (par#{date})\n" +
            "group by hr")
    List<TrafficVisitorStatsPerHour> selectVisitorStatsPerHr(@Param("date")Integer date);

    @Select("select is_new,\n" +
            "       sum(uv_ct)   uv_ct,\n" +
            "       sum(pv_ct)   pv_ct,\n" +
            "       sum(sv_ct)   sv_ct,\n" +
            "       sum(uj_ct)   uj_ct,\n" +
            "       sum(dur_sum) dur_sum\n" +
            "from dws_traffic_vc_ch_ar_is_new_page_view_window\n" +
            "         partition (par#{date})\n" +
            "group by is_new")
    List<TrafficVisitorTypeStats> selectVisitorTypeStats(@Param("date")Integer date);
}