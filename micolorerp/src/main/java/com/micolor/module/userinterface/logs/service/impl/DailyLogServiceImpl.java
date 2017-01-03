package com.micolor.module.userinterface.logs.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.statics.EnumUtil;
import com.micolor.entity.userinterface.DailyLog;
import com.micolor.module.userinterface.logs.service.DailyLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liuhx on 2016/11/27 0027.
 *
 * 记录操作日志
 */
@Service("dailyLogService")
@Transactional
public class DailyLogServiceImpl implements DailyLogService{

    @Resource
    private DaoService daoService;

    public MsgBean add(DailyLog dailyLog){
        MsgBean msgBean = new MsgBean();
        try{
            daoService.save(dailyLog);
            msgBean.setContent(dailyLog);
            msgBean.setMsg("DAILY_LOG保存成功!");
            msgBean.setStatus(EnumUtil.MessageStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            msgBean.setContent(dailyLog);
            msgBean.setMsg("DAILY_LOG保存失败!原因:"+e.getMessage());
            msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
        }
        return msgBean;
    }

    public MsgBean update(DailyLog dailyLog) {
        MsgBean msgBean = new MsgBean();
        try{
            daoService.update(dailyLog);
            msgBean.setContent(dailyLog);
            msgBean.setMsg("DAILY_LOG保存成功!");
            msgBean.setStatus(EnumUtil.MessageStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            msgBean.setContent(dailyLog);
            msgBean.setMsg("DAILY_LOG保存失败!原因:"+e.getMessage());
            msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
        }
        return msgBean;
    }

    public MsgBean addLogList(List<DailyLog> dailyLogs) {
        MsgBean msgBean = new MsgBean();
        try{
            for (DailyLog dailyLog:dailyLogs){
                this.add(dailyLog);
            }
            msgBean.setContent(dailyLogs);
            msgBean.setMsg("DAILY_LOG保存成功!");
            msgBean.setStatus(EnumUtil.MessageStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            msgBean.setContent(dailyLogs);
            msgBean.setMsg("DAILY_LOG保存失败!原因:"+e.getMessage());
            msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
        }
        return msgBean;
    }

    public MsgBean updateLogList(List<DailyLog> dailyLogs) {
        MsgBean msgBean = new MsgBean();
        try{
            for (DailyLog dailyLog:dailyLogs){
                this.update(dailyLog);
            }
            msgBean.setContent(dailyLogs);
            msgBean.setMsg("DAILY_LOG保存成功!");
            msgBean.setStatus(EnumUtil.MessageStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            msgBean.setContent(dailyLogs);
            msgBean.setMsg("DAILY_LOG保存失败!原因:"+e.getMessage());
            msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
        }
        return msgBean;
    }


    public DaoService getDaoService() {
        return daoService;
    }

    public void setDaoService(DaoService daoService) {
        this.daoService = daoService;
    }
}
