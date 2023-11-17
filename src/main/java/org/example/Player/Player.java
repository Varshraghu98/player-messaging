package org.example.Player;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;



/**
 * This class represents a player in a chat game.
 */
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;


    private String name = "";

    private AtomicInteger messageCount = new AtomicInteger(1);

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public Player(String name) {
        this.name = name;
    }

    /**
     * Constructor to create a player with a name and an initial message.
     *
     * @param name    The name of the player.
     * @param message The initial message of the player.
     */
    public Player(String name, String message) {
        this.name = name;
        this.message = message;
    }

    /**
     * Get the player's message count.
     *
     * @return The message count for the player.
     */
    public AtomicInteger getMessageCount() {
        return messageCount;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Increase the player's message count by one.
     */
    public void increaseMessageCount() {
        this.messageCount.incrementAndGet();
    }

    /**
     * Generate a reply message based on another player's message.
     *
     * @param sender The player who sent the original message.
     */
    public void getReply(Player sender) {
        String m = sender.getMessage() + " " + this.getMessageCount();
        increaseMessageCount();
        this.setMessage(m);
    }
}

