package me.psrcek.triangleChallenge;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Triangle {
	public Point p1, p2, p3;

	public Triangle(Point p1, Point p2, Point p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public BufferedImage getImage() {
		BufferedImage bI = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		
		double pqxdiff = 0, pqydiff = 0, prxdiff = 0, prydiff = 0, qrxdiff = 0, qrydiff = 0;
		double pqm, prm, qrm;
		double[] lefts = new double[600], rights = new double[600];

		Point p, q, r, temppoint;

		// init array to 0

		for (int i = 0; i < 400; i++) {
			lefts[i] = 0;
			rights[i] = 0;
		}

		// sort points by value

		if (p1.y > p2.y) {
			temppoint = p1;
			p1 = p2;
			p2 = temppoint;
		}
		
		if (p1.y > p3.y) {
			temppoint = p1;
			p1 = p3;
			p3 = temppoint;
		}
		
		if (p2.y > p3.y) {
			temppoint = p2;
			p2 = p3;
			p3 = temppoint;
		}

		// map points to p, q and r

		p = p1;
		q = p2;
		r = p3;

		// Now let's calculate pqm
		// m is the slope, how much x changes when you ++ y

		if (p.x < q.x) {
			pqxdiff = q.x - p.x;
		}
		if (p.x > q.x) {
			pqxdiff = p.x - q.x;
		}
		if (p.x == q.x) {
			pqxdiff = 0;
		}
		if (p.y < q.y) {
			pqydiff = q.y - p.y;
		}
		if (p.y > q.y) {
			pqydiff = p.y - q.y;
		}
		if (p.y == q.y) {
			pqydiff = 0.01;
		}
		pqm = pqxdiff / pqydiff;

		// pqm (PQ slope) has been calculated.
		// Now let's do the arrays from P to Q.

		lefts[q.y] = q.x;
		double x = q.x;

		for (int y = q.y + 1; y != p.y; y = y - 1) {
			if (p.x > q.x) {
				x = x + pqm;
				lefts[y] = x;
				rights[y] = x;
			}

			if (p.x < q.x) {
				x = x - pqm;
				lefts[y] = x;
				rights[y] = x;
			}

			if (p.x == q.x) {
				lefts[y] = x;
				rights[y] = x;
			}
		}

		// Arrays from p to q have been calculated

		// Now we do the arrays from p to r
		// Let's calculate prm
		// m is the slope, how much x changes when you ++ y

		if (p.x < r.x) {
			prxdiff = r.x - p.x;
		}
		if (p.x > r.x) {
			prxdiff = p.x - r.x;
		}
		if (p.x == r.x) {
			prxdiff = 0;
		}
		if (p.y < r.y) {
			prydiff = r.y - p.y;
		}
		if (p.y > r.y) {
			prydiff = p.y - r.y;
		}
		if (p.y == r.y) {
			prydiff = 0.01;
		}
		prm = prxdiff / prydiff;

		// prm (PR slope) has been calculated.
		// Now let's do the arrays from P to R.

		rights[p.y] = p.x;
		x = p.x;

		for (int y = p.y + 1; y != r.y; y = y + 1) {
			if (p.x < r.x) {
				x = x + prm;
				
				if (x < lefts[y] || lefts[y] == 0) {
					lefts[y] = x;
				}
				
				if (x > rights[y] || rights[y] == 0) {
					rights[y] = x;
				}
			}
			
			if (p.x > r.x) {
				x = x - prm;
				
				if (x < lefts[y] || lefts[y] == 0) {
					lefts[y] = x;
				}
				
				if (x > rights[y] || rights[y] == 0) {
					rights[y] = x;
				}
			}
			
			if (p.x == r.x) {
				if (x < lefts[y] || lefts[y] == 0) {
					lefts[y] = x;
				}
				
				if (x > rights[y] || rights[y] == 0) {
					rights[y] = x;
				}
			}
		}

		// Arrays from p to r have been calculated

		// Now we do the arrays from q to r
		// Let's calculate qrm
		// m is the slope, how much x changes when you ++ y

		if (q.x < r.x) {
			qrxdiff = r.x - q.x;
		}
		
		if (q.x > r.x) {
			qrxdiff = q.x - r.x;
		}
		
		if (q.x == r.x) {
			qrxdiff = 0;
		}
		
		if (q.y < r.y) {
			qrydiff = r.y - q.y;
		}
		
		if (q.y > r.y) {
			qrydiff = q.y - r.y;
		}
		
		if (q.y == r.y) {
			qrydiff = 0.01;
		}
		qrm = qrxdiff / qrydiff;

		// qrm (QR slope) has been calculated.
		// Now let's do the arrays from Q to R.

		x = q.x;

		for (int y = q.y + 1; y < r.y; y = y + 1) {
			if (q.x < r.x) {
				x = x + qrm;
				
				if (x < lefts[y] || lefts[y] == 0) {
					lefts[y] = x;
				}
				
				if (x > rights[y] || rights[y] == 0) {
					rights[y] = x;
				}
			}
			
			if (q.x > r.x) {
				x = x - qrm;
				
				if (x < lefts[y] || lefts[y] == 0) {
					lefts[y] = x;
				}
				
				if (x > rights[y] || rights[y] == 0) {
					rights[y] = x;
				}
			}
			
			if (q.x == r.x) {
				if (x < lefts[y] || lefts[y] == 0) {
					lefts[y] = x;
				}
				
				if (x > rights[y] || rights[y] == 0) {
					rights[y] = x;
				}
			}
		}

		// Arrays from q to r have been calculated
		// Time to actually draw the polygon!

		for (int y = p.y + 1; y != r.y - 1; y = y + 1) {
			for (x = lefts[y]; x <= rights[y]; x = x + 1) {
				bI.setRGB((int)x, y, new Color(0, 255, 0).getRGB());
			}
		}

		return bI;
	}
}
