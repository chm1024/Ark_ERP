package com.micolor.module.demo.dictclass.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.common.method.datatables.DataTables4Hql;
import com.micolor.common.statics.EnumUtil;
import com.micolor.entity.demo.DictClassEntity;
import com.micolor.module.demo.dictclass.service.DictClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * FileName:com.micolor.system.dictclass.service.impl.DictClassImpl.
 * Discription: 字典类别接口实现类
 * Author: geyupeng.
 * DateTime 16/3/2.
 */
@Service("dictClassService")
public class DictClassImpl implements DictClassService {
    @Resource
    DaoService daoService;

    public List getDictClassList(DataTables dataTables) {
        List list = null;
        Object[] params = DataTables4Hql.DataTables2Params(dataTables);
        String Hql = DataTables4Hql.DataTables2Hql("from DictClassEntity", dataTables);
        if (dataTables.getLength() != -1) {
            int page = (dataTables.getStart() / dataTables.getLength()) + 1;
            list = daoService.find(Hql, params, page, dataTables.getLength());
        } else {
            list = daoService.find(Hql, params);
        }
        return list;
    }

    public Long getDictClassCount(DataTables dataTables) {
        Object[] params = DataTables4Hql.DataTables2Params(dataTables);
        String Hql = DataTables4Hql.DataTables2Hql("select count(*) from DictClassEntity", dataTables);

        System.out.println("count sql :" + Hql);

        Long count = daoService.count(Hql, params);
        return count;
    }

    public MsgBean deleteDictClass(DictClassEntity[] dictClassEntities) {
        MsgBean msgBean = new MsgBean();
        for (DictClassEntity dictClassEntity : dictClassEntities) {
            daoService.delete(dictClassEntity);
        }
        msgBean.setContent("");
        msgBean.setMsg("删除成功!");
        msgBean.setStatus(EnumUtil.MessageStatus.OK);
        return msgBean;
    }

    public MsgBean saveDictClass(DictClassEntity dictClassEntity) {
        MsgBean msgBean = new MsgBean();
        daoService.saveOrUpdate(dictClassEntity);
        //daoService.update(dictClassEntity);
        msgBean.setContent(dictClassEntity);
        msgBean.setMsg("保存成功!");
        msgBean.setStatus(EnumUtil.MessageStatus.OK);
        return msgBean;
    }

    public DictClassEntity getDictClass(DictClassEntity dictClassEntity) {
        String Hql = "from DictClassEntity where dicode = ? ";
        dictClassEntity = (DictClassEntity) daoService.get(Hql, new Object[]{dictClassEntity.getDicode()});
        return dictClassEntity;
    }
}
