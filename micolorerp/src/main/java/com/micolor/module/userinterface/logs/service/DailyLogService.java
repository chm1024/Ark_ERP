package com.micolor.module.userinterface.logs.service;

import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.MsgBean;
import com.micolor.entity.userinterface.DailyLog;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liuhx on 2016/11/27 0027.
 */
public interface DailyLogService {

    MsgBean add(DailyLog dailyLog);

    MsgBean update(DailyLog dailyLog);

    MsgBean addLogList(List<DailyLog> dailyLogs);

    MsgBean updateLogList(List<DailyLog> dailyLogs);

}
