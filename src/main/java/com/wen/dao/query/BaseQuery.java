package com.wen.dao.query;

public class BaseQuery {

	/**
	 * 此处为属性说明
	 */
	private int pageNo =1;
	private int pageRows = 20;
	private int page=pageNo-1;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageRows() {
		return pageRows;
	}

	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}	
}
