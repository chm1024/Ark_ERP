
package com.micolor.entity.userinterface;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * subgroups(XX表)
 */
public class SubGroupsId implements Serializable{

    private Long subgroupNO;

    private Long grpNo;

    public SubGroupsId() {
    }

    public SubGroupsId(Long subgroupNO, Long grpNo) {
        this.subgroupNO = subgroupNO;
        this.grpNo = grpNo;
    }

    public Long getSubgroupNO() {
        return subgroupNO;
    }

    public void setSubgroupNO(Long subgroupNO) {
        this.subgroupNO = subgroupNO;
    }

    public Long getGrpNo() {
        return grpNo;
    }

    public void setGrpNo(Long grpNo) {
        this.grpNo = grpNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubGroupsId that = (SubGroupsId) o;

        if (!subgroupNO.equals(that.subgroupNO)) return false;
        return grpNo.equals(that.grpNo);

    }

    @Override
    public int hashCode() {
        int result = subgroupNO.hashCode();
        result = 31 * result + grpNo.hashCode();
        return result;
    }
}
