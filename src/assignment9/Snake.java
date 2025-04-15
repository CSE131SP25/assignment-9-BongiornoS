package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;

	public Snake() {
		//FIXME - set up the segments instance variable
		//these two lines mine
		segments = new LinkedList<>();
		segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE)); // start in the center

		deltaX = 0;
		deltaY = 0;
	}

	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}

	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		//FIXME
		BodySegment head = segments.getFirst();
		double newX = head.getX() + deltaX;
		double newY = head.getY() + deltaY;

		segments.addFirst(new BodySegment(newX, newY, SEGMENT_SIZE));
		segments.removeLast(); // remove tail
		// Tail removed = normal movement
		//Moves the snake by adding a new head and removing the tail
		//if food is eaten, the tail isn’t removed (done inside eatFood), so the list grows.
	}

	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (BodySegment segment : segments) {
			segment.draw();
		}
		//FIXME
	}

	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		//FIXME
		BodySegment head = segments.getFirst();
		double dx = head.getX() - f.getX();
		double dy = head.getY() - f.getY();
		double distance = Math.sqrt(dx * dx + dy * dy);

		if (distance < SEGMENT_SIZE) {
			//When the snake eats food, the eatFood(Food f) method is triggered
			// "Grow" the snake by adding another head and NOT removing the tail
			double newX = head.getX() + deltaX;
			double newY = head.getY() + deltaY;
			segments.addFirst(new BodySegment(newX, newY, SEGMENT_SIZE));
			//// ^ Growth happens here
			return true;
		}
		return false;
	}

	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		//FIXME
		BodySegment head = segments.getFirst();
		double x = head.getX();
		double y = head.getY();
	//Uses normalized coordinates to check if the snake's head is within bounds
		return x >= 0 && x <= 1 && y >= 0 && y <= 1;
	
	//return true;
}
}

