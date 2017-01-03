package com.micolor.module.system.main.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.entity.system.TModuleEntity;
import com.micolor.module.system.main.service.MainService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName:com.micolor.system.main.action.ActionMain.
 * Discription: 主界面
 * Author: geyupeng.
 * DateTime 16/2/27.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/")
public class ActionMain extends BaseActionSupport{
    private MainService mainService;
    public void setMainService(MainService mainService) {
        this.mainService = mainService;
    }

    List list;
    List parentIdList;
    @RequiresPermissions("main:view")
    @Action(
            value="main",
            results = {
                    @Result(name="success",location = "/jsp/system/index/index.jsp")
            }
    )
    @Override
    public String execute() throws Exception {
        //Subject currentUser = SecurityUtils.getSubject();
        //System.out.println(currentUser.getSession().getId());
        list = mainService.getUserModule(1);
        parentIdList = new ArrayList<Integer>();
        List<Integer> listtemp = new ArrayList<Integer>();
        for(int index=0; index < list.size();index++){
            TModuleEntity tModuleEntity   = (TModuleEntity)list.get(index);
            if(!listtemp.contains(tModuleEntity.getParentId())){
                listtemp.add(tModuleEntity.getParentId());
            }
        }
        for (Integer i : listtemp){
            Map map = new HashMap();
            map.put("parent_id",i);
            parentIdList.add(map);
        }
        return super.execute();
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public List<Integer> getParentIdList() {
        return parentIdList;
    }
    public void setParentIdList(List<Integer> parentIdList) {
        this.parentIdList = parentIdList;
    }
}
