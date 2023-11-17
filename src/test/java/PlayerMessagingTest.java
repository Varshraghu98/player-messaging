import org.example.Player.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerMessagingTest {
        Player serverPlayer;

        Player clientPlayer;

        @Test
        public void testPlayerResponse() {
            serverPlayer = new Player("Player 2", "Message");
            clientPlayer = new Player("Player 1");

            clientPlayer.getReply(serverPlayer);
            serverPlayer.getReply(clientPlayer);


            assertEquals("Message" + " 1", clientPlayer.getMessage());
            assertEquals("Message" + " 1 1", serverPlayer.getMessage());
        }

}
