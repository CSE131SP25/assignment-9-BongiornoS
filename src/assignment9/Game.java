package assignment9;

import java.awt.event.KeyEvent;
import java.awt.Color; // ADDED: needed for StdDraw.setPenColor(Color.BLACK)
//import assignment8.Nonzombie;
import edu.princeton.cs.introcs.StdDraw;

public class Game {
	//mine
	private int score = 0; // ADDED: tracks number of apples eaten
	private Snake snake;
	private Food food;

	//
	public Game() {
		StdDraw.enableDoubleBuffering();
		
		//FIXME - construct new Snake and Food objects
		
		snake = new Snake(); 
		food = new Food();  
		
		
	//	ClassName objectName = new ClassName(arguments);
	//	Game snake = new Game(s);
	//	Game food = new Game(f);
		
	}
	
	public void play() {
		while (snake.isInbounds()) {
			// Handle keypress ,,,,, (true) { //TODO: Update this condition to check if snake is in bounds
			int dir = getKeypress();
			//Testing only: you will eventually need to do more work here
			//System.out.println("Keypress: " + dir);
			
			
			if (dir != -1) {
				snake.changeDirection(dir);
			}
			
			// Move the snake
			snake.move();
			
			// Check if the snake eats the food
			if (snake.eatFood(food)) {
				food = new Food(); // replace food
				//^ Food respawns at random location bc of move class
					score++; // ADDED: increase score
					System.out.println("Score: " + score); // ADDED: optional, print to console

			}
			
			// Clear, draw, and show frame
			StdDraw.clear();
			snake.draw();
			food.draw();
			StdDraw.show();
			// ADDED: draw the score text
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.text(0.1, 0.95, "Score: " + score); // Top left-ish corner

			StdDraw.pause(100); // slow it down a bit
		}
		
		// Game Over
		System.out.println("Game Over!");
		//The loop runs as long as snake.isInbounds() returns true
		//Game ends here bc this is where it would return false
	}
	//Runs the game loop:
		//Checks direction
		//Moves the snake
		//Eats food and respawns it
		//Draws everything
		//Ends if the snake is out of bounds
	
			
			//Game snake = findClosestNonzombie(entities);
	      //  if (s != null) {
	        	
	   //     }
		//	checkBounds();  // keep the snake in bounds
		
	       // return this;
	        
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		//FIXME
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	public static void main(String[] args) {
		Game g = new Game(); // <-- Initializes the game
		g.play(); // <-- Starts the game loop
		//The Game class sets everything up (snake, food) and starts the main loop
	}
}
