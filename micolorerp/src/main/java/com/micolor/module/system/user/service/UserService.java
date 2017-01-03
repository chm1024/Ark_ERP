package com.micolor.module.system.user.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.entity.system.TOrganizationEntity;
import com.micolor.entity.system.UserEntity;

import java.util.List;

/**
 * FileName:com.micolor.system.user.service.UserService.
 * Discription: 用户增删改查服务接口
 * Author: geyupeng.
 * DateTime 16/2/28.
 */
public interface UserService {
    /**
     * 获得所有用户信息记录
     * @param dataTables
     * @return
     */
    List getAllUser(DataTables dataTables);

    /**
     * 获得所有用户信息条数
     * @param dataTables
     * @return
     */
    Long getAllUserCount(DataTables dataTables);

    /**
     * 根据用户主键获得单条用户信息
     * @param UserEntity
     * @return
     */
    UserEntity getUser(UserEntity UserEntity);

    /**
     * 保存一条用户信息
     * @param UserEntity
     * @return
     */
    MsgBean saveUser(UserEntity UserEntity);

    /**
     * 删除一条或多条用户信息
     * @param tUserEntities
     * @return
     */
    MsgBean deleteUser(UserEntity[] tUserEntities);
}
