package bouncingballs;

import mpe.client.*;
import processing.core.*;

public class ASyncClientExample extends PApplet {
    //--------------------------------------

    TCPClient client;

    //--------------------------------------
    static public void main(String args[]) {
        PApplet.main(new String[] { "bouncingballs.ASyncClientExample" });
    }

    //--------------------------------------
    public void setup() {
        size(320,240);
        // make a new Client using an XML file
        client = new TCPClient(this, "asynch.xml");
        
        // IMPORTANT, YOU MUST START THE CLIENT!
        client.start();
        
        //println(client.isAsynchronous());
        //println(client.isReceiver());
    }
    
    
    public void draw() {
    	
    }
    
    //--------------------------------------
    // asynchreceive must be set to true in
    // asynch.xml to receive data here
    public void dataEvent(TCPClient c) {
    	println("Raw message: " + c.getRawMessage());
    	if (c.messageAvailable()) {
    		String[] msgs = c.getDataMessage();
    		for (int i = 0; i < msgs.length; i++) {
    			println("Parsed message: " + msgs[i]);
    		}
    	}
    	
    }


    //--------------------------------------
    // Adds a Ball to the stage at the position of the mouse click.
    public void mousePressed() {
        // never include a ":" when broadcasting your message
        int x = mouseX*2;
        int y = mouseY*2;
        client.broadcast(x + "," + y);
    }
}
