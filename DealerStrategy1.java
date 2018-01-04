package laboration3C;

public class DealerStrategy1 implements Strategy {

    @Override
    public PlayerMove executeStrategy(Player thisPlayer, Player otherPlayer) {
        if (otherPlayer.getCardSum() < 17) {
            if (thisPlayer.getCardSum() <= otherPlayer.getCardSum()) {
                return PlayerMove.PICK;
            } else {
                return PlayerMove.STAND;
            }
        } 
        else if (thisPlayer.getCardSum() >= otherPlayer.getCardSum()) {
            return PlayerMove.STAND;
        } 
        else {
            return PlayerMove.PICK;
        }
    }
}
