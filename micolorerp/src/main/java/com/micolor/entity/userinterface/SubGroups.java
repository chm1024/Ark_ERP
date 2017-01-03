
package com.micolor.entity.userinterface;


import javax.persistence.*;

/**
 * subgroups(XX表)
 */
@Entity
@Table(name="subgroups")
@IdClass(value = SubGroupsId.class)
public class SubGroups{

    @Id
    @Column(name = "SUBGRP_NO")
    private Long subgroupNO;

/**
* 未知
*/
@Id
@Column(name="GRP_NO",length=3)
private Long grpNo;

/**
* 未知
*/
@Column(name="NAME",nullable=false, length=30)
private String name;

/**
* 未知
*/
@Column(name="USR",nullable=false, length=8)
private String usr;

/**
* 未知
*/
@Column(name="TYPE",length=2)
private Long type;

/**
* 未知
*/
@Column(name="STOCK_CONTROL",nullable=false, length=1)
private Long stockControl;

/**
* 未知
*/
@Column(name="NBR_ITEM_NO",length=5)
private Long nbrItemNo;

/**
* 未知
*/
@Column(name="BUY_VAT_NO",length=1)
private Long buyVatNo;

/**
* 未知
*/
@Column(name="SELL_VAT_NO",length=1)
private Long sellVatNo;

/**
* 未知
*/
@Column(name="DIVISION_NO",length=1)
private Long divisionNo;

/**
* 未知
*/
@Column(name="FN_COMPANY",nullable=false, length=1)
private Long fnCompany;

/**
* 未知
*/
@Column(name="SEASON",nullable=false, length=1)
private Long season;

/**
* 未知
*/
@Column(name="SECTION_NO",length=2)
private Long sectionNo;

/**
* 未知
*/
@Column(name="TEMPERATURE",length=1)
private Long temperature;

    public Long getSubgroupNO() {
        return subgroupNO;
    }

    public void setSubgroupNO(Long subgroupNO) {
        this.subgroupNO = subgroupNO;
    }

    /**
* @param grpNo the grpNo to set
*/
public void setGrpNo(Long grpNo){
this.grpNo = grpNo;
}

/**
* @return the grpNo
*/
public Long getGrpNo(){
return this.grpNo;
}

/**
* @param name the name to set
*/
public void setName(String name){
this.name = name;
}

/**
* @return the name
*/
public String getName(){
return this.name;
}

/**
* @param usr the usr to set
*/
public void setUsr(String usr){
this.usr = usr;
}

/**
* @return the usr
*/
public String getUsr(){
return this.usr;
}

/**
* @param type the type to set
*/
public void setType(Long type){
this.type = type;
}

/**
* @return the type
*/
public Long getType(){
return this.type;
}

/**
* @param stockControl the stockControl to set
*/
public void setStockControl(Long stockControl){
this.stockControl = stockControl;
}

/**
* @return the stockControl
*/
public Long getStockControl(){
return this.stockControl;
}

/**
* @param nbrItemNo the nbrItemNo to set
*/
public void setNbrItemNo(Long nbrItemNo){
this.nbrItemNo = nbrItemNo;
}

/**
* @return the nbrItemNo
*/
public Long getNbrItemNo(){
return this.nbrItemNo;
}

/**
* @param buyVatNo the buyVatNo to set
*/
public void setBuyVatNo(Long buyVatNo){
this.buyVatNo = buyVatNo;
}

/**
* @return the buyVatNo
*/
public Long getBuyVatNo(){
return this.buyVatNo;
}

/**
* @param sellVatNo the sellVatNo to set
*/
public void setSellVatNo(Long sellVatNo){
this.sellVatNo = sellVatNo;
}

/**
* @return the sellVatNo
*/
public Long getSellVatNo(){
return this.sellVatNo;
}

/**
* @param divisionNo the divisionNo to set
*/
public void setDivisionNo(Long divisionNo){
this.divisionNo = divisionNo;
}

/**
* @return the divisionNo
*/
public Long getDivisionNo(){
return this.divisionNo;
}

/**
* @param fnCompany the fnCompany to set
*/
public void setFnCompany(Long fnCompany){
this.fnCompany = fnCompany;
}

/**
* @return the fnCompany
*/
public Long getFnCompany(){
return this.fnCompany;
}

/**
* @param season the season to set
*/
public void setSeason(Long season){
this.season = season;
}

/**
* @return the season
*/
public Long getSeason(){
return this.season;
}

/**
* @param sectionNo the sectionNo to set
*/
public void setSectionNo(Long sectionNo){
this.sectionNo = sectionNo;
}

/**
* @return the sectionNo
*/
public Long getSectionNo(){
return this.sectionNo;
}

/**
* @param temperature the temperature to set
*/
public void setTemperature(Long temperature){
this.temperature = temperature;
}

/**
* @return the temperature
*/
public Long getTemperature(){
return this.temperature;
}
}
