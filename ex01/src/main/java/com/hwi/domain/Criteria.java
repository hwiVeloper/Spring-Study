package com.hwi.domain;

public class Criteria {
	private int page;
	private int perPageNum;
	/**
	 * 파라미터 늘어나면 관리가 어려워지기 때문에 클래스로 만들어 관리하는 것이 바람직하
	 */
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if (perPageNum <=0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPage() {
		return page;
	}
	
	// method for MyBatis SQL Mapper -
	public int getPageStart() {
		// 시작 데이터 번호 = (페이지 번호 - 1) * 페이지 당 보여지는 개수
		return (this.page - 1) * perPageNum;
	}
	
	// method for MyBatis SQL Mapper
	public int getPerPageNum() {
		return perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", "
				+ "perPageNum=" + perPageNum + "]";
	}
}
