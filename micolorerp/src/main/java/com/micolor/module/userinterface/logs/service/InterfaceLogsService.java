package com.micolor.module.userinterface.logs.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.entity.userinterface.InterfaceLogs;

import java.util.List;

/**
 * Created by liusi on 2016/12/1.
 */
public interface InterfaceLogsService {

    MsgBean add(InterfaceLogs interfaceLogs);

    MsgBean update(InterfaceLogs interfaceLogs);

    List getSendLogsList(DataTables dataTables);

    Long getSendLogsCount(DataTables dataTables);
}
