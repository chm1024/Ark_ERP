package com.micolor.module.system.dictionary.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.entity.system.TDictionary;

import java.util.List;

/**
 * Created by Evangoe on 03/06/16.
 */
public interface DictionaryService {
    List getDictionaryList(DataTables dataTables);

    Long getDictionaryCount(DataTables dataTables);

    MsgBean deleteDictionary(TDictionary[] tDictionaries);

    MsgBean saveDictionary(TDictionary tDictionary);

    TDictionary getDictionary(TDictionary tDictionary);
}
