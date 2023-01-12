import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bombe {
	private int x,y;
	private Image image;
	private int temps;
	
	public Bombe(int x, int y) throws SlickException {
	  if(x>=0 && y<12 && y>=0 && y<18) {
		  this.x = x;
			this.y = y;  
	  }
	  
	  temps = 0;
	  image = new Image("images/bombe.png");
		
	}
	
	public void dessiner(Graphics g) {
		g.drawImage(image, x*30, y*30);
	}
	
	public boolean doitExploser(int delta) {
		
         temps += delta;
		
		if(temps>=2000) {
			return true;
        }
		else
			return false;
	}
	
	public void exploser(Grille grille) {
		 grille.detruireCase(x-1, y);
		 grille.detruireCase(x+1, y);
		 grille.detruireCase(x, y-1);
		 grille.detruireCase(x, y+1);
	}

	
	public boolean exploser(Personnage p) {
		if(p.aCoter(x, y))
			return true;
		else
			return false;
    }

}
