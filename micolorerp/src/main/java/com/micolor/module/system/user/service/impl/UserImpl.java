package com.micolor.module.system.user.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.common.statics.EnumUtil;
import com.micolor.entity.system.TOrganizationEntity;
import com.micolor.entity.system.UserEntity;
import com.micolor.module.system.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * FileName:com.micolor.system.user.service.impl.UserImpl.
 * Discription: 用户增删改查接口实现类
 * Author: geyupeng.
 * DateTime 16/2/28.
 */
@Service("userService")
@Transactional
public class UserImpl implements UserService {
    @Resource
    DaoService daoService;

    public List getAllUser(DataTables dataTables) {

        List list= daoService.find("from UserEntity" ,dataTables);

        return list;
    }

    public Long getAllUserCount(DataTables dataTables) {
        Long count = 0L;
        try{
            count = daoService.count("select count(*) from UserEntity",dataTables);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    public UserEntity getUser(UserEntity UserEntity) {
        UserEntity = (UserEntity) daoService.get("from UserEntity where id = ? " ,new Object[]{UserEntity.getId()});
        return UserEntity;
    }

    public MsgBean saveUser(UserEntity UserEntity) {
        MsgBean msgBean = new MsgBean();
        try{
            if(UserEntity.getId()==null ||UserEntity.getId().equals("")){
                daoService.save(UserEntity);
            }else{
                daoService.update(UserEntity);
            }
            msgBean.setContent(UserEntity);
            msgBean.setMsg("用户保存成功!");
            msgBean.setStatus(EnumUtil.MessageStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            msgBean.setContent(UserEntity);
            msgBean.setMsg("用户保存失败!原因:"+e.getMessage());
            msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
        }
        return msgBean;
    }

    public MsgBean deleteUser(UserEntity[] tUserEntities) {
        MsgBean msgBean = new MsgBean();
        for (UserEntity  UserEntity : tUserEntities) {
            daoService.delete(UserEntity);
        }
        msgBean.setContent("");
        msgBean.setMsg("删除成功!");
        msgBean.setStatus(EnumUtil.MessageStatus.OK);
        return msgBean;
    }
}
