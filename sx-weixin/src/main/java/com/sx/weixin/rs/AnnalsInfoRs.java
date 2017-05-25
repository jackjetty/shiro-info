package com.sx.weixin.rs;

import java.util.List;

import com.github.pagehelper.PageInfo; 
import com.sx.weixin.dto.AnnalsDto;
import com.sx.weixin.model.AnnalsModel;

public class AnnalsInfoRs extends BaseRs{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7614535329114701391L;
	
	private  PageInfo<AnnalsModel> pageinfo;
	private  List<AnnalsDto> dtolist;
	public PageInfo<AnnalsModel> getPageinfo() {
		return pageinfo;
	}
	public void setPageinfo(PageInfo<AnnalsModel> pageinfo) {
		this.pageinfo = pageinfo;
	}
	public List<AnnalsDto> getDtolist() {
		return dtolist;
	}
	public void setDtolist(List<AnnalsDto> dtolist) {
		this.dtolist = dtolist;
	}
	
	
	
}
