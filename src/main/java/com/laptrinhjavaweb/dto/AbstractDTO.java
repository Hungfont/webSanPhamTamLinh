package com.laptrinhjavaweb.dto;
import java.util.ArrayList;
import java.util.List;

public class AbstractDTO<T> {
	
	private Long id;
	private long[] ids;
	private List<T> listResult = new ArrayList<>();
	private String sortName;
	private String sortBy;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long[] getIds() {
		return ids;
	}
	public void setIds(long[] ids) {
		this.ids = ids;
	}
	public List<T> getListResult() {
		return listResult;
	}
	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
	
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

}