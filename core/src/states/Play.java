package states;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.game.Missile;

import handlers.GameStateManagers;

public class Play extends GameState {
	
	
	public LinkedList<Missile> eMissiles= new LinkedList<Missile>();
	public LinkedList<Missile> fMissiles=new LinkedList<Missile>();
	ShapeRenderer shapeDebugger;
	double height;
	double width;

	public Play(GameStateManagers gsm) {
		super(gsm);
		shapeDebugger=new ShapeRenderer();
	}
	public void create(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		height=screenSize.getHeight();
		width=screenSize.getWidth();
	}
	public void handleInput() {
		
	}
	
	public void update(float dt) {}
	
	public void render() {
		spawnMissiles();
		boolean clicked=Gdx.input.isButtonPressed(Input.Buttons.LEFT)||Gdx.input.isButtonPressed(Input.Buttons.RIGHT);
		if (clicked){
			int x=(int)Gdx.input.getX();
			int y=(int)Gdx.input.getY();
			eMissiles.addLast(new Missile(true,320,0,x,y));
		}
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		Point p;
		if (!fMissiles.isEmpty()){
			for(Missile m:fMissiles){
				if (!m.xy.isEmpty()){
					p=m.xy.remove();
					
					shapeDebugger.begin(ShapeType.Line);
				    shapeDebugger.setColor(1, 1, 1, 1);
					shapeDebugger.line(m.ix,m.iy, p.x, p.y);
					shapeDebugger.end();	
				}
			}	
		}
		if (!eMissiles.isEmpty()){
			for(Missile m:eMissiles){
				if (!m.xy.isEmpty()){
					p=m.xy.remove();
					
					shapeDebugger.begin(ShapeType.Line);
				    shapeDebugger.setColor(1, 1, 1, 1);
					shapeDebugger.line(m.ix,m.iy, p.x, p.y);
					shapeDebugger.end();
				}
			}
		}
		sb.end();
	}
	
	public void dispose() { }
	
	public void spawnMissiles(){
		if (1+(int)(Math.random() * ((60 - 1) + 1))==1){
			int w=1+(int)(Math.random() * ((640 - 1) + 1));
			int x=1+(int)(Math.random() * ((640 - 1) + 1));
			eMissiles.addLast(new Missile(true,w,480,x,0));
			//eMissiles.add(new Missile(true,0,0,320,240));
		}
		
	}

           
	
	
}
