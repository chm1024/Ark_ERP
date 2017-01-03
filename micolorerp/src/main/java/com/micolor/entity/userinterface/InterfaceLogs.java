package com.micolor.entity.userinterface;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by liusi on 2016/12/1.
 * 接口发送和接口 日志记录
 */
@Entity
@Table(name = "interface_logs")
public class InterfaceLogs implements Serializable{

    @javax.persistence.Id
    @Column(name = "ID")
    private String id;

    @Column(name = "INTERFACE_ID")
    private Long interfaceId;

    @Column(name = "INTERACE_NAME")
    private String interfaceName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="etl_date",updatable=false)
    private Date etlDate;

    @Column(name = "STATUS")
    private String status;

    @OneToMany(fetch= FetchType.EAGER,cascade={CascadeType.ALL} )
    @JoinColumn(name="LOG_ID",referencedColumnName = "ID",insertable = false, updatable = false)
    private List<InterfaceLogsErr> interfaceLogsErrs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Long interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Date getEtlDate() {
        return etlDate;
    }

    public void setEtlDate(Date etlDate) {
        this.etlDate = etlDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<InterfaceLogsErr> getInterfaceLogsErrs() {
        return interfaceLogsErrs;
    }

    public void setInterfaceLogsErrs(List<InterfaceLogsErr> interfaceLogsErrs) {
        this.interfaceLogsErrs = interfaceLogsErrs;
    }
}
