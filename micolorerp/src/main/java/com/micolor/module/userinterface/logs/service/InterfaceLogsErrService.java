package com.micolor.module.userinterface.logs.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.entity.userinterface.InterfaceLogsErr;

import java.util.List;

/**
 * Created by liusi on 2016/12/1.
 */
public interface InterfaceLogsErrService {

    MsgBean add(InterfaceLogsErr interfaceLogsErr);

    List getSendLogsErrList(DataTables dataTables);

    Long getSendLogsErrCount(DataTables dataTables);

    InterfaceLogsErr findById(String id);

}
