package structures.basic;

public class PlayerHand {
    private Card[] playerCards;
    private int handPosition = 0;
    private final int maxPosition = 5;

    public PlayerHand() {
        playerCards = new Card[6];
    }

    public Card[] getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(Card[] playerCards) {
        this.playerCards = playerCards;
    }

    public Card getPlayerCard(int handPosition) {
        if(handPosition > 0) {
            return playerCards[handPosition - 1];
        }
        return null;
    }

    public void setPlayerCard(int handPosition, Card card) {
        if(handPosition > 0) {
            this.playerCards[handPosition - 1] = card;
            if(card != null) {
                card.setHandPosition(handPosition);
            }
        }
    }

    public int getHandPosition() {
        return handPosition;
    }

    public int getMaxPosition() {
        return maxPosition;
    }

    public void setHandPosition(int handPosition) {
        this.handPosition = handPosition;
    }

    public void addCard(Card card) {
        this.playerCards[handPosition] = card;
        handPosition++;
    }

    public void removeCard(int handPosition) {
        if(handPosition == 6) {
            setPlayerCard(handPosition, null);
        }
        while(handPosition < 6) {
            setPlayerCard(handPosition, getPlayerCard(handPosition+1));
            setPlayerCard(handPosition+1, null);
            handPosition++;
        }
        this.handPosition--;
    }

}
