import java.util.Scanner;
import java.util.Random;

public class playerPWN {
    public static void main(String[] args) {
        // create two pwning players
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        Scanner scanner = new Scanner(System.in);
        System.out.println("+ MUTUAL PWNAGE GUARANTEED +");
        System.out.println("Press 'w' then Enter: Player 1 attacks Player 2");
        System.out.println("Press 'o' then Enter: Player 2 attacks Player 1");
        System.out.println("Press 'q' then Enter: Quit game");

        while (true) {
            System.out.print("\nEnter command: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("q")) {
                System.out.println("stop fighting!!! Your final scores are:");
                System.out.println(player1.getName() + ": " + player1.getScore() + " pts");
                System.out.println(player2.getName() + ": " + player2.getScore() + " pts");
                break;
            } else if (input.equals("w")) {
                player1.attack(player2);
            } else if (input.equals("o")) {
                player2.attack(player1);
            } else {
                System.out.println("WHAT THE CRAP IS THAT. Use 'w' to attack as P1, 'o' to attack as P2, or 'q' to quit.");
            }
        }
        scanner.close();
    }
}

class Player {
    private String name;
    private int hp;
    private int score;
    private final int MAX_HP = 5;
    private static final Random random = new Random();

    public Player(String name) {
        this.name = name;
        this.hp = MAX_HP;
        this.score = 0;
    }

    public void attack(Player target) {
        System.out.println("\n" + this.name + " approaches with intent to PWN " + target.getName() + "!");
        
        // 20% chance to dodge
        if (random.nextInt(100) < 20) {
            System.out.println(target.getName() + " dodged the attack!");
            this.losePoints(20); // lose 20 points from shame
        } else {
            target.takeDamage(1);
            // check to see if target is dead
            if (target.getHp() == MAX_HP) { 
                this.score += 100;
                System.out.println(this.name + " earns 100 points! Total Score: " + this.score);
            }
        }
    }

    public void takeDamage(int amount) {
        this.hp -= amount;
        System.out.println(this.name + " TAKES " + amount + " DAMAGE. HP: " + this.hp + "/" + MAX_HP);

        if (this.hp <= 0) {
            respawn();
        }
    }

    public void losePoints(int amount) {
        this.score -= amount;
        System.out.println("WOW!  " + this.name + " LOSES " + amount + " POINTS FROM SHAME. Total Score: " + this.score);
    }

    private void respawn() {
        System.out.println(this.name + " GOT EPICLY PWND!");
        this.hp = MAX_HP;
        System.out.println(this.name + " respawned back at " + this.hp + " HP!");
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getScore() { return score; }
}
