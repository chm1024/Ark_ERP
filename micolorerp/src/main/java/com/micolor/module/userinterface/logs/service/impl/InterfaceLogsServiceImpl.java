package com.micolor.module.userinterface.logs.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.common.statics.EnumUtil;
import com.micolor.entity.userinterface.InterfaceLogs;
import com.micolor.module.userinterface.logs.service.InterfaceLogsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liusi on 2016/12/1.
 */
@Service("interfaceLogsService")
@Transactional
public class InterfaceLogsServiceImpl implements InterfaceLogsService{

    @Resource
    private DaoService daoService;

    public MsgBean add(InterfaceLogs interfaceLogs) {
        MsgBean msgBean = new MsgBean();
        try{
            daoService.save(interfaceLogs);
            msgBean.setContent(interfaceLogs);
            msgBean.setMsg("保存成功!");
            msgBean.setStatus(EnumUtil.MessageStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            msgBean.setContent(interfaceLogs);
            msgBean.setMsg("保存失败!原因:"+e.getMessage());
            msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
        }
        return msgBean;
    }

    public MsgBean update(InterfaceLogs interfaceLogs) {
        MsgBean msgBean = new MsgBean();
        try{
            daoService.update(interfaceLogs);
            msgBean.setContent(interfaceLogs);
            msgBean.setMsg("保存成功!");
            msgBean.setStatus(EnumUtil.MessageStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            msgBean.setContent(interfaceLogs);
            msgBean.setMsg("保存失败!原因:"+e.getMessage());
            msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
        }
        return msgBean;
    }

    public List getSendLogsList(DataTables dataTables) {
        List list= daoService.find("from InterfaceLogs" ,dataTables);
        return list;
    }

    public Long getSendLogsCount(DataTables dataTables) {
        Long count = 0L;
        try{
            count = daoService.count("select count(*) from InterfaceLogs",dataTables);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }


}
