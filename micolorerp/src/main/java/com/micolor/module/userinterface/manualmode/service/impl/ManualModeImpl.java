package com.micolor.module.userinterface.manualmode.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.module.userinterface.manualmode.service.ManualModeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by GeYupeng on 2016-11-02.
 */
@Service("manualModeService")
@Transactional
public class ManualModeImpl implements ManualModeService{
    @Resource
    DaoService daoService;

    public Long getInterfaceCount(DataTables dataTables) {
        Long count = 0L;
        try{
            count = daoService.count("select count(*) from InterfaceEntity",dataTables);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    public List getInterfaceList(DataTables dataTables) {
        List list= daoService.find("from InterfaceEntity where status = 1" ,dataTables);
        return list;
    }
}
