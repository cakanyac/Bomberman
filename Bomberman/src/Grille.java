
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Grille {
	private int[][] grille = new int[13][19];
	private Image image_vide;
	private Image image_obstacle_1;
	private Image image_obstacle_2;

	public Grille() throws SlickException {

		image_vide = new Image("images/vide.png");
		image_obstacle_1 = new Image("images/obstacle_destructible.png");
		image_vide = new Image("images/obstacle_indestructible.png");

		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 19; j++) {

				if (i == 0 || i == 12 || j == 0 || j == 18) {
					grille[i][j] = 2;
				} else if (i % 2 == 0 && j % 2 == 0) {
					grille[i][j] = 2;
				} else if ((i == 1 && j == 1) || (i == 1 && j == 2) || (i == 2 && j == 1) || (i == 10 && j == 17)
						|| (i == 11 && j == 17) || (i == 11 && j == 16)) {
					grille[i][j] = 0;
				} else {
					int rand = (int) (Math.random() * 2);

					if (rand == 0) {
						grille[i][j] = 0;
					} else {
						grille[i][j] = 1;
					}
				}

			}
		}

	}

	public void dessiner(Graphics g) {
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 19; j++) {
				
				int x = 30*j;
				int y = 30*i;

				if (grille[i][j] == 0)
					g.drawImage(image_vide, (int)x, (int)y);
				else if (grille[i][j] == 1)
					g.drawImage(image_obstacle_1, (int)x, (int)y);
				else
					g.drawImage(image_obstacle_2, (int)x, (int)y);
			}
		
		}

	}

	public int typeCase(int x, int y) {
		if (x >= 0 && x < 13 && y >= 0 && y < 19)
			return grille[x][y];
		else
			return -1;
	}
	
	public void detruireCase(int x, int y) {
		if (x >= 0 && x < 13 && y >= 0 && y < 19) {
			if(grille[x][y]==1)
				grille[x][y]=0;
		}
	}

}
