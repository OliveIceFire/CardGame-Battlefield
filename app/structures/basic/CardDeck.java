package structures.basic;

import utils.OrderedCardLoader;
import java.util.ArrayList;
import java.util.List;

public class CardDeck {

    private List<Card> playerDeck = new ArrayList<Card>(20);
    private List<Card> aiPlayerDeck = new ArrayList<Card>(20);

    public CardDeck() {
        playerDeck = OrderedCardLoader.getPlayer1Cards();
        aiPlayerDeck = OrderedCardLoader.getPlayer2Cards();
    }

    public List<Card> getPlayerDeck() {
        return playerDeck;
    }

    public List<Card> getAiPlayerDeck() {
        return aiPlayerDeck;
    }

    public Card drawPlayerCard() {
        Card topCard;
        if(playerDeck.size() > 0) {
            topCard = playerDeck.get(0);
            playerDeck.remove(0);
            return topCard;
        }
        return null;
    }

    public Card drawAiPlayerCard() {
        Card topCard;
        if(aiPlayerDeck.size() > 0) {
            topCard = aiPlayerDeck.get(0);
            aiPlayerDeck.remove(0);
            return topCard;
        }
        return null;
    }

}
