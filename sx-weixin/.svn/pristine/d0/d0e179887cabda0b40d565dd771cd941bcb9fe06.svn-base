package com.sx.weixin.dto; 
import java.util.Date;

import com.sx.weixin.model.CustResModel;
import com.sx.weixin.util.CommonUtil;
import com.sx.weixin.util.DateUtil;
  
 
public class CustResDto   extends BaseDto<CustResModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7553568960298730480L;
	
	
	private String custresid;

    private String processid;

    private String recordno;

    private String custrestime;

    private String openid;

    private String custresponser;

    private String custrestype;

    private String custrescontent;
    
    
    
    
    public String getCustresid() {
		return custresid;
	}

	public void setCustresid(String custresid) {
		this.custresid = custresid;
	}

	public String getProcessid() {
		return processid;
	}

	public void setProcessid(String processid) {
		this.processid = processid;
	}

	public String getRecordno() {
		return recordno;
	}

	public void setRecordno(String recordno) {
		this.recordno = recordno;
	}

	public String getCustrestime() {
		return custrestime;
	}

	public void setCustrestime(String custrestime) {
		this.custrestime = custrestime;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getCustresponser() {
		return custresponser;
	}

	public void setCustresponser(String custresponser) {
		this.custresponser = custresponser;
	}

	public String getCustrestype() {
		return custrestype;
	}

	public void setCustrestype(String custrestype) {
		this.custrestype = custrestype;
	}

	public String getCustrescontent() {
		return custrescontent;
	}

	public void setCustrescontent(String custrescontent) {
		this.custrescontent = custrescontent;
	}

	@Override
	public void buildDto(CustResModel custResModel) {
		
		this.custresid=CommonUtil.trim(custResModel.getCustresid());
		this.processid=CommonUtil.trim(custResModel.getProcessid());
		this.recordno=CommonUtil.trim(custResModel.getRecordno()); 
		this.custrestime=DateUtil.getDateForm(custResModel.getCustrestime()); 
		
		this.openid=CommonUtil.trim(custResModel.getOpenid());
		this.custresponser=CommonUtil.trim(custResModel.getCustresponser());
		this.custrestype=CommonUtil.trim(custResModel.getCustrestype());
		this.custrescontent=CommonUtil.trim(custResModel.getCustrescontent());
		 
	}

	@Override
	public CustResModel vertModel() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
	
}