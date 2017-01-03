package com.micolor.entity.userinterface;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * Created by liuhx on 2016/11/28 0028.
 */
@Entity
@Table(name="INTERFACE_CONFIG")
public class InterfaceConfig implements java.io.Serializable{

    @javax.persistence.Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "INTERFACE_NAME")
    private String interfaceName;

    @Column(name = "INTERFACE_CODE")
    private String interfaceCode;

    @Column(name = "INTERFACE_URL")
    private String interfaceUrl;

    @Column(name = "INTERFACE_ACTION")
    private String interfaceAction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    public String getInterfaceAction() {
        return interfaceAction;
    }

    public void setInterfaceAction(String interfaceAction) {
        this.interfaceAction = interfaceAction;
    }
}
