package com.mygdx.game;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class Missile{
	public Queue<Point> xy= new LinkedList<Point>();;
	boolean isEvil;
	public int ix,iy,fx,fy;
	Point p;
	//enemy missiles
	public Missile(boolean isEvil,int ix,int iy,int fx,int fy){
		this.isEvil=isEvil;
		this.ix=ix;
		this.iy=iy;
		this.fx=fx;
		this.fy=fy;
		this.getTraj();
	}
	//defense missiles
	public Missile(int ix,int iy,int fx,int fy){
		this.isEvil=false;
		this.ix=ix;
		this.iy=iy;
		this.fx=fx;
		this.fy=fy;
		this.getTraj();
	}
	
	public void getTraj(){
		double ux,uy,length,i;
		length=Math.sqrt((this.fx-this.ix)^2+(this.fy-this.iy)^2);
		ux=(this.fx-this.ix)/length;
		uy=(this.fy-this.iy)/length;
		Point p;
		for(i=1;i<=length*1.5;i++){
			p=new Point((int)(ix+ux*i),(int)(iy+uy*i));
			xy.add(p);
		}
	}
	
}