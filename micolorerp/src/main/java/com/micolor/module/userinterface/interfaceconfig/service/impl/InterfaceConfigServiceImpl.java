package com.micolor.module.userinterface.interfaceconfig.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.entity.userinterface.InterfaceConfig;
import com.micolor.module.userinterface.interfaceconfig.service.InterfaceConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28 0028.
 */
@Service("interfaceConfigService")
public class InterfaceConfigServiceImpl implements InterfaceConfigService{

    @Resource
    DaoService daoService;

    public InterfaceConfig getByInterfaceCode(String code) {
        InterfaceConfig interfaceConfig = (InterfaceConfig) daoService.get("from InterfaceConfig where interfaceCode = ? ",new Object[]{code});
        return interfaceConfig;
    }

    public List<InterfaceConfig> findByActionName(String actionName) {
        List<InterfaceConfig> interfaceConfigs = daoService.find("from InterfaceConfig where interfaceAction = ? ",new Object[]{actionName});
        return interfaceConfigs;
    }
}
