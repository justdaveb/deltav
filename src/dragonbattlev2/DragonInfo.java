package dragonbattlev2;

import java.util.LinkedList;
import java.util.*;

public class DragonInfo {

    DragonBattleStaticStats staticStats = new DragonBattleStaticStats();
    private int arrows = 0;
    private int potionTotal = 0;
    private int swordTotal = 0;
    private int knifeTotal = 0;
    private int bowTotal = 0;
    private int healthTotal = 0;
    private int ironArmor = 0;
    private int leatherArmor = 0;
    private int addTrjes = 0;
    private int questTokens = 0;
    private int wizHealth = 150;
    private int enhancers = 0;
    private int choiceValue;
    private int xpTotal = 0;
    private int strength = 0;
    private int accuracy = 0;
    private int witchcraft = 0;
    private int magicLevel = 0;
    private int healthTracker = staticStats.getHealth();
    private int keepPurchasing = 0;
    private int currentXP = 0;
    private int hunger = staticStats.getHunger();
    private int dragonKills = 0;
    private String heroName = "";
    private boolean keepBuying = true;
    private boolean keepChoosing = true;

    private int select;
    private int wizNum;
    private int dragonHealth;
    private int result;
    private int dragonAttack;
    private int going;
    String dName;
    private String[] names = {"Smaug", "Belthcor", "Deascrith", "Ungol the Mighty", "Kenith the Adorable", "Brynioth",
        "Ith", "Perenth the Creep", "Ohm the Deathlord", "Lagrocius, Lord of the Skies", "Franae, the Eater of Bunnies", "Visalauth the Strong"};
    LinkedList<String> dragNames = new LinkedList<String>();

    DAesthetic visual = new DAesthetic();
    BooleanChecker bc = new BooleanChecker();

    public int getBattleResults(int weapon, int arrowTotal) {
        Random rand = new Random();
        int result = 0;
        int breaks = 0;
        breaks = rand.nextInt(27); //damn Taylor and his stupid number choices Taylor says <3
        if (breaks != 5) {
            switch (weapon) {
                case 1:
                    if (swordTotal > 0) {
                        result = rand.nextInt(50) + 18 + (getStrengthBoost() * 3);

                    } else {
                        System.out.println("You have none of this weapon!!");
                    }
                    break;
                case 2:
                    if (knifeTotal > 0) {
                        result = rand.nextInt(25) + 30 + (getStrengthBoost() * 2);

                    } else {
                        System.out.println("You have none of this weapon!!");
                    }
                    break;
                case 3:
                    if (arrowTotal > 0) {
                        if (bowTotal > 0) {
                            result = rand.nextInt(37) + 27 + (getAccuracyBoost() * 4);
                            setArrowTotal(-1);

                        } else {
                            System.out.println("You have none of this weapon!!");
                        }
                        break;
                    } else {
                        System.out.println("You didn't have any arrows!");
                    }
                    break;
                case 4:
                    if (potionTotal > 0) {
                        result = rand.nextInt(40) + 28;
                        setPotionTotal(-1);

                    } else {
                        System.out.println("You have none of this weapon!!");
                    }
                    break;
            }
        } else {
            System.out.println("Your weapon broke!");
            switch (weapon) {
                case 1:
                    setSwordTotal(-1);
                    break;
                case 2:
                    setKnifeTotal(-1);
                    break;
                case 3:
                    setBowTotal(-1);
                    break;
                case 4:
                    setPotionTotal(-1);
                    break;
            }
        }
        return result;
    }

    public int getDragonAttack() {
        Random rand = new Random();
        int attack = rand.nextInt(65) + 10;
        return attack;
    }

    public void setArrowTotal(int arrowTotal) {
        arrows += arrowTotal;
    }

    public int getArrowTotal() {
        return arrows;
    }

    public void setPotionTotal(int potions) {
        potionTotal += potions;
    }

    public int getPotionTotal() {
        return potionTotal;
    }

    public void setSwordTotal(int swords) {
        swordTotal += swords;
    }

    public int getSwordTotal() {
        return swordTotal;
    }

    public void setKnifeTotal(int knives) {
        knifeTotal += knives;
    }

    public int getKnifeTotal() {
        return knifeTotal;
    }

    public void setBowTotal(int bow) {
        bowTotal += bow;
    }

    public int getBowTotal() {
        return bowTotal;
    }

    public int returnDamage(int attack1, int attack2, int health) {
        int difference = (attack1 - attack2);
        int finalHealth = health - difference;
        return finalHealth;
    }

    public void setHungerTotal(int setter) {
        healthTotal += setter;
    }

    public int getHungerTotal() {
        return healthTotal;
    }

    public void setLeatherArmor(int armor) {
        leatherArmor += armor;
    }

    public int getLeatherArmor() {
        return leatherArmor;
    }

    public void setIronArmor(int armor) {
        ironArmor += armor;
    }

    public int getIronArmor() {
        return ironArmor;
    }

    public int getArmorSave() {
        int reduction = 0;
        if (ironArmor > 0) {
            if (getIronBreak() == 0) {
                reduction += 20;
            } else {
                System.out.println("Your iron armor breaks!");
                reduction += 0;
                setIronArmor(-1);
            }
        }
        if (leatherArmor > 0) {
            if (getLeatherBreak() == 0) {
                reduction += 10;
            } else {
                System.out.println("Your leather armor breaks!");
                reduction += 0;
                setLeatherArmor(-1);
            }
        }
        return reduction;
    }

    public int getIronBreak() {
        Random rand = new Random();
        int checker = rand.nextInt(15);
        if (checker == 5) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getLeatherBreak() {
        Random rand = new Random();
        int checker = rand.nextInt(10);
        if (checker == 5) {
            return 1;
        } else {
            return 0;
        }
    }
    /*
     public String getCitizenName() {
     Random rand = new Random();
     String[] names = {"Phillip", "P. Griffin", "Eric", "Jesus, the Foreigner", "Juan Ricardo", "Haggreed", "Barry", "Bobby Butler", "Bill the Boe", "James Swiggins, Earl of Bwizzardingdon",
     "Mendel, the Mighty Axe-Man", "Dinkleberg", "A Stranger who smells of stale cheese", "Peter", "Taylor", "Justin", "A prisoner playing a harmonica",
     "Serninity, the Priest", "A bum, playing his drum", "Jimmy's Boy", "Jimmy"};
     return names[rand.nextInt(names.length)];
     }
     */

    public String getExploration() {
        Random rand = new Random();
        String returnString = "";
        int exploreSelect = rand.nextInt(16);
        //add MANY more options, primarily options worth nothing. Make it more difficult to find items
        switch (exploreSelect) {
            case 0:
                returnString = "You find an old but usable iron sword in some bushes.";
                if (checkInventory(getInventoryTotal(getSwordTotal(), getKnifeTotal(), getBowTotal(), getPotionTotal()))) {
                    setSwordTotal(1);
                } else {
                    System.out.println("Intentory Full!");
                }
                break;
            case 1:
                int coins = rand.nextInt(25);
                returnString = "You find " + coins + " Trjes buried in a small pit!";
                addTrjes += coins;
                break;
            case 2:
                int change = rand.nextInt(10);
                healthDamage(change);
                returnString = "You accidentally run head-on into a prickly bush! You lose " + change + " health.";
                break;
            case 3:
                returnString = "You find........alot of dirt.";
                break;
            case 4:
                int number = rand.nextInt(16);
                returnString = "You find a pile of " + number + " arrows!";
                setArrowTotal(number);
                break;
            case 5:
                returnString = "A few dry plants are blown past by a gust of wind.";
                break;
            case 6:
                if (getHungerTotal() <= 25) {
                    setHungerTotal(5);
                } else {
                    setHungerTotal(30 - getHungerTotal());
                }
                returnString = "You find some nice berries on a bush!";
                break;
            case 7:
                int potions = rand.nextInt(3);
                returnString = "You find a hidden stash of " + potions + " damage potions!";
                if (checkInventory(getInventoryTotal(getSwordTotal(), getKnifeTotal(), getBowTotal(), getPotionTotal()))) {
                    setPotionTotal(potions);
                } else if (12 - getInventoryTotal(getSwordTotal(), getKnifeTotal(), getBowTotal(), getPotionTotal()) >= 1) {
                    int compare = 12 - getInventoryTotal(getSwordTotal(), getKnifeTotal(), getBowTotal(), getPotionTotal());
                    if (compare <= potions) {
                        setPotionTotal(compare);
                    } else {
                        setPotionTotal(potions);
                    }
                }
                break;
            case 8:
                int damage = rand.nextInt(10);
                healthDamage(damage);
                returnString = "You are attacked by a rabid armadillo! He causes " + damage + " damage to your health!";
                break;
            case 9:
                returnString = "You find nothing but the emptiness of the " + visual.getWildernessName() + ".";
                break;
            case 10:
                returnString = "You find an Elvish bow in good condition!";
                if (checkInventory(getInventoryTotal(getSwordTotal(), getKnifeTotal(), getBowTotal(), getPotionTotal()))) {
                    setBowTotal(1);
                } else {
                    System.out.println("Iventory Full!");
                }
                break;
            case 11:
                returnString = "You find nothing but the emptiness of the " + visual.getWildernessName() + ".";
                break;
            case 12:
                returnString = "You find nothing but the emptiness of the " + visual.getWildernessName() + ".";
                break;
            case 13:
                returnString = "You find nothing but the emptiness of the " + visual.getWildernessName() + ".";
                break;
            case 14:
                returnString = "You've discovered an artifact item! Take it back to the artifact house to turn it in!";
                setQuestTokens(1);
                break;
            case 15:
                int prob = rand.nextInt(20);
                if (prob == 13) {
                    int totalTokens = rand.nextInt(5);
                    int totalTrjes = rand.nextInt(500) + 100;
                    returnString = "You found a secret trove of buried treasure and artifacts! The Trove contained " + totalTrjes + " and " + totalTokens + " quest items!";
                    setQuestTokens(totalTokens);
                    addTrjes += totalTrjes;

                } else {
                    returnString = "You find nothing but the emptiness of the " + visual.getWildernessName() + ".";
                }
                break;
        }
        return returnString;
    }

    public int addToTrjes() {
        int number = addTrjes;
        addTrjes = 0;
        return number;

    }

    public void setQuestTokens(int tokens) {
        questTokens += tokens;
    }

    public int getQuestTokens() {
        return questTokens;
    }

    public void emptyTokens(int tokens) {
        questTokens = tokens;
    }

    public String getArtifactPossability() {
        Random rand = new Random();
        String returnString = "";
        int chooseArtifact = rand.nextInt(11);
        questTokens -= 1;
        switch (chooseArtifact) {
            case 0:
                returnString = getArtifact0();
                break;
            case 1:
                returnString = getArtifact1();
                break;
            case 2:
                returnString = getArtifact2();
                break;
            case 3:
                returnString = getArtifact3();
                break;
            case 4:
                returnString = getArtifact4();
                break;
            case 5:
                returnString = getArtifact5();
                break;
            case 6:
                returnString = getArtifact6();
                break;
            case 7:
                returnString = getArtifact7();
                break;
            case 8:
                returnString = getArtifact8();
                break;
            case 9:
                returnString = getArtifact9();
                break;
            case 10:
                returnString = getArtifact10();
                break;
            case 11:
                returnString = getArtifact11();
                break;
            case 12:
                returnString = getArtifact12();
                break;
            case 13:
                returnString = getArtifact13();
                break;
        }
        return returnString;

    }

    public String getArtifact0() {
        String str = "You've found the Mithril Pebble of Pigsmiting!! This Nigga's gonna spice up my life! \nHere's 75 Trjes for finding it!";
        addTrjes += 75;
        return str;
    }

    public String getArtifact1() {
        String str = "You've found the Emerald Leggings of Aldoria! \nAn excellent find, here's 45 Trjes for them!";
        addTrjes += 45;
        return str;
    }

    public String getArtifact2() {
        String str = "You've found the Gauntlets of Domination, once owned by one of the greatest heroes! \nHere's 40 Trjes fo your find!";
        addTrjes += 40;
        return str;
    }

    public String getArtifact3() {
        String str = "You've found an old knife from the elder days! \nA common find, but worth 15 Trjes to me!";
        addTrjes += 15;
        return str;
    }

    public String getArtifact4() {
        String str = "You've found a magic ring of potion making, from the barbarians of the south! \nHere's 17 Trjes for finding one!";
        addTrjes += 17;
        return str;
    }

    public String getArtifact5() {
        String str = "You've found an Elvish Cloak of Disguise. I wonder who dropped it... \nHere's 16 Trjes, "
                + "and I'll try to find its owner!";
        addTrjes += 16;
        return str;
    }

    public String getArtifact6() {
        String str = "You found the a chestplate made of Burning Steel, an interesting piece of work by the Dwarves!"
                + "\nAn good find, worth 25 Trjes to me!";
        addTrjes += 25;
        return str;
    }

    public String getArtifact7() {
        String str = "You've found a rusty set of cast-iron knuckles. A common weapon fromt he south. \n"
                + "Here's 10 Trjes for it!";
        addTrjes += 10;
        return str;
    }

    public String getArtifact8() {
        String str = "You've found an old helm. An old but efficient piece of armor. \n"
                + "Here's 11 Trjes for it!";
        addTrjes += 11;
        return str;
    }

    public String getArtifact9() {
        String str = "You must be blind, that's a hunk of useless metal. \nEven the blacksmith won't want that";
        return str;
    }

    public String getArtifact10() {
        String str = "You've found a magic spell enhancer! That's too valuable for me to buy from you. \nSave that in case you need it!";
        addEnhancers(1);
        return str;
    }

    public String getArtifact11() {
        String str = "You've found a special medallion that increases your strength with secret magics! Hold on to this one.";
        addStrength();
        return str;
    }

    public String getArtifact12() {
        String str = "You've found a unique pair of gloves that increase your accuracy with secret magics! Hold on to this one.";
        addAccuracy();
        return str;
    }

    public String getArtifact13() {
        String str = "You've found a special ring that increases your magical abilities with secret forging qualities! Hold on to this one.";
        addWitchcraft();
        return str;
    }

    public int getTokens() {
        return questTokens;
    }

    public void setHeroName(String name) {
        heroName = name;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getWizardName() {
        return "Springscare The Haunt";
    }

    public int getMagicAttack() {
        Random rand = new Random();
        int attack = rand.nextInt(60) + 50;
        return attack;
    }

    public int getWizardAttack() {
        Random rand = new Random();
        int attack = rand.nextInt(20) + 90;
        return attack;
    }

    public int getResults(int a1, int a2) {
        int result = a1 - a2;
        return result;
    }

    public void dealDamagetoWiz(int damage) {
        wizHealth -= damage;
    }

    public int getWizardHealth() {
        return wizHealth;
    }

    public void addEnhancers(int enhance) {
        enhancers += enhance;
    }

    public int getEnhancers() {
        return enhancers;
    }

    public int getInventoryTotal(int sword, int knives, int bow, int potion) {
        int weaponInventory = sword + knives + bow + potion;
        return weaponInventory;
    }

    public boolean checkInventory(int check) {
        if (check <= 11) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getSalesResult() {
        DAesthetic visual = new DAesthetic();
        Scanner scan = new Scanner(System.in);
        int choice;
        boolean bool = true;
        boolean leave = false;
        boolean keepChoosing = true;
        System.out.print(visual.getMarketMenu());
        while (keepChoosing) {
            if (getCheckerOneThroughFive(scan.next())) {
                choice = getChoiceValue();
            } else {
                choice = 6;
            }
            switch (choice) {
                case 1:
                    if (getSwordTotal() >= 1) {
                        System.out.println("Here's 40 Trjes for that fine sword!");
                        setSwordTotal(-1);
                        addTrjes += 40;
                    } else {
                        System.out.println("You have none of that item, mister!");
                    }
                    keepChoosing = false;
                    break;
                case 2:
                    if (getKnifeTotal() >= 1) {
                        System.out.println("Here's 22 Trjes for those throwing knives!");
                        setKnifeTotal(-1);
                        addTrjes += 22;
                    } else {
                        System.out.println("You have none of that item, mister!");
                    }
                    keepChoosing = false;
                    break;
                case 3:
                    if (getBowTotal() >= 1) {
                        System.out.println("I'll give you 28 Trjes for that bow you've got there!");
                        setBowTotal(-1);
                        addTrjes += 28;
                    } else {
                        System.out.println("You have none of that item, mister!");
                    }
                    keepChoosing = false;
                    break;
                case 4:
                    if (getPotionTotal() >= 1) {
                        System.out.println("For 12 Trjes I'll take those potions off your hands, mister...");
                        setPotionTotal(-1);
                        addTrjes += 12;
                    } else {
                        System.out.println("You have none of that item, mister!");
                    }
                    keepChoosing = false;
                    break;
                case 5:
                    System.out.println("Alright, see you around");
                    bool = false;
                    leave = true;
                    keepChoosing = false;
                    break;
                default:
                    keepChoosing = true;
            }
            System.out.println(visual.getSplitter());
        }
        keepChoosing = true;
        if (leave == false) {
            System.out.print("Want to keep selling, mister? \n"
                    + "1) Sure! \n"
                    + "2) No, I'll be leaving. \n"
                    + "Enter selection: ");
            if (getCheckerOneTwo(scan.next())) {
                choice = getChoiceValue();
            } else {
                choice = 3;
            };
            if (choice == 2) {
                bool = false;
                keepChoosing = false;
            } else if (choice == 1) {
                System.out.println(visual.getSplitter());
            } else {
                keepChoosing = true;
            }
        }
        return bool;
    }

    public boolean getCheckerOneTwo(String input) {
        boolean check;
        if (input.equals("1") || input.equals("2")) {
            check = true;
            choiceValue = Integer.parseInt(input);
        } else {
            System.out.println("Invalid entry!");
            check = false;
        }
        return check;
    }

    public boolean getCheckerOneThroughThree(String input) {
        boolean check;
        if (input.equals("1") || input.equals("2") || input.equals("3")) {
            check = true;
            choiceValue = Integer.parseInt(input);
        } else {
            System.out.println("Invalid entry!");
            check = false;
        }
        return check;
    }

    public boolean getCheckerOneThroughFour(String input) {
        boolean check;
        if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")) {
            check = true;
            choiceValue = Integer.parseInt(input);
        } else {
            System.out.println("Invalid entry!");
            check = false;
        }
        return check;
    }

    public boolean getCheckerOneThroughFive(String input) {
        boolean check;
        if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5")) {
            check = true;
            choiceValue = Integer.parseInt(input);
        } else {
            System.out.println("Invalid entry!");
            check = false;
        }
        return check;
    }

    public boolean getCheckerOneThroughSix(String input) {
        boolean check;
        if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5") || input.equals("6")) {
            check = true;
            choiceValue = Integer.parseInt(input);
        } else {
            System.out.println("Invalid entry!");
            check = false;
        }
        return check;
    }

    public boolean getCheckerOneThroughSeven(String input) {
        boolean check;
        if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5") || input.equals("6") || input.equals("7")) {
            check = true;
            choiceValue = Integer.parseInt(input);
        } else {
            System.out.println("Invalid entry!");
            check = false;
        }
        return check;
    }

    public int getChoiceValue() {
        return choiceValue;
    }

    public int getStrengthBoost() {
        return strength;
    }

    public void addStrength() {
        strength++;
    }

    public int getAccuracyBoost() {
        return accuracy;
    }

    public void addAccuracy() {
        accuracy++;
    }

    public int getWitchcraftBoost() {
        return witchcraft;
    }

    public void addWitchcraft() {
        witchcraft++;
    }

    public void healthDamage(int change) {
        healthTracker -= change;
    }

    public void healthAdd(int change) {
        healthTracker += change;
    }

    public int getTotalHealth() {
        return healthTracker;
    }

    public void resetHealth() {
        healthTracker = staticStats.getHealth();
    }

    public void setHealth(int change) {
        healthTracker = change;
    }

    public int runStore(int trjesTotal) {
        int storeChoice;
        Scanner scan = new Scanner(System.in);
        System.out.println(visual.getStoreMenu());
        while (keepBuying) {
            keepChoosing = true;
            System.out.print("Store Clerk: \n --- What'd you like to order, " + heroName + "?: ");
            if (getCheckerOneThroughSeven(scan.next())) {
                storeChoice = getChoiceValue();
            } else {
                storeChoice = 9;
            }
            switch (storeChoice) {
                case 1:
                    if (trjesTotal >= staticStats.getSwordCost()) {
                        if (checkInventory(getInventoryTotal(getSwordTotal(), getKnifeTotal(), getBowTotal(), getPotionTotal()))) {
                            setSwordTotal(1);
                            trjesTotal -= staticStats.getSwordCost();
                        } else {
                            System.out.println("Your inventory is already full!");
                        }
                    } else {
                        System.out.println("You don't have enough Trjes, " + heroName + "!");
                    }
                    break;
                case 2:
                    if (trjesTotal >= staticStats.getKnifeCost()) {
                        if (checkInventory(getInventoryTotal(getSwordTotal(), getKnifeTotal(), getBowTotal(), getPotionTotal()))) {
                            setKnifeTotal(1);
                            trjesTotal -= staticStats.getKnifeCost();
                        } else {
                            System.out.println("Your inventory is already full!");
                        }
                    } else {
                        System.out.println("You don't have enough Trjes, " + heroName + "!");
                    }
                    break;
                case 3:
                    if (trjesTotal >= staticStats.getBowCost()) {
                        if (checkInventory(getInventoryTotal(getSwordTotal(), getKnifeTotal(), getBowTotal(), getPotionTotal()))) {
                            setBowTotal(1);
                            trjesTotal -= staticStats.getBowCost();
                        } else {
                            System.out.println("Your inventory is already full!");
                        }
                    } else {
                        System.out.println("You don't have enough Trjes, " + heroName + "!");
                    }
                    break;
                case 4:
                    if (trjesTotal >= staticStats.getArrowCost()) {
                        setArrowTotal(16);
                        trjesTotal -= staticStats.getArrowCost();
                    } else {
                        System.out.println("You don't have enough Trjes, " + heroName + "!");
                    }
                    break;
                case 5:
                    if (trjesTotal >= staticStats.getPotionCost()) {
                        if (checkInventory(getInventoryTotal(getSwordTotal(), getKnifeTotal(), getBowTotal(), getPotionTotal()))) {
                            setPotionTotal(1);
                            trjesTotal -= staticStats.getPotionCost();
                        } else {
                            System.out.println("Your inventory is already full!");
                        }
                    } else {
                        System.out.println("You don't have enough Trjes, " + heroName + "!");
                    }
                    break;
                case 6:
                    if (trjesTotal >= staticStats.getLeatherCost()) {
                        if (getLeatherArmor() == 0) {
                            setLeatherArmor(1);
                            trjesTotal -= staticStats.getLeatherCost();
                        } else {
                            System.out.println("You already are wearing a set of leather armor!");
                        }
                    } else {
                        System.out.println("You don't have enough Trjes, " + heroName + "!");
                    }
                    break;
                case 7:
                    if (trjesTotal >= staticStats.getIronCost()) {
                        if (getIronArmor() == 0) {
                            setIronArmor(1);
                            trjesTotal -= staticStats.getIronCost();
                        } else {
                            System.out.println("You already are wearing a set of iron armor!");
                        }
                    } else {
                        System.out.println("You don't have enough Trjes, " + heroName + "!");
                    }
                    break;
                default:
                    System.out.println("You didn't enter a valid menu item.");
                    break;
            }
            System.out.println("You have " + trjesTotal + " Trjes in your pouch.");
            while (keepChoosing) {
                System.out.print("Would you like to keep purchasing? \n"
                        + "1) Yes \n"
                        + "2) No \n"
                        + "Enter Selection: ");
                if (getCheckerOneTwo(scan.next())) {
                    keepPurchasing = getChoiceValue();
                } else {
                    keepPurchasing = 3;
                }
                System.out.println(visual.getSplitter());
                if (keepPurchasing == 2) {
                    keepBuying = false;
                    keepChoosing = false;
                    System.out.println("Thanks for shopping, " + heroName + "!");
                } else if (keepPurchasing == 1) {
                    keepBuying = true;
                    keepChoosing = false;

                } else {
                    keepChoosing = true;
                }
            }
        }
        System.out.println(visual.getSplitter());
        return trjesTotal;
    }

    public int runInn(int trjesTotal) {
        int x = 1;
        int innChoice;
        Scanner scan = new Scanner(System.in);
        while (x > 0) {
            System.out.print(visual.getInnMenu());
            if (getCheckerOneThroughThree(scan.next())) {
                innChoice = getChoiceValue();
            } else {
                innChoice = 4;
            }
            System.out.println(visual.getSplitter());
            if (innChoice == 1) {
                trjesTotal -= staticStats.getRoomCost();
                addXP(staticStats.getRoomPurchseXP());
                System.out.println("Resting \nRested. Health increased!");
                if (getTotalHealth() < 41) {
                    healthAdd(10);
                } else {
                    resetHealth();
                }
                System.out.println("Health: " + getTotalHealth());
            } else if (innChoice == 2) {
                if (trjesTotal >= staticStats.getStewCost()) {
                    System.out.println("You spend " + staticStats.getStewCost() + " Trjes on some warm stew.");
                    trjesTotal -= staticStats.getStewCost();
                    addXP(staticStats.getFoodPurchaseXP());
                    if (getHungerTotal() <= 20) {
                        setHungerTotal(10);
                    } else {
                        setHungerTotal(30 - getHungerTotal());
                    }
                    System.out.println("Ahhhhhhh a warm meal to eat! \nHealth replenished!");
                    System.out.println("Your hunger is now at " + getHungerTotal());
                    if (getTotalHealth() < 31) {
                        healthAdd(20);
                    } else {
                        resetHealth();
                    }
                    System.out.println("Your health is now at " + getTotalHealth());
                } else {
                    System.out.println("You don't have enough money to pay for some food!");
                }

            } else if (innChoice == 3) {
                System.out.println("See you around, Stanger!");
                x = 0;
            } else {
            }
            System.out.println(visual.getSplitter());
        }
        return trjesTotal;
    }

    public void addXP(int xp) {
        currentXP += xp;
        xpTotal += xp;
    }

    public void spendXP(int cost) {
        currentXP -= cost;
    }

    public int getFinalXP() {
        return xpTotal;
    }

    public int getCurrentXP() {
        return currentXP;
    }

    public int ArtifactHouse(int trjesTotal) {
        boolean staySelling = true;
        Scanner scan = new Scanner(System.in);
        while (staySelling) {
            int ans;
            int artifactChoice;
            System.out.print(visual.getArtifactHouseMenu());
            if (getCheckerOneTwo(scan.next())) {
                artifactChoice = getChoiceValue();
            } else {
                artifactChoice = 3;
            }
            //add ifs to other classes for options
            if (artifactChoice == 1) {
                if (getTokens() > 0) {
                    System.out.println(getArtifactPossability());
                    trjesTotal += addToTrjes();
                    addXP(staticStats.getQuestItemXP());
                    System.out.print("Would you like to keep selling? \n"
                            + "1) Yes \n"
                            + "2) No \n"
                            + "Enter Selection: ");
                    if (getCheckerOneTwo(scan.next())) {
                        ans = getChoiceValue();
                    } else {
                        ans = 1;
                        staySelling = true;
                    }
                    System.out.println(visual.getSplitter());
                    if (ans == 2) {
                        staySelling = false;
                    } else {
                        staySelling = true;
                    }
                } else {
                    System.out.println("You have no artifacts left to show me, go find some more!");
                    staySelling = false;
                }
            } else if (artifactChoice == 2) {
                System.out.println("Thanks for stopping by!");
                staySelling = false;
            } else if (artifactChoice == 3) {
                System.out.print("Would you like to keep selling? \n"
                        + "1) Yes \n"
                        + "2) No \n"
                        + "Enter Selection: ");
                if (getCheckerOneTwo(scan.next())) {
                    ans = getChoiceValue();
                } else {
                    ans = 1;
                    staySelling = true;
                }
                System.out.println(visual.getSplitter());
                if (ans == 2) {
                    staySelling = false;
                } else {
                    staySelling = true;
                }
            }
        }
        return trjesTotal;
    }

    public void TrainingGrounds() {
        boolean training = true;
        boolean stayTraining;
        int choices;
        Scanner scan = new Scanner(System.in);
        while (training) {
            stayTraining = true;
            System.out.print(visual.getTrainingDialogue());
            if (getCheckerOneThroughFour(scan.next())) {
                choices = getChoiceValue();
                switch (choices) {
                    case 1:
                        if (getCurrentXP() >= 100) {
                            spendXP(100);
                            addStrength();
                            break;
                        } else {
                            System.out.println("You lack the necessary experience! Go out and adventure more!");
                        }
                        break;
                    case 2:
                        if (getCurrentXP() >= 90) {
                            spendXP(90);
                            addAccuracy();
                            break;
                        } else {
                            System.out.println("You lack the necessary experience! Go out and adventure more!");
                            break;
                        }
                    case 3:
                        if (getCurrentXP() >= 200) {
                            spendXP(200);
                            addWitchcraft();
                            break;
                        } else {
                            System.out.println("You lack the necessary experience! Go out and adventure more!");
                            break;
                        }
                    case 4:
                        System.out.println("Thanks for visiting, " + heroName + "!");
                        training = false;
                        break;
                }
                while (stayTraining) {
                    System.out.println(visual.getSplitter());
                    System.out.print("Would you like to continue training? \n(1) Yes \n(2) No"
                            + "\nEnter Selection: ");
                    if (getCheckerOneTwo(scan.next())) {
                        choices = getChoiceValue();
                        stayTraining = false;
                        if (choices == 2) {
                            stayTraining = false;
                            training = false;
                        }
                    }
                }

            }
            System.out.println(visual.getSplitter());
        }
    }

    public int getMagicLevel() {
        return magicLevel;
    }

    public void addMagic() {
        Random rand = new Random();
        int add = rand.nextInt(3) + 1;
        magicLevel += add;
    }

    public int getDragonKills() {
        return dragonKills;
    }

    public void dragonKill() {
        dragonKills++;
    }

    public int Wilderness(int trjesTotal) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        dName = getDragonName();
        System.out.println("You have chosen to enter the wild!");
        healthDamage(rand.nextInt(2) + 1);
        System.out.println(visual.getSplitter());
        System.out.print(visual.getWild());
        if (getCheckerOneThroughThree(scan.next())) {
            select = getChoiceValue();
        } else {
            select = 4;
        }
        if (getTotalHealth() <= 0 || getTotalHealth() <= 0) {
            System.out.println("You died! Game over!");
            System.out.println("Your final XP Score is: " + getFinalXP());
            bc.falseBattle();
            bc.falsePlaying();
            select = 4;
            System.out.println(visual.getSplitter());
            System.out.println(visual.getSplitter());
            System.out.println(visual.getSplitter());
            System.out.println(visual.getSplitter());
        }
        if (select == 1) {
            while (bc.getExplore()) {
                System.out.println(visual.getSplitter());
                System.out.println(getExploration());
                trjesTotal += addToTrjes();
                healthDamage(rand.nextInt(2) + 1);
                addXP(staticStats.getExploreXP());
                System.out.println("Your hunger is " + getHungerTotal());
                int selct = visual.getContinueExplore();
                if (selct == 1) {
                    bc.resetExplore();
                } else {
                    bc.falseExplore();
                    bc.falseBattle();
                }
                if (getHungerTotal() <= 0) {
                    System.out.println("You starved and died! Game over!");
                    System.out.println("Your final XP Score is: " + getFinalXP());
                    bc.falseBattle();
                    bc.falsePlaying();
                    bc.falseExplore();
                    System.out.println(visual.getSplitter());
                    System.out.println(visual.getSplitter());
                    System.out.println(visual.getSplitter());
                    System.out.println(visual.getSplitter());
                }
            }
        }

        if (select == 3) {
            if (bc.getwizDead()) {
                if (getMagicLevel() >= 10) {
                    System.out.println("You enter the Valley of the Magical Demons!");
                    healthDamage(rand.nextInt(2) + 1);
                    System.out.println(visual.getSplitter());
                    System.out.print(visual.getWizardPreface());
                    @SuppressWarnings("unused")
                    String character = scan.next();
                    System.out.println(visual.getSplitter());
                    while (bc.getEngageWiz()) {
                        addXP(staticStats.getWizBattleRoundXP());
                        int magicAttack = getMagicAttack() + getWitchcraftBoost() * 5;
                        int wizAttack = getWizardAttack();
                        System.out.println("Your magic spell: " + magicAttack + "\nSpringscare's Spell: " + wizAttack);
                        int attackResult = getResults(magicAttack, wizAttack) + (2) * (getMagicLevel() - 10);
                        if (attackResult > 0) {
                            dealDamagetoWiz(attackResult);
                            addXP(attackResult);
                        } else if (attackResult < 0) {
                            healthAdd(attackResult);
                        } else {
                            System.out.println("Your attacks counteract each other! No damage dealt!");
                        }
                        if (getTotalHealth() <= 0) {
                            System.out.println("You died! Game over!");

                            System.out.println("Your final XP Score is: " + getFinalXP());
                            bc.falseBattle();
                            bc.falsePlaying();
                            bc.falseEngageWiz();
                            System.out.println(visual.getSplitter());
                            System.out.println(visual.getSplitter());
                            System.out.println(visual.getSplitter());
                            System.out.println(visual.getSplitter());
                        } else if (getWizardHealth() <= 0) {
                            int booty = rand.nextInt(300) + 1000; //do he got the booty????!!!
                            System.out.println(getWizardName() + " has been defeated! \nYou collected " + booty + " Trjes in booty from his valley lair!");
                            System.out.println(visual.getSplitter());
                            System.out.println("Your hunger:" + getHungerTotal());
                            System.out.println("Your Health: " + getTotalHealth());
                            addXP(booty + 1000);
                            System.out.println("Your experience is: " + getCurrentXP());
                            trjesTotal += booty;
                            bc.falseEngageWiz();
                            bc.falsewizDead();
                        } else {
                            boolean wizBattleQuestion = true;
                            System.out.println("Your health: " + getTotalHealth() + "\n" + getWizardName() + "'s health: " + getWizardHealth());
                            System.out.println("Your experience is: " + getCurrentXP());
                            System.out.println("Your hunger: " + getHungerTotal());
                            while (bc.getChoosing()) {
                                System.out.print("Continue the battle? \n (1) Yes \n (2) No \nEnter Selection:");
                                if (getCheckerOneTwo(scan.next())) {
                                    wizNum = getChoiceValue();
                                } else {
                                    wizNum = 3;
                                }
                                System.out.println(visual.getSplitter());
                                if (wizNum == 2) {
                                    bc.falseEngageWiz();
                                    bc.falseChoosing();
                                    System.out.println("Leaving the Valley of the Magical Demons");
                                } else if (wizNum == 3) {
                                    bc.resetChoosing();
                                } else {
                                    bc.falseChoosing();
                                }
                            }
                        }
                        //add the damage reduction from armor protection, maybe make the artifact breastplate into a magical protection
                    }
                } else {
                    System.out.println("Your magical power level isn't high enough to risk facing the Magician!");
                }
            } else {
                System.out.println("You have already killed the wizard!");
            }
            System.out.println(visual.getSplitter());
        } else if (select == 2) {
            if (bc.getBattle()) {
                bc.resetChoosing();
                dragonHealth = staticStats.getDragonHealth();
                System.out.println("\n \nThe dragon " + dName + " approaches!");
                System.out.println(visual.getSplitter());
                while (bc.getBattle()) {
                    addXP(staticStats.getBattleRoundXP());
                    System.out.println(visual.getInventory(getSwordTotal(), getKnifeTotal(), getBowTotal(), getArrowTotal(), getPotionTotal(), getLeatherArmor(), getIronArmor(), getMagicLevel()));
                    System.out.println(visual.getSplitter());
                    setHungerTotal((rand.nextInt(2) + 1) * (-1));
                    hunger = getHungerTotal();
                    result = getBattleResults(visual.getAttack(), getArrowTotal());
                    dragonAttack = getDragonAttack();
                    if (result > dragonAttack) {
                        dragonHealth = returnDamage(result, dragonAttack, dragonHealth);
                        addXP(result - dragonAttack);
                    } else {
                        int healthCheck = getTotalHealth();
                        setHealth(returnDamage(dragonAttack, result, getTotalHealth()));
                        int save = getArmorSave();
                        if (getTotalHealth() + save > healthCheck) {
                            setHealth(healthCheck);
                        } else {
                            healthAdd(save);
                        }
                    }
                    if (getTotalHealth() <= 0) {
                        System.out.println("You died! Game over!");
                        System.out.println("Your final XP Score is: " + getFinalXP());
                        bc.falseBattle();
                        bc.falsePlaying();
                        System.out.println(visual.getSplitter());
                        System.out.println(visual.getSplitter());
                        System.out.println(visual.getSplitter());
                        System.out.println(visual.getSplitter());
                    } else if (hunger <= 0) {
                        System.out.println("You starved and died! Game over!");
                        System.out.println("Your final XP Score is: " + getFinalXP());
                        bc.falseBattle();
                        bc.falsePlaying();
                        System.out.println(visual.getSplitter());
                        System.out.println(visual.getSplitter());
                        System.out.println(visual.getSplitter());
                        System.out.println(visual.getSplitter());
                    } else if (dragonHealth <= 0) {
                        int booty = rand.nextInt(100) + 50; //do he got the booty????!!!
                        System.out.println(dName + " has been defeated! \nYou collected " + booty + " Trjes in booty from his cave!");
                        System.out.println(visual.getSplitter());
                        System.out.println("Your hunger:" + getHungerTotal());
                        System.out.println("Your Health: " + getTotalHealth());
                        addXP(booty + 100); //HE DOOOOOO
                        System.out.println("Your experience is: " + getCurrentXP());
                        addMagic();
                        System.out.println("Magic Level: " + getMagicLevel());
                        removeDeadDragon(dName);
                        trjesTotal += booty;
                        dragonKill();
                        bc.falseBattle();
                        dragonHealth = staticStats.getDragonHealth();
                    } else {
                        bc.resetChoosing();
                        System.out.println("Your health: " + getTotalHealth() + "\n" + dName + "'s health: " + dragonHealth);
                        System.out.println("Your experience is: " + getCurrentXP());
                        System.out.println("Your hunger: " + getHungerTotal());
                        while (bc.getChoosing()) {
                            System.out.println(visual.getSplitter());
                            System.out.print("Continue the battle? \n"
                                    + "1) Yes \n"
                                    + "2) No \n"
                                    + "Enter Selection: ");
                            if (getCheckerOneTwo(scan.next())) {
                                going = getChoiceValue();
                            } else {
                                going = 3;
                            }
                            System.out.println(visual.getSplitter());
                            if (going == 2) {
                                bc.falseBattle();
                                dragonHealth = 100;
                                bc.falseChoosing();
                            } else if (going == 1) {
                                bc.falseChoosing();
                            } else {
                                bc.resetChoosing();
                            }
                        }

                    }
                }
            }
        }
        return trjesTotal;
    }

    /*public int namesSize() {
     System.out.println(dragNames);
        
     return dragNames.size();
     }*/
    public void setDragonNames() {
        for (int i = 0; i < names.length; i++) {
            dragNames.add(names[i]);
        }
    }

    public String getDragonName() {
        String choice;
        Random rand = new Random();
        int nameI = rand.nextInt(dragNames.size());
        choice = dragNames.get(nameI);
        return choice;
    }

    public void removeDeadDragon(String deadName) {
        for (int i = 0; i < dragNames.size(); i++) {
            if (dragNames.get(i).equalsIgnoreCase(deadName)) {
                dragNames.remove(i);
            }
        }
    }

    /*public String getQuestion() {
     Random rand = new Random();
     int select = rand.nextInt(20);
     String words = "";
     switch(select) {
     case 0:
     words = "Hey, have you stopped by the Roaring Boar? Their drinks have no equal in all the land!";
     break;
     case 1:
     words =  "Hey, stranger, we don't like questionable folk around here!";
     break;
     case 2:
     words = "Come back and talk after you've done something for this town!";
     break;
     case 3:
     words = "Got any food? I could use some";
     break;
     case 4:
     words = "My daughter has disappeared, and I worry she was captured by a dragon named Perenth the Creep! Could you find and kill him and rescue her?";
     break;
     //finish to 20
     }
     return words;
     }*/
}
