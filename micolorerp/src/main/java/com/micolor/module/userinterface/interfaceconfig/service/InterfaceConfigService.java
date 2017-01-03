package com.micolor.module.userinterface.interfaceconfig.service;

import com.micolor.entity.userinterface.InterfaceConfig;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28 0028.
 */
public interface InterfaceConfigService {

    InterfaceConfig getByInterfaceCode(String code);

    List<InterfaceConfig> findByActionName(String actionName);
}
