package laboration3C;

public class PlayerStrategy1 implements Strategy{

    @Override
    public PlayerMove executeStrategy(Player thisPlayer, Player otherPlayer) {
        if(thisPlayer.getCardSum() < 16){
            return PlayerMove.PICK;
        }
        else{
            return PlayerMove.STAND;
        }
    }
}
