package com.mygdx.game;

public class Missile{
	boolean isEvil;
	int ix,iy,fx,fy;
	
	//enemy missiles
	public Missile(boolean isEvil,int ix,int iy,int fx,int fy){
		this.isEvil=isEvil;
		this.ix=ix;
		this.iy=iy;
		this.fx=fx;
		this.fy=fy;
	}
	//defense missiles
	public Missile(int ix,int iy,int fx,int fy){
		this.isEvil=false;
		this.ix=ix;
		this.iy=iy;
		this.fx=fx;
		this.fy=fy;
	}
}