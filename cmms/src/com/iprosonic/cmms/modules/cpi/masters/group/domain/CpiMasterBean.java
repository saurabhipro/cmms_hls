package com.iprosonic.cmms.modules.cpi.masters.group.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cpimaster")

public class CpiMasterBean {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
    

	
	@Column(name = "typeOfCpi")
	private String typeOfCpi;
    
	
	@Column(name = "sourceOfCpiCd")
	private String sourceOfCpiCd;
    

	@Column(name = "sourceOfCpi")
	private String sourceOfCpi;
	
	@Column(name = "subSourceOfCpiCd")
	private String subSourceOfCpiCd;
    
	@Column(name = "subSourceOfCpi")
	private String subSourceOfCpi;
	
	@Column(name = "groupCd")
	private String groupCd;
	
	@Column(name = "groupName")
	private String groupName;
	
	@Column(name = "categoryCd")
	private String categoryCd;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "subCategoryCd")
	private String subCategoryCd;
	
	@Column(name = "subCategory")
	private String subCategory;
	
    
	@Column(name = "impactToCostumer")
	private String impactToCostumer;
	
	@Column(name = "effectOncostumer")
	private String effectOncostumer;
	
	@Column(name = "whyOpen")
	private String whyOpen;
	
	@Column(name = "subGroupCd")
	private String subGroupCd;
	
	@Column(name = "subGroupName")
	private String subGroupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSubGroupCd() {
        return subGroupCd;
    }

    public void setSubGroupCd(String subGroupCd) {
        this.subGroupCd = subGroupCd;
    }

    public String getSubGroupName() {
        return subGroupName;
    }

    public void setSubGroupName(String subGroupName) {
        this.subGroupName = subGroupName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryCd() {
        return categoryCd;
    }

    public void setCategoryCd(String categoryCd) {
        this.categoryCd = categoryCd;
    }

    public String getEffectOncostumer() {
        return effectOncostumer;
    }

    public void setEffectOncostumer(String effectOncostumer) {
        this.effectOncostumer = effectOncostumer;
    }

    public String getGroupCd() {
        return groupCd;
    }

    public void setGroupCd(String groupCd) {
        this.groupCd = groupCd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImpactToCostumer() {
        return impactToCostumer;
    }

    public void setImpactToCostumer(String impactToCostumer) {
        this.impactToCostumer = impactToCostumer;
    }

    public String getSourceOfCpi() {
        return sourceOfCpi;
    }

    public void setSourceOfCpi(String sourceOfCpi) {
        this.sourceOfCpi = sourceOfCpi;
    }

    public String getSourceOfCpiCd() {
        return sourceOfCpiCd;
    }

    public void setSourceOfCpiCd(String sourceOfCpiCd) {
        this.sourceOfCpiCd = sourceOfCpiCd;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getSubCategoryCd() {
        return subCategoryCd;
    }

    public void setSubCategoryCd(String subCategoryCd) {
        this.subCategoryCd = subCategoryCd;
    }

    public String getSubSourceOfCpi() {
        return subSourceOfCpi;
    }

    public void setSubSourceOfCpi(String subSourceOfCpi) {
        this.subSourceOfCpi = subSourceOfCpi;
    }

    public String getSubSourceOfCpiCd() {
        return subSourceOfCpiCd;
    }

    public void setSubSourceOfCpiCd(String subSourceOfCpiCd) {
        this.subSourceOfCpiCd = subSourceOfCpiCd;
    }

    public String getTypeOfCpi() {
        return typeOfCpi;
    }

    public void setTypeOfCpi(String typeOfCpi) {
        this.typeOfCpi = typeOfCpi;
    }

    public String getWhyOpen() {
        return whyOpen;
    }

    public void setWhyOpen(String whyOpen) {
        this.whyOpen = whyOpen;
    }
}


