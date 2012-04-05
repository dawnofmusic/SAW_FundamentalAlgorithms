package de.wsdevel.algorithms.pythagoras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.vecmath.Point2d;

import de.wsdevel.tools.awt.GUIToolkit;

/**
 * Created on 01.01.2008.
 * 
 * for project: Java__Stuff
 * 
 * @author <a href="mailto:sweiss@weissundschmidt.de">Sebastian A. Weiss - Weiss
 *         und Schmidt, Mediale Systeme GbR</a>
 * @version $Author: sweiss $ -- $Revision: 1.1 $ -- $Date: 2009-02-09 13:07:18 $
 * 
 * <br>
 *          (c) 2007, Weiss und Schmidt, Mediale Systeme GbR - All rights
 *          reserved.
 * 
 */
public class PythagorasTree extends JPanel {

    /**
     * {@link double} COMMENT. max. 45° or Math.PI / 4;
     */
    private static final double PHI = Math.PI / 4;

    /**
     * <code>double</code> COMMENT.
     */
    private double tanPhi = Math.tan(PythagorasTree.PHI);

    /**
     * {@link long} COMMENT.
     */
    private static final long serialVersionUID = -4810178057181475082L;

    /**
     * @param g
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(final Graphics g) {
	g.setColor(Color.WHITE);
	g.fillRect(0, 0, getWidth(), getHeight());
	g.setColor(Color.BLUE);
	paintTree(g, new Point2d((210.0d / 500) * getWidth(), (475.0d / 500)
		* getHeight()), new Point2d((290.0d / 500) * getWidth(),
		(475.0d / 500) * getHeight()), 1);
    }

    public final void paintTree(final Graphics g, final Point2d p1,
	    final Point2d p2, final int step) {

	// if (step > 3) {
	// return;
	// }

	double dy = (p1.y - p2.y);
	double dx = (p2.x - p1.x);
	Point2d p3 = new Point2d(p1.x - dy, p1.y - dx);
	Point2d p4 = new Point2d(p2.x - dy, p2.y - dx);

	// g.setColor(Color.BLUE);
	drawLine(g, p1.x, p1.y, p2.x, p2.y);
	drawLine(g, p2.x, p2.y, p4.x, p4.y);
	drawLine(g, p4.x, p4.y, p3.x, p3.y);
	drawLine(g, p1.x, p1.y, p3.x, p3.y);

	// double alpha = (Math.PI / 2) - PHI;
	// if (alpha < 0) {
	// throw new IllegalStateException("phi is bigger than pi/4");
	// }

	Point2d p5 = new Point2d((p3.x + p4.x) / 2 - (dy / 2 * this.tanPhi),
		(p3.y + p4.y) / 2 - (dx / 2 * this.tanPhi));
	// Point2d p5 = new Point2d(p3.x + Math.sin(alpha) * dx, p3.y
	// - Math.cos(alpha) * dx);
	// double distance = p3.distance(p4);
	// Point2d p5 = new Point2d(p3.x + Math.cos(PHI) * dx, p3.y
	// + Math.cos(PHI) * dy);

	// g.setColor(Color.GREEN);
	// drawLine(g, p3.x, p3.y, p5.x, p5.y);
	// drawLine(g, p5.x, p5.y, p4.x, p4.y);

	if ((dx * dx + dy * dy) > 9) {
	    paintTree(g, p3, p5, step + 1);
	    paintTree(g, p5, p4, step + 1);
	}

    }

    /**
     * COMMENT.
     * 
     * @param g
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    private void drawLine(final Graphics g, final double x1, final double y1,
	    final double x2, final double y2) {
	g.drawLine((int) Math.round(x1), (int) Math.round(y1), (int) Math
		.round(x2), (int) Math.round(y2));
    }

    /**
     * COMMENT.
     * 
     * @param args
     */
    public static void main(String[] args) {
	JFrame frame = GUIToolkit.createMainFramOverPanel(new PythagorasTree(),
		new Rectangle(0, 0, 400, 300));
	GUIToolkit.center(frame);
	frame.setVisible(true);
    }

}
//
// $Log: PythagorasTree.java,v $
// Revision 1.1  2009-02-09 13:07:18  sweiss
// *** empty log message ***
//
// Revision 1.1 2008-01-08 16:14:40 sweiss
// *** empty log message ***
//
//
