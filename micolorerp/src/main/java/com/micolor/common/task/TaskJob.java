package com.micolor.common.task;

/**
 * Created by liusi on 2016/11/17.
 */
import com.micolor.entity.userinterface.VCommodityHeader;
import com.micolor.module.userinterface.F001.action.ActionVCommodityHeader;
import com.micolor.module.userinterface.F001.service.VCommodityHeaderSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("taskJob")
public class TaskJob {

    @Resource
    VCommodityHeaderSerivce vCommodityHeaderSerivce;

    @Scheduled(cron = "0 59 14 * * ?")
    public void job1() {
        System.out.println("任务开始。。。");
        vCommodityHeaderSerivce.sendVCommodityHeader();
        System.out.println("任务结束。。。");
    }
}
