package com.micolor.module.demo.trans.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.entity.demo.TransValue;

import java.util.List;

/**
 * Created by Evangoe on 24/06/16.
 */
public interface TransValueSerivce {
    List getList(DataTables dataTables);
    Long getCount(DataTables dataTables);

    MsgBean deleteObject(TransValue[] transValues);
    MsgBean saveObject(TransValue transValue);

    TransValue getObject(TransValue transValue);
    TransValue getObjectByKey(TransValue transValue);

    List<TransValue> getList();
}
