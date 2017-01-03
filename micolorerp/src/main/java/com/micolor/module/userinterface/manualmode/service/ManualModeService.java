package com.micolor.module.userinterface.manualmode.service;

import com.micolor.common.entities.datatables.DataTables;

import java.util.List;


/**
 * Created by GeYupeng on 2016-11-02.
 */
public interface ManualModeService {
    List getInterfaceList(DataTables dataTables);
    Long getInterfaceCount(DataTables dataTables);
}
