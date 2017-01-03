package com.micolor.module.demo.trans.service.impl;


import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.common.statics.EnumUtil;
import com.micolor.entity.demo.TransValue;
import com.micolor.module.demo.trans.service.TransValueSerivce;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Evangoe on 24/06/16.
 */
@Service("transValueService")
public class TransValueImpl implements TransValueSerivce {
    @Resource
    DaoService daoService;

    public List getList(DataTables dataTables) {
        String Hql = "from TransValue";
        return daoService.find(Hql, dataTables);
    }

    public List getList() {
        String Hql = "from TransValue";
        return daoService.find(Hql);
    }

    public Long getCount(DataTables dataTables) {
        String Hql = "select count(*) from TransValue";
        return daoService.count(Hql, dataTables);
    }

    public MsgBean deleteObject(TransValue[] transValues) {
        MsgBean msgBean = new MsgBean();
        for (TransValue transValue : transValues) {
            daoService.delete(transValue);
        }
        msgBean.setContent("");
        msgBean.setMsg("删除成功!");
        msgBean.setStatus(EnumUtil.MessageStatus.OK);
        return msgBean;
    }

    public MsgBean saveObject(TransValue transValue) {
        MsgBean msgBean = new MsgBean();
        try {
            if (transValue.getId() == null || transValue.getId().equals("")) {
                daoService.save(transValue);
            } else {
                daoService.update(transValue);
            }
            msgBean.setContent(transValue);
            msgBean.setMsg("保存成功!");
            msgBean.setStatus(EnumUtil.MessageStatus.OK);
        } catch (Exception e) {
            msgBean.setMsg("保存失败!");
            msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
        }
        return msgBean;
    }

    public TransValue getObject(TransValue transValue) {
        String Hql = "from TransValue where id = ? ";
        transValue = (TransValue) daoService.get(Hql, new Object[]{transValue.getId()});
        return transValue;
    }

    public TransValue getObjectByKey(TransValue transValue) {
        String Hql = "from TransValue where tvkey = ? ";
        transValue = (TransValue) daoService.get(Hql, new Object[]{transValue.getTvkey().trim()});
        return transValue;
    }
}
