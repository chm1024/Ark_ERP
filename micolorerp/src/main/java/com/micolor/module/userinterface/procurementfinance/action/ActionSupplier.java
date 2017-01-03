package com.micolor.module.userinterface.procurementfinance.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.xmlresolve.ResolveObjectToXML;
import com.micolor.common.xmlresolve.XMLLayout;
import com.micolor.entity.userinterface.Supplier;
import com.micolor.entity.userinterface.SupplierOds;
import com.micolor.module.userinterface.procurementfinance.service.SupplierSerivce;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/userinterface/procurementfinance")
public class ActionSupplier extends BaseActionSupport {
    @Resource
    private SupplierSerivce supplierSerivce;
    @Resource
    private ResolveObjectToXML resolve;
    @Action(
            value = "supplier",
            results = {
                    @Result(name = "success",location = "json")
            }
    )

    public String execute() {
        String returnXML="";
        XMLLayout layout=new XMLLayout("Supplier","SupplierHeader","SupplierItem",new String[]{"supplierCode","nameCn","taxRegistNo","syncflag"},new String[]{"supplierCode"});
        List<Supplier> suppliers = supplierSerivce.getList();
        for(Supplier supplier:suppliers){
            returnXML=resolve.objectToXmlInclude(supplier,layout,true);
        }
        return returnXML;
    }
}
