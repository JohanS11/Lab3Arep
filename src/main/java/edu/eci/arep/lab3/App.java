package edu.eci.arep.lab3;

import edu.eci.arep.lab3.Challenge1.HTTPServer;

public class App {
    public static void main(String[] args) {
        HTTPServer server = new HTTPServer();
        server.start();
    }

}
