package laboration3C;

public class PlayerStrategy2 implements Strategy {

    @Override
    public PlayerMove executeStrategy(Player thisPlayer, Player otherPlayer) {
        if (otherPlayer.getHand().get(0).getRank() == Rank.KING) {
            if (thisPlayer.getCardSum() < 13) {
                return PlayerMove.PICK;
            }
        } else if (otherPlayer.getHand().get(0).getRank() == Rank.QUEEN) {
            if (thisPlayer.getCardSum() < 14) {
                return PlayerMove.PICK;
            }
        } else if (otherPlayer.getHand().get(0).getRank() == Rank.JACK) {
            if (thisPlayer.getCardSum() < 15) {
                return PlayerMove.PICK;
            }
        } else if (thisPlayer.getCardSum() < 16) {
            return PlayerMove.PICK;
        }
        return PlayerMove.STAND;
    }
}
