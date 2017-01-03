package com.micolor.module.system.organization.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.common.method.datatables.DataTables4Hql;
import com.micolor.common.statics.EnumUtil;
import com.micolor.entity.system.TOrganizationEntity;
import com.micolor.module.system.organization.service.OrganizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by GEYUPENG on 2016/4/19.
 */
@Service("organizationService")
public class OrganizationImpl implements OrganizationService {
    @Resource
    DaoService daoService;

    public List getOrganizationList(DataTables dataTables) {
        List list = null;
        Object[] params = DataTables4Hql.DataTables2Params(dataTables);
        String Hql = DataTables4Hql.DataTables2Hql("from TOrganizationEntity", dataTables);
        if (dataTables.getLength() != -1) {
            int page = (dataTables.getStart() / dataTables.getLength()) + 1;
            list = daoService.find(Hql, params, page, dataTables.getLength());
        } else {
            list = daoService.find(Hql, params);
        }
        return list;
    }

    public Long getOrganizationCount(DataTables dataTables) {
        Object[] params = DataTables4Hql.DataTables2Params(dataTables);
        String Hql = DataTables4Hql.DataTables2Hql("select count(*) from TOrganizationEntity", dataTables);

        System.out.println("count sql :" + Hql);

        Long count = daoService.count(Hql, params);
        return count;
    }

    public MsgBean deleteOrganization(TOrganizationEntity[] tOrganizationEntities) {
        MsgBean msgBean = new MsgBean();
        for (TOrganizationEntity tOrganizationEntity : tOrganizationEntities) {
            daoService.delete(tOrganizationEntity);
        }
        msgBean.setContent("");
        msgBean.setMsg("删除成功!");
        msgBean.setStatus(EnumUtil.MessageStatus.OK);
        return msgBean;
    }

    public MsgBean saveOrganization(TOrganizationEntity tOrganizationEntity) {

        daoService.saveOrUpdate(tOrganizationEntity);


        MsgBean msgBean = new MsgBean();
        msgBean.setContent(tOrganizationEntity);
        msgBean.setMsg("保存成功!");
        msgBean.setStatus(EnumUtil.MessageStatus.OK);
        return msgBean;
    }

    public TOrganizationEntity getOrganization(TOrganizationEntity tOrganizationEntity) {
        String Hql = "from DictClassEntity where dicode = ? ";
        tOrganizationEntity = (TOrganizationEntity) daoService.get(Hql, new Object[]{tOrganizationEntity.getId()});
        return tOrganizationEntity;
    }
}
