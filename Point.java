package me.psrcek.triangleChallenge;

import java.io.Serializable;

public class Point implements Serializable {
	private static final long serialVersionUID = 1L;
	public final int x, y, z;
	
	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public String toString() {
		return "X: " + x + " Y: " + y + " Z: " + z;
	}
}
