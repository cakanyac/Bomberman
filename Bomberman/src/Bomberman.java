
import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Bomberman extends BasicGame {

	Grille grille;
	Personnage p;
	ArrayList<Bombe> bombes = new ArrayList<Bombe>();

	public Bomberman(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		grille = new Grille();
		p = new Personnage(1, 1);

	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub

		grille.dessiner(g);

		for (int i = 0; i < bombes.size(); i++) {
			bombes.get(i).dessiner(g);

		}

		p.dessiner(g);

	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stub

		Input inp = gc.getInput();

		if (inp.isKeyPressed(Input.KEY_LEFT))
			p.gauche(grille);
		if (inp.isKeyPressed(Input.KEY_RIGHT))
			p.droite(grille);
		if (inp.isKeyPressed(Input.KEY_UP))
			p.haut(grille);
		if (inp.isKeyPressed(Input.KEY_DOWN))
			p.bas(grille);
		
		if(inp.isKeyPressed(Input.KEY_SPACE)) {
			if(bombes.size()<=1)
			bombes.add(new Bombe(p.getX(), p.getY()));
		}
		
		for(int i=0; i<bombes.size(); i++) {
			if(bombes.get(i).doitExploser(delta)) {
				bombes.get(i).exploser(grille);
				if(bombes.get(i).exploser(p)) {
					gc.exit();
				}
				
				bombes.remove(i);
				i--;
			}
		}

	}

	public static void main(String[] args) throws SlickException {
		Bomberman bomberman = new Bomberman("Bomberman");
		AppGameContainer app = new AppGameContainer(bomberman);
		app.setShowFPS(false);
		app.setDisplayMode(19 * 30, 13 * 30, false);
		app.start();

	}

}
