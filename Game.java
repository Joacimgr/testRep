package laboration3C;

public class Game {

    private static final int NROFRUNS = 1000000;
    private final Player player;
    private final Player dealer;
    private final Deck deck;
    private int runs;
    private boolean gameRunning = true;
    private final Strategy playerStrategy;
    private final Strategy dealerStrategy;
    private int playerWins;
    private int dealerWins;
    private int draws;

    public Game() {
        playerStrategy = new PlayerStrategy2();
        dealerStrategy = new DealerStrategy1();
        player = new Player(playerStrategy);
        dealer = new Player(dealerStrategy);
        deck = new Deck();
        playerWins = 0;
        dealerWins = 0;
        draws = 0;
        runs = NROFRUNS;
    }

    public void start() {
        do {
            gameRunning = true;
            initRound();
            gameLogic();
            runs--;
        } while (runs > 0);
        Communication.statistics(playerWins, dealerWins, draws, NROFRUNS);
    }

    private void initRound() {
        //running = true;
        /*
        At the start of a blackjack game, the players and the dealer receive 
        two cards each. The players' cards are normally dealt face up, while 
        the dealer has one face down (called the hole card) and one face up.
        Source: https://www.pagat.com/banking/blackjack.html
         */
        deck.fill();
        deck.shuffleCards();
        player.clearHand();
        dealer.clearHand();
        try {
            player.addCard(deck.dealCard());
            player.addCard(deck.dealCard());
            dealer.addCard(deck.dealCard());
            dealer.addCard(deck.dealCard());
        } catch (NoSuchCardException nsce) {
            //Om det är slut på kort i kortleken så väljer vi att avsluta programmet
            //samt nollställer all mätdata då datan inte är meningsfull i detta fall.
            runs = 0;
            gameRunning = false;
            playerWins = 0;
            dealerWins = 0;
            draws = 0;
        }
        //Communication.printGameStart();
        //Communication.printInitDealerHand(dealer);
        //Communication.printHand(player, "Player");
        //Communication.currentSum(player, dealer, "Player", "Dealer");

        /*
        A player who receives an Ace and a 10-point card as the initial 
        two cards on a deal is said to have a "natural 21" or a "blackjack".
        Should the dealer get a "blackjack" as well, the hand is a "push" (tie), 
        which means the bet is left on the table and goes to the next hand.
        Source: http://www.blackjackrulesandstrategy.com/specific-rules.shtml
         */
    }

    private void gameLogic() {
        while (gameRunning) {
            //Communication.playerTurnBegins();
            while (player.getChoice(dealer) == PlayerMove.PICK) {
                try {
                    player.addCard(deck.dealCard());
                } catch (NoSuchCardException nsce) {
                    runs = 0;
                    gameRunning = false;
                    playerWins = 0;
                    dealerWins = 0;
                    draws = 0;
                }
                //Communication.cardPicked(player, "Player");
                //Communication.printHand(player, "Player");
                //Communication.currentSum(player, dealer, "Player", "Dealer");
            }

            //The player has chosen not to pick another card
            while ((dealer.getChoice(player) == PlayerMove.PICK && player.getCardSum() < 22)
                    && !hasBlackjack(player) && gameRunning) {
                try {
                    dealer.addCard(deck.dealCard());
                } catch (NoSuchCardException nsce) {
                    runs = 0;
                    gameRunning = false;
                    playerWins = 0;
                    dealerWins = 0;
                    draws = 0;
                }
                //Communication.cardPicked(dealer, "Dealer");
                //Communication.printHand(dealer, "Dealer");
                //Communication.currentSumFullDealerHand(player, dealer, "Player", "Dealer");
            }

            if (gameRunning) {
                if (hasBlackjack(player)) {
                    if (hasBlackjack(dealer)) {
                        //Communication.pushHand();
                        draws++;
                    } else {
                        //Communication.playerBlackJack();
                        playerWins++;
                    }
                } else if (player.getCardSum() > 21) {
                    //Communication.dealerWon();
                    dealerWins++;
                } else if (dealer.getCardSum() > 21) {
                    //Communication.playerWon();
                    playerWins++;
                } else if (dealer.getCardSum() == player.getCardSum()) {
                    //Communication.draws();
                    draws++;
                } else if (player.getCardSum() > dealer.getCardSum()) {
                    //Communication.playerWon();
                    playerWins++;
                } else {
                    //Communication.dealerWon();
                    dealerWins++;
                }
                gameRunning = false;
            }
        }
    }

    private boolean hasBlackjack(Player p) {
        //Check if first two cards contains ace
        for (int i = 0; i < 2; i++) {
            if (p.getHand().get(i).getRank() == Rank.ACE) {
                //Check if total sum is above 23 (ace(1) + card > 10)
                if (p.getHand().get(0).getRankValue() + p.getHand().get(1).getRankValue() > 10) {
                    return true;
                }
            }
        }
        return false;
    }
}
