package com.sx.weixin.ot; 
public class PointOt{
	private float pointX;
	private float pointY;
	public PointOt(){
		
	}
	public float getPointX() {
		return pointX;
	}
	public void setPointX(float pointX) {
		this.pointX = pointX;
	}
	public float getPointY() {
		return pointY;
	}
	public void setPointY(float pointY) {
		this.pointY = pointY;
	}
	public PointOt(double doubleY,double doubleX){
		this.pointX=(float) doubleX;
		this.pointY=(float) doubleY;
	}
	
}