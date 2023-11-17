package org.example;

import org.example.Player.Player;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class represents the server-side of the chat application.
 */
public class PlayerServer {
    public static Player player2;
    /**
     * Start the server, listen for client connections and initiate chat.
     */
    public void startPlayerServer() {
        try(ServerSocket serverSocket = new ServerSocket(Utils.PORT);
            Socket clientConnection = serverSocket.accept();
            ObjectOutputStream out = new ObjectOutputStream(clientConnection.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clientConnection.getInputStream()))  {

            System.out.println("Awaiting Players to join");

            Player player = new Player("Player 1");

            serverChatBegins(player, out, in);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Start the chat conversation with a client.
     *
     * @param player The player on the server side.
     * @param out    The output stream to the client.
     * @param in     The input stream from the client.
     * @throws IOException            If there is an I/O error.
     * @throws ClassNotFoundException If a class cannot be found during deserialization.
     */
    static void serverChatBegins(Player player, ObjectOutputStream out, ObjectInputStream in) throws IOException, ClassNotFoundException {
        while ((player2 = (Player) in.readObject()) != null) {
            player.getReply(player2);
            System.out.println("Sending From Server: " + player.getMessage());
            out.reset();
            out.writeObject(player);
            if (player2.getMessageCount().intValue() == Utils.MESSAGE_COUNT && player.getMessageCount().intValue() == Utils.MESSAGE_COUNT) {
                Utils.exitGame();
            }
        }
    }
}

