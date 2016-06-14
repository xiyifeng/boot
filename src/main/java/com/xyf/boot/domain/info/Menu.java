package com.xyf.boot.domain.info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单项
 * 
 * @author xiyifeng
 * @date 2016年6月14日
 */
public class Menu implements Serializable {

	private static final long serialVersionUID = -629740336475213408L;

	private String id;
	private String pid;
	private String name;
	private String iconCls;
	private String url;
	private List<Menu> child = new ArrayList<Menu>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Menu> getChild() {
		return child;
	}

	public void setChild(List<Menu> child) {
		this.child = child;
	}

}
