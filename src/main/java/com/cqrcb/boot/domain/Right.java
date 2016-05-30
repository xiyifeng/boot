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
    private Integer right_id;

    /**
     * 角色名称
     */
    private String right_name;

    /**
     * 上级目录代码(�?时，表示主目�?
     */
    private Integer super_right_id;

    /**
     * 父节点名�?
     */
    private String super_right_name;

    /**
     * 顺序�?
     */
    private Integer sort;

    /**
     * 权限类型(1-目录 2-交易)
     */
    private String right_type;

    /**
     * 目录显示图标
     */
    private String icon_cls;

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
    private String create_time;

    /**
     * 修改�?
     */
    private String modifyer;

    /**
     * 修改时间
     */
    private String modify_time;

    public Integer getRight_id() {
        return right_id;
    }

    public void setRight_id(Integer right_id) {
        this.right_id = right_id;
    }

    public String getRight_name() {
        return right_name;
    }

    public void setRight_name(String right_name) {
        this.right_name = right_name == null ? null : right_name.trim();
    }

    public Integer getSuper_right_id() {
        return super_right_id;
    }

    public void setSuper_right_id(Integer super_right_id) {
        this.super_right_id = super_right_id;
    }

    public String getSuper_right_name() {
        return super_right_name;
    }

    public void setSuper_right_name(String super_right_name) {
        this.super_right_name = super_right_name == null ? null : super_right_name.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRight_type() {
        return right_type;
    }

    public void setRight_type(String right_type) {
        this.right_type = right_type == null ? null : right_type.trim();
    }

    public String getIcon_cls() {
        return icon_cls;
    }

    public void setIcon_cls(String icon_cls) {
        this.icon_cls = icon_cls == null ? null : icon_cls.trim();
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

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time == null ? null : create_time.trim();
    }

    public String getModifyer() {
        return modifyer;
    }

    public void setModifyer(String modifyer) {
        this.modifyer = modifyer == null ? null : modifyer.trim();
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time == null ? null : modify_time.trim();
    }
}