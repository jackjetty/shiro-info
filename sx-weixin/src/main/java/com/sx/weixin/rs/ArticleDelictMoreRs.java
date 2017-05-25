package com.sx.weixin.rs;
import java.util.List;

import com.github.pagehelper.PageInfo; 
import com.sx.weixin.dto.ArticleDelictDto;
import com.sx.weixin.model.ArticleDelictModel;

public class ArticleDelictMoreRs extends BaseRs{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7614535339114991391L;
	
	private  PageInfo<ArticleDelictModel> pageinfo;
	private  List<ArticleDelictDto> dtolist;
	public PageInfo<ArticleDelictModel> getPageinfo() {
		return pageinfo;
	}
	public void setPageinfo(PageInfo<ArticleDelictModel> pageinfo) {
		this.pageinfo = pageinfo;
	}
	public List<ArticleDelictDto> getDtolist() {
		return dtolist;
	}
	public void setDtolist(List<ArticleDelictDto> dtolist) {
		this.dtolist = dtolist;
	}
	
}