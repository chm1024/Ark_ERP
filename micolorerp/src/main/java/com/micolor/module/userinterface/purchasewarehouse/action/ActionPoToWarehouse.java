package com.micolor.module.userinterface.purchasewarehouse.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.xmlresolve.ResolveObjectToXML;
import com.micolor.common.xmlresolve.XMLLayout;
import com.micolor.entity.userinterface.Po;
import com.micolor.module.userinterface.purchasewarehouse.service.PoToWarehouseSerivce;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;

/**
 * Created by liuhx on 12/11/16.
 * 采购订单同步至仓配系统
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/userinterface/potowarehouse")
public class ActionPoToWarehouse extends BaseActionSupport {
    @Resource
    private PoToWarehouseSerivce poToWarehouseSerivce;

    @Resource
    private ResolveObjectToXML resolve;

    @Action(
            value = "po",
            results = {
                    @Result(name = "success",location = "json")
            }
    )

    public String execute() {
        XMLLayout layout=new XMLLayout("PO","POHeader","POitem",new String[]{"skuCode","skuName"});
        Po poDto = new Po();
        poDto.setPoNo("1");
        Po po=poToWarehouseSerivce.getObject(poDto);
        String returnXML=resolve.objectToXml(po,layout,true);
        return returnXML;
    }


}
