package com.micolor.module.system.main.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.module.system.main.service.MainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * FileName:com.micolor.system.main.service.impl.MainImpl.
 * Discription: 主界面服务实现
 * Author: geyupeng.
 * DateTime 16/2/27.
 */
@Service("mainService")
public class MainImpl implements MainService{
    @Resource
    DaoService daoService;
    public List getUserModule(int ucode) {
        List list = daoService.find("from TModuleEntity where parentId is not null order by priority ");
        return list;
    }
}