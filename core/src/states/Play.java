package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.mygdx.game.Missile;

import handlers.GameStateManagers;

public class Play extends GameState {
	
	
	public List<Missile> eMissiles= new ArrayList<Missile>();
	public List<Missile> fMissiles=new ArrayList<Missile>();
	ShapeRenderer shapeDebugger;

	public Play(GameStateManagers gsm) {
		super(gsm);
		shapeDebugger=new ShapeRenderer();
	}
	
	public void handleInput() {
		
	}
	
	public void update(float dt) {}
	
	public void render() {
		sb.setProjectionMatrix(cam.combined);
		spawnMissiles();
		Point p;
			for(Missile m:eMissiles){
				if (!m.xy.isEmpty()){
					p=m.xy.remove();
					sb.begin();
					shapeDebugger.begin(ShapeType.Line);
				    shapeDebugger.setColor(1, 1, 1, 1);
					shapeDebugger.line(m.ix,m.iy, p.x, p.y);
					shapeDebugger.end();	
					sb.end();
				}
				
			}
		
	}
	
	public void dispose() {}
	
	public void spawnMissiles(){
		eMissiles.add(new Missile(true,0,0,340,240));
	}
	
	public void DrawLine(Graphics g){
		g.setColor(Color.white);
	}
	
	
	public void clicked(InputEvent event,float x, float y){
		
		int fx=(int)x;
		int fy=(int)y;
		fMissiles.add(new Missile(340/2,240,fx,fy));
	}
           
	
	
}
