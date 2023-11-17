package org.example;

import org.example.Player.Player;

import java.io.*;
import java.net.Socket;

/**
 * This class represents the client-side of the chat application.
 */
public class PlayerClient {
    static Player player1;

    /**
     * Start the client, connect to the server, and initiate chat.
     */
    public void startClient() {

        try (Socket socket = new Socket(Utils.HOSTNAME, Utils.PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

                Player player = new Player("Player2", "Message");

                player.getReply(player);
                System.out.println("Sending From Client: " + player.getMessage());
                out.writeObject(player);

                clientChatBegins(player, out, in);

        } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
        }
    }


    /**
     * Start the chat conversation with the server.
     *
     * @param player The player on the client side.
     * @param out    The output stream to the server.
     * @param in     The input stream from the server.
     * @throws IOException            If there is an I/O error.
     * @throws ClassNotFoundException If a class cannot be found during deserialization.
     */
    public static void clientChatBegins(Player player, ObjectOutputStream out, ObjectInputStream in) throws IOException, ClassNotFoundException {
        while ((player1 = (Player) in.readObject()) != null) {
            if (player1.getMessageCount().intValue() == Utils.MESSAGE_COUNT && player.getMessageCount().intValue() == Utils.MESSAGE_COUNT) {
               Utils.exitGame();
            }
            player.getReply(player1);
            System.out.println("Sending From Client: " + player.getMessage());
            out.reset();
            out.writeObject(player);
        }
    }
}

