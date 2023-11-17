package org.example;

import java.net.ConnectException;

import static java.lang.System.out;


/**
 * This class represents the main entry point for the chat application.
 */
public class Main {

    public static void main(String[] args) throws ConnectException {
        initArgs(args);
        if(args[0].equals(Utils.START_SERVER)) {
            startServer();
        } else if(args[0].equals(Utils.START_CLIENT)) {
            startClient();
        }
    }

    /**
     * Initialize the application based on command-line arguments.
     *
     * @param args The command-line arguments.
     */
    public static void initArgs(String[] args) {
        // Check if there is at least one command-line argument
        if (args.length < 1) {
            throw new IllegalArgumentException("not enough input parameters");
        }
    }

    /**
     * Start a client connection to the server.
     *
     * @throws ConnectException If the connection to the server fails.
     */
    private static void startClient() throws ConnectException {
        out.println("Waiting for Server");
        PlayerClient playerClient = new PlayerClient();
        playerClient.startClient();
    }


    /**
     * Start a server instance.
     */
    private static void startServer() {
        out.println("Initializing a Server");
        PlayerServer playerServer = new PlayerServer();
        playerServer.startPlayerServer();
    }
}

