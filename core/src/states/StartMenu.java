package states;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

import handlers.GameStateManagers;

public class StartMenu extends GameState {
	
	private BitmapFont font = new BitmapFont();
	
	public StartMenu(GameStateManagers gsm) {
		super(gsm);
	}
	
	public void handleInput() {}
	
	public void update(float dt) {}
	
	public void render() {
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		font.draw(sb, "play state", 100, 100);
		sb.end();
	}
	
	public void dispose() {}
	
}
