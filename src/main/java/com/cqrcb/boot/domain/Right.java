/**
* 
* Right.java
* Copyright(c) 2015-2020 
* All Rights reserved. 
* -----------------------------------
* 2016-05-30creadted 
* @Auther xiyifeng
*/
package com.cqrcb.boot.domain;

import com.cqrcb.boot.domain.page.PageBase;

public class Right extends PageBase {
    /**
     * 角色代码
     */
    private Integer rightId;

    /**
     * 角色名称
     */
    private String rightName;

    /**
     * 上级目录代码(�?时，表示主目�?
     */
    private Integer superRightId;

    /**
     * 父节点名�?
     */
    private String superRightName;

    /**
     * 顺序�?
     */
    private Integer sort;

    /**
     * 权限类型(1-目录 2-交易)
     */
    private String rightType;

    /**
     * 目录显示图标
     */
    private String iconCls;

    /**
     * URL连接
     */
    private String url;

    /**
     * 状�?
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建�?
     */
    private String creater;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改�?
     */
    private String modifyer;

    /**
     * 修改时间
     */
    private String modifyTime;

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName == null ? null : rightName.trim();
    }

    public Integer getSuperRightId() {
        return superRightId;
    }

    public void setSuperRightId(Integer superRightId) {
        this.superRightId = superRightId;
    }

    public String getSuperRightName() {
        return superRightName;
    }

    public void setSuperRightName(String superRightName) {
        this.superRightName = superRightName == null ? null : superRightName.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRightType() {
        return rightType;
    }

    public void setRightType(String rightType) {
        this.rightType = rightType == null ? null : rightType.trim();
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls == null ? null : iconCls.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getModifyer() {
        return modifyer;
    }

    public void setModifyer(String modifyer) {
        this.modifyer = modifyer == null ? null : modifyer.trim();
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }
}