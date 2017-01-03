package com.micolor.module.system.dictionary.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.entity.system.TDictionary;
import com.micolor.module.system.dictionary.service.DictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Evangoe on 03/06/16.
 */
@Service("dictionaryService")
public class DictionaryImpl implements DictionaryService{
    @Resource
    DaoService daoService;


    public List getDictionaryList(DataTables dataTables) {
        String Hql ="from TDictionary";
        return daoService.find(Hql, dataTables);
    }

    public Long getDictionaryCount(DataTables dataTables) {
        String Hql = "select count(*) from TDictionary";
        return daoService.count(Hql, dataTables);
    }

    /**
     *
     * @param tDictionaries
     * @return
     */
    public MsgBean deleteDictionary(TDictionary[] tDictionaries) {
        return  daoService.delete(tDictionaries);
    }

    /**
     *
     * @param tDictionary
     * @return
     */
    public MsgBean saveDictionary(TDictionary tDictionary) {
        return daoService.saveOrUpdate(tDictionary);
    }

    public TDictionary getDictionary(TDictionary tDictionary) {
        String Hql = "from TDictionary where id = ? ";
        tDictionary = (TDictionary) daoService.get(Hql, new Object[]{tDictionary.getId()});
        return tDictionary;
    }
}
