package com.atguigu.gmall.publisher.controller;

import com.atguigu.gmall.publisher.bean.TrafficUvCt;
import com.atguigu.gmall.publisher.util.DateUtil;
import com.atguigu.gmall.publisher.service.TrafficStatsService;
import com.atguigu.gmall.publisher.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
 流量域统计controller
 */
@RestController
public class TrafficStatsController {

    @Autowired
    TrafficStatsService trafficStatsService;

    @RequestMapping("/ch")
    public String getChUvCt(
            @RequestParam(value = "date",defaultValue = "0") Integer date,
            @RequestParam(value = "limit",defaultValue = "10") Integer limit){

        if(date == 0){
            date = DateUtil.now();
        }
        List<TrafficUvCt> trafficUvCtList = trafficStatsService.getChUvCt(date, limit);
        List chList = new ArrayList();
        List uvCtList = new ArrayList();
        for (TrafficUvCt trafficUvCt : trafficUvCtList) {
            chList.add(trafficUvCt.getCh());
            uvCtList.add(trafficUvCt.getUvCt());
        }

        String json = "{\"status\": 0,\"data\": {\"categories\": [\""+StringUtils.join(chList,"\",\"")+"\"],\n" +
                "    \"series\": [{\"name\": \"渠道\",\"data\": ["+StringUtils.join(uvCtList,",")+"]}]}}";
        return json;
    }
}
