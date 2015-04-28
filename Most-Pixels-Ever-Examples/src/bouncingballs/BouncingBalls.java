/**
 * Simple Bouncing Ball Demo using automatic mode.
 * <http://code.google.com/p/mostpixelsever/>
 */

package bouncingballs;

import java.util.ArrayList;
import mpe.client.*;
import processing.core.*;

public class BouncingBalls extends PApplet {
	//--------------------------------------
	final int ID = 0;

	ArrayList<Ball> balls;
	TCPClient client;

	//--------------------------------------
	static public void main(String args[]) {
		PApplet.main(new String[] { "bouncingballs.BouncingBalls" });
	}

	//--------------------------------------
	public void setup() {
		// make a new Client using an XML file
		client = new TCPClient(this, "mpe" + ID + ".xml");
		
		// the size is determined by the client's local width and height
		size(client.getLWidth(), client.getLHeight());
		resetEvent(client);

		// IMPORTANT, YOU MUST START THE CLIENT!
		client.start();
	}

	//--------------------------------------
	// Start over
	public void resetEvent(TCPClient c) {
		// the random seed must be identical for all clients
		randomSeed(1);

		// add a "randomly" placed ball
		balls = new ArrayList<Ball>();
		balls.add(new Ball(100,50));
		balls.add(new Ball(500,50));

	}

	//--------------------------------------
	// Keep the motor running... draw() needs to be added in auto mode, even if
	// it is empty to keep things rolling.
	public void draw() {
	}


	//--------------------------------------
	// Separate data event
	public void dataEvent(TCPClient c) {
		String[] msg = c.getDataMessage();
		String[] xy = msg[0].split(",");
		float x = Integer.parseInt(xy[0]);
		float y = Integer.parseInt(xy[1]);
		balls.add(new Ball(x, y));
	}

	//--------------------------------------
	// Triggered by the client whenever a new frame should be rendered.
	// All synchronized drawing should be done here when in auto mode.
	public void frameEvent(TCPClient c) {
		// clear the screen     
		background(255);

		// move and draw all the balls
		for (Ball b : balls) {
			b.calc();
			b.draw();
		}

		// read any incoming messages
		/*if (c.messageAvailable()) {
			String[] msg = c.getDataMessage();
			String[] xy = msg[0].split(",");
			float x = Integer.parseInt(xy[0]);
			float y = Integer.parseInt(xy[1]);
			balls.add(new Ball(x, y));
		}*/
	}



	//--------------------------------------
	// Adds a Ball to the stage at the position of the mouse click.
	public void mousePressed() {
		// never include a ":" when broadcasting your message
		int x = mouseX + client.getXoffset();
		int y = mouseY + client.getYoffset();
		client.broadcast(x + "," + y);
	}

	public void keyPressed() {
		if (key == 'p') {
			client.togglePause();
		}
	}

	//--------------------------------------
	// A Ball moves and bounces off walls.
	class Ball {
		//--------------------------------------
		float x = 0;     // center x position
		float y = 0;     // center y position
		float xDir = 1;  // x velocity
		float yDir = 1;  // y velocity
		float d = 48;    // diameter

		//--------------------------------------
		public Ball(float _x, float _y) {
			x = _x;
			y = _y;
			xDir = random(-5,5);
			yDir = random(-5,5);
		}

		//--------------------------------------
		// Moves and changes direction if it hits a wall.
		public void calc() {
			if (x < 0 || x > client.getMWidth())  xDir *= -1;
			if (y < 0 || y > client.getMHeight()) yDir *= -1;
			x += xDir;
			y += yDir;
		}

		//--------------------------------------
		public void draw() {
			stroke(0);
			fill(0, 100);
			ellipse(x, y, d, d);
		}
	}
}
