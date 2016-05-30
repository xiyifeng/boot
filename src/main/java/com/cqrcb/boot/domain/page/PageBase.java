package com.cqrcb.boot.domain.page;

import java.io.Serializable;

/**
 * 分页基类
 * 
 * @author xiyifeng
 * @date 2016-5-25
 */
public class PageBase implements Serializable {

	private static final long serialVersionUID = 4330399132946718352L;

	// 每页显示的记录数
	private int rows;
	// 当前第几页
	private int page;

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	// 起始记录
	public int getStartRow() {
		return (page - 1) * rows;
	}

	@Override
	public String toString() {
		return "PageBase [rows=" + rows + ", page=" + page + ", startRow="
				+ getStartRow() + "]";
	}

}
