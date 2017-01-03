package com.micolor.module.system.organization.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.entity.system.TOrganizationEntity;

import java.util.List;

/**
 * Created by GEYUPENG on 2016/4/19.
 */
public interface OrganizationService {

    List getOrganizationList(DataTables dataTables);
    Long getOrganizationCount(DataTables dataTables);

    MsgBean deleteOrganization(TOrganizationEntity[] tOrganizationEntities);
    MsgBean saveOrganization(TOrganizationEntity tOrganizationEntity);

    TOrganizationEntity getOrganization(TOrganizationEntity tOrganizationEntity);
}
