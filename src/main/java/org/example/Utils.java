package org.example;

import static java.lang.System.out;

/**
 * This class contains the utils methods and constants
 */

public final class Utils {
    public static void exitGame() {
        out.println("Game Over");
        System.exit(0);
    }


    /**
     * This value is set to 11 as the initial messageCount is 1.
     */
    public static int MESSAGE_COUNT = 11;

    public static String START_SERVER = "startServer";

    public static String START_CLIENT = "startClient";

    public static int PORT = 8080;

    public static String HOSTNAME = "localhost";

}
