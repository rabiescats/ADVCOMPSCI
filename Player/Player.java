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
