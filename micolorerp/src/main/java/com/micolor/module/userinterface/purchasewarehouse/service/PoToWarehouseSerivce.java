package com.micolor.module.userinterface.purchasewarehouse.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.entity.userinterface.Po;

import java.util.List;

/**
 * Created by santiago on 12/11/16.
 */
public interface PoToWarehouseSerivce {
    List getList(DataTables dataTables);
    Long getCount(DataTables dataTables);

    MsgBean deleteObject(Po[] pos);
    MsgBean saveObject(Po po);

    Po getObject(Po po);
    Po getObjectByKey(String key);

    Po getPoByKey(String poNo);

    List<Po> getList();
}
