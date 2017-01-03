package com.micolor.module.userinterface.purchasewarehouse.service.impl;


import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.common.statics.EnumUtil;
import com.micolor.entity.userinterface.Po;
import com.micolor.module.userinterface.purchasewarehouse.service.PoToWarehouseSerivce;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Evangoe on 24/06/16.
 */
@Service("poToWarehouseService")
public class PoToWarehouseImpl implements PoToWarehouseSerivce {
    @Resource
    DaoService daoService;

    public List getList(DataTables dataTables) {
        String Hql = "from Po";
        return daoService.find(Hql, dataTables);
    }

    public List getList() {
        String Hql = "from Po";
        return daoService.find(Hql);
    }

    public Long getCount(DataTables dataTables) {
        String Hql = "select count(*) from Po";
        return daoService.count(Hql, dataTables);
    }

    public MsgBean deleteObject(Po[] pos) {
        MsgBean msgBean = new MsgBean();
        for (Po po : pos) {
            daoService.delete(po);
        }
        msgBean.setContent("");
        msgBean.setMsg("删除成功!");
        msgBean.setStatus(EnumUtil.MessageStatus.OK);
        return msgBean;
    }

    public MsgBean saveObject(Po po) {
        MsgBean msgBean = new MsgBean();
        try {
            if (po.getPoNo() == null || po.getPoNo().equals("")) {
                daoService.save(po);
            } else {
                daoService.update(po);
            }
            msgBean.setContent(po);
            msgBean.setMsg("保存成功!");
            msgBean.setStatus(EnumUtil.MessageStatus.OK);
        } catch (Exception e) {
            msgBean.setMsg("保存失败!");
            msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
        }
        return msgBean;
    }

    public Po getObject(Po po) {
        String Hql = "from Po where poNo = ? ";
        po = (Po) daoService.get(Hql, new Object[]{po.getPoNo()});
        return po;
    }

    public Po getObjectByKey(String customerCode) {
        String Hql = "from Po where customerCode = ? ";
        Po po = (Po) daoService.get(Hql, new Object[]{customerCode.trim()});
        return po;
    }

    public Po getPoByKey(String poNo) {
        String Hql = "from Po where poNo = ? ";
        Po po = (Po) daoService.get(Hql, new Object[]{poNo.trim()});
        return po;
    }
}
