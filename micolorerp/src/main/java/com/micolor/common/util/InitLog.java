package com.micolor.common.util;

import com.micolor.entity.userinterface.InterfaceLogs;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**初始化日志类
 * Created by Administrator on 2016-12-15.
 */
@Component
public class InitLog {
    /**
     * 初始化日志属性
     * @param interfaceId  接口ID
     * @param interfaceName 接口名称
     * @param status  状态
     * @return
     */
    public InterfaceLogs initInterfaceLogs(Long interfaceId,String interfaceName,String status){
        InterfaceLogs interfaceLogs = new InterfaceLogs();
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        uuid = uuid.replaceAll("-", "");
        interfaceLogs.setId(uuid);
        interfaceLogs.setInterfaceId(interfaceId);
        //创建时间
        Date dt=new Date();
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            interfaceLogs.setEtlDate(time.parse(time.format(dt)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        interfaceLogs.setInterfaceName(interfaceName);
        interfaceLogs.setStatus(status);
        return interfaceLogs;
    }


    /**
     * 初始化日志属性 指定主键
     * @param id  主键ID
     * @param interfaceId  接口ID
     * @param interfaceName 接口名称
     * @param status  状态
     * @return
     */
    public InterfaceLogs initInterfaceLogs(String id,Long interfaceId,String interfaceName,String status){
        InterfaceLogs interfaceLogs = new InterfaceLogs();
        interfaceLogs.setId(id);
        interfaceLogs.setInterfaceId(interfaceId);
        //创建时间
        Date dt=new Date();
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            interfaceLogs.setEtlDate(time.parse(time.format(dt)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        interfaceLogs.setInterfaceName(interfaceName);
        interfaceLogs.setStatus(status);
        return interfaceLogs;
    }
}
