package com.xyf.boot.domain.base;

import java.util.List;

/**
 * 返回列表Json对象模板
 * 
 * @author xiyifeng
 * @date 2016-5-25
 */
@SuppressWarnings("rawtypes")
public class JsonResult {
	// 总记录数
	private int total;

	// 记录对象
	private List rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

}
