package com.micolor.module.demo.dictclass.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.entity.demo.DictClassEntity;

import java.util.List;

/**
 * FileName:com.micolor.system.dictclass.service.impl.DictClassService.
 * Discription: 字典类别接口
 * Author: geyupeng.
 * DateTime 16/3/2.
 */
public interface DictClassService {
    List getDictClassList(DataTables dataTables);
    Long getDictClassCount(DataTables dataTables);

    MsgBean deleteDictClass(DictClassEntity [] dictClassEntities);
    MsgBean saveDictClass(DictClassEntity dictClassEntity);

    DictClassEntity getDictClass(DictClassEntity dictClassEntity);

}
