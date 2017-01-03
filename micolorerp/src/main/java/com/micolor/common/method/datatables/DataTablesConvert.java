package com.micolor.common.method.datatables;

import com.micolor.common.entities.datatables.Columns;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.common.entities.datatables.Order;
import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName:com.micolor.common.entities.DataTablesConvert.
 * Discription: TODO 填写类描述
 * Author: geyupeng.
 * DateTime 16/3/23.
 */
public class DataTablesConvert extends DefaultTypeConverter {

    public Object convertValue(Map context, Object value, Class toType){

        String json = ((String[])value).length > 0 ? json = ((String[])value)[0] : "";

        System.out.println("|-00-|"+json);

        DataTables dt = null;

        if(toType == DataTables.class){

            JSONObject jsonobj = JSONObject.fromObject(json);

            Map<String, Class> clsMap = new HashMap<String, Class>();

            clsMap.put("columns", Columns.class);

            clsMap.put("order", Order.class);

            dt = (DataTables) JSONObject.toBean(jsonobj,DataTables.class,clsMap);

            System.out.println("|-01-|"+dt.toString());
        }

        return dt;
    }
}
