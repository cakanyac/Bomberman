import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Personnage {
	private int x, y;
	private Image image;

	public Personnage(int x, int y) throws SlickException {

		if (x >= 0 && x <= 12 && y >= 0 && y <= 18) {
			this.x = x;
			this.y = y;
		}

		image = new Image("images/bomberman.png");

	}

	public void gauche(Grille grille) {
		if (y >= 1 && grille.typeCase(x, y - 1) == 0) {
			y -= 1;

		}
	}

	public void droite(Grille grille) {
		if (y <= 17 && grille.typeCase(x, y + 1) == 0) {
			y += 1;

		}
	}

	public void haut(Grille grille) {
		if (y >= 1 && grille.typeCase(x - 1, y) == 0) {
			x -= 1;

		}
	}

	public void bas(Grille grille) {
		if (y <= 11 && grille.typeCase(x + 1, y) == 0) {
			x += 1;

		}
	}

	public void dessiner(Graphics g) {
		g.drawImage(image, x * 30, y * 30 - 8);
	}

	public boolean aCoter(int x, int y) {
		if (x >= 0 && x < 12 && y >= 0 && y < 18) {
			if (this.x == x && this.y == y - 1)
				return true;
			else if (this.x == x && this.y == y + 1)
				return true;
			else if (this.x == x - 1 && this.y == y)
				return true;
			else if (this.x == x + 1 && this.y == y)
				return true;
			else if(this.x==x && this.y ==y)
				return true;
			else 
				return false;
			
		}
		else
			return false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if(x>=0 && x<13)
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if(y>=0 && y<19)
		this.y = y;
	}

	

}
