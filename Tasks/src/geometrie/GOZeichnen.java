package geometrie;

import java.awt.Graphics;

public interface GOZeichnen {
	public void zeichnen(Graphics g, double koef);
	public boolean contains (int x , int y);
}
