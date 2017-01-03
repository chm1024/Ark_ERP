package com.micolor.module.system.main.service;

import java.util.List;

/**
 * FileName:com.micolor.system.main.service.MainService.
 * Discription: 主界面服务
 * Author: geyupeng.
 * DateTime 16/2/27.
 */
public interface MainService {
    /**
     * 获得用户的模块菜单列表
     *
     * @param ucode
     *
     * @return
     */
    List getUserModule(int ucode);
}
