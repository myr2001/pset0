/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package turtle;

import java.util.List;
import java.util.ArrayList;

public class TurtleSoup {

	/**
	 * Draw a square.
	 * 
	 * @param turtle     the turtle context
	 * @param sideLength length of each side
	 */
	public static void drawSquare(Turtle turtle, int sideLength) {
		for (int i = 0; i < 4; i++) {
			turtle.forward(sideLength);
			turtle.turn(90);
		}
	}

	/**
	 * Determine inside angles of a regular polygon.
	 * 
	 * There is a simple formula for calculating the inside angles of a polygon; you
	 * should derive it and use it here.
	 * 
	 * @param sides number of sides, where sides must be > 2
	 * @return angle in degrees, where 0 <= angle < 360
	 */
	public static double calculateRegularPolygonAngle(int sides) {
		// Sinem
		double angle = (double) (sides - 2) * 180 / sides;
		return angle;
		// throw new RuntimeException("implement me!");
	}

	/**
	 * Determine number of sides given the size of interior angles of a regular
	 * polygon.
	 * 
	 * There is a simple formula for this; you should derive it and use it here.
	 * Make sure you *properly round* the answer before you return it (see
	 * java.lang.Math). HINT: it is easier if you think about the exterior angles.
	 * 
	 * @param angle size of interior angles in degrees, where 0 < angle < 180
	 * @return the integer number of sides
	 */
	public static int calculatePolygonSidesFromAngle(double angle) {
		// Burak
		int sides;
		sides = (int) (360 / (180 - Math.round(angle)));
		return sides;
	}

	/**
	 * Given the number of sides, draw a regular polygon.
	 * 
	 * (0,0) is the lower-left corner of the polygon; use only right-hand turns to
	 * draw.
	 * 
	 * @param turtle     the turtle context
	 * @param sides      number of sides of the polygon to draw
	 * @param sideLength length of each side
	 */
	public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
		// Umut
		double angle=180-calculateRegularPolygonAngle(sides);

		for (int i = 0; i < sides; i++) {
			turtle.forward(sideLength);
			turtle.turn(angle);
		}
	}

	/**
	 * Given the current direction, current location, and a target location,
	 * calculate the heading towards the target point.
	 * 
	 * The return value is the angle input to turn() that would point the turtle in
	 * the direction of the target point (targetX,targetY), given that the turtle is
	 * already at the point (currentX,currentY) and is facing at angle
	 * currentHeading. The angle must be expressed in degrees, where 0 <= angle <
	 * 360.
	 *
	 * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
	 * 
	 * @param currentHeading current direction as clockwise from north
	 * @param currentX       current location x-coordinate
	 * @param currentY       current location y-coordinate
	 * @param targetX        target point x-coordinate
	 * @param targetY        target point y-coordinate
	 * @return adjustment to heading (right turn amount) to get to target point,
	 *         must be 0 <= angle < 360
	 */
	public static double calculateHeadingToPoint(double currentHeading, int currentX, int currentY, int targetX,
			int targetY) {
		// Merthan
		int newX = targetX - currentX;
		int newY = targetY - currentY;
		double angleFromNorth = Math.toDegrees(Math.atan2(newX, newY));
		double angle = angleFromNorth - currentHeading;
		if (angle < 0) {
			angle += 360; // must be positive
		}
		return angle;
		// throw new RuntimeException("implement me!");
	}

	/**
	 * Given a sequence of points, calculate the heading adjustments needed to get
	 * from each point to the next.
	 * 
	 * Assumes that the turtle starts at the first point given, facing up (i.e. 0
	 * degrees). For each subsequent point, assumes that the turtle is still facing
	 * in the direction it was facing when it moved to the previous point. You
	 * should use calculateHeadingToPoint() to implement this function.
	 * 
	 * @param xCoords list of x-coordinates (must be same length as yCoords)
	 * @param yCoords list of y-coordinates (must be same length as xCoords)
	 * @return list of heading adjustments between points, of size 0 if (# of
	 *         points) == 0, otherwise of size (# of points) - 1
	 */
	public static List<Double> calculateHeadings(List<Integer> xCoords, List<Integer> yCoords) {
		// Emre
		double currentHeading = 0;
		List<Double> headings = new ArrayList<Double>();
		if (!xCoords.isEmpty() && (xCoords.size() == yCoords.size())) {
			for (int i = 0; i < xCoords.size() - 1; i++) {
				headings.add(calculateHeadingToPoint(currentHeading, xCoords.get(i), yCoords.get(i), xCoords.get(i + 1),
						yCoords.get(i + 1)));
			}
		}
		return headings;
	}

	/**
	 * Draw your personal, custom art.
	 * 
	 * Many interesting images can be drawn using the simple implementation of a
	 * turtle. For this function, draw something interesting; the complexity can be
	 * as little or as much as you want.
	 * 
	 * @param turtle the turtle context
	 */
	public static void drawPersonalArt(Turtle turtle) {
		turtle.color(PenColor.BLUE);
		for (int i = 0; i < 510; i++) {
			turtle.forward(1);
			turtle.turn(1);
		}

		turtle.turn(180);

		for (int i = 0; i < 55; i++) {
			turtle.forward(3);
			turtle.turn(-4);
		}

		turtle.turn(90);

		for (int i = 0; i < 12; i++) {
			turtle.forward(3);
			turtle.turn(8);
		}

		turtle.turn(180);

		for (int i = 0; i < 46; i++) {
			turtle.forward(3);
			turtle.turn(-4);
		}

		turtle.turn(90);

		for (int i = 0; i < 12; i++) {
			turtle.forward(3);
			turtle.turn(8);
		}
	}

	/**
	 * Main method.
	 * 
	 * This is the method that runs when you run "java TurtleSoup".
	 * 
	 * @param args unused
	 */
	public static void main(String args[]) {
		DrawableTurtle turtle = new DrawableTurtle();
		//drawSquare(turtle, 40);
		//drawPersonalArt(turtle);
		drawRegularPolygon(turtle,15,50);
		//calculatePolygonSidesFromAngle
		//System.out.println(calculatePolygonSidesFromAngle(108));

		// draw the window
		turtle.draw();

	}

}
