package handlers;

import java.util.Stack;

import com.mygdx.game.MissileCommand;

import states.GameState;
import states.Play;
import states.StartMenu;



public class GameStateManagers {
	
	private MissileCommand game;
	
	private Stack<GameState> gameStates;
	
	public static final int PLAY = 912837;
	public static final int STARTMENU = 3158;
	
	public GameStateManagers(MissileCommand game) {
		this.game = game;
		gameStates = new Stack<GameState>();
		pushState(PLAY);
	}
	
	public MissileCommand game() { return game; }
	
	public void update(float dt) {
		gameStates.peek().update(dt);
	}
	
	public void render() {
		gameStates.peek().render();
	}
	
	private GameState getState(int state) {
		if(state == PLAY) return new Play(this);
		if (state == STARTMENU) return new StartMenu(this);
		return null;
	}
	
	public void setState(int state) {
		popState();
		pushState(state);
	}
	
	public void pushState(int state) {
		gameStates.push(getState(state));
	}
	
	public void popState() {
		GameState g = gameStates.pop();
		g.dispose();
	}
	
}










