package com.micolor.module.userinterface.logs.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.common.statics.EnumUtil;
import com.micolor.entity.userinterface.InterfaceLogsErr;
import com.micolor.module.userinterface.logs.service.InterfaceLogsErrService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liusi on 2016/12/1.
 */
@Service("interfaceLogsErrService")
@Transactional
public class InterfaceLogsErrServiceImpl implements InterfaceLogsErrService{

    @Resource
    private DaoService daoService;


    public MsgBean add(InterfaceLogsErr interfaceLogsErr) {
        MsgBean msgBean = new MsgBean();
        try{
            daoService.save(interfaceLogsErr);
            msgBean.setContent(interfaceLogsErr);
            msgBean.setMsg("保存成功!");
            msgBean.setStatus(EnumUtil.MessageStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            msgBean.setContent(interfaceLogsErr);
            msgBean.setMsg("保存失败!原因:"+e.getMessage());
            msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
        }
        return msgBean;
    }

    public List getSendLogsErrList(DataTables dataTables) {
        List list= daoService.find("from InterfaceLogsErr" ,dataTables);
        return list;
    }

    public Long getSendLogsErrCount(DataTables dataTables) {
        Long count = 0L;
        try{
            count = daoService.count("select count(*) from InterfaceLogsErr",dataTables);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public InterfaceLogsErr findById(String id) {
        InterfaceLogsErr interfaceLogsErr = (InterfaceLogsErr)daoService.find("from InterfaceLogsErr where id = '"+id+"'").get(0);
        return interfaceLogsErr;
    }
}
