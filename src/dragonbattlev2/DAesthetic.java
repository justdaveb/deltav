package dragonbattlev2;

import java.util.*;

public class DAesthetic {

    public String getSplitter() {
        return "--------------------------------------------------------";
    }

    public String getTownInfo() {
        String info = "Welcome to the pristine town of Bethelroar!  \nYou may: \n (1) Enter the town store \n (2) Go into the wild! \n (3) Enter the Inn \n (4) Enter the Artifact House \n (5) Head to the Flea Market \n (6) Check your Inventory \n (7) Enter the Training Grounds \nEnter number value to make selection: ";
        return info;
    }

    public String getStoreMenu() {
        DragonBattleStaticStats staticStats = new DragonBattleStaticStats();
        String menu = "Welcome to the Bethelroar Town Supply: \nSupplies Available: \n (1) Longsword: " + staticStats.getSwordCost() + " Trjes \n (2) Throwing Blades: " + staticStats.getKnifeCost() + " Trjes \n (3) Longbow: " + staticStats.getBowCost() + " Trjes \n"
                + " (4) Arrows (Stack of 16): " + staticStats.getArrowCost() + " Trjes \n (5) Damage Potion: " + staticStats.getPotionCost() + " Trjes \n (6) Leather Armor: " + staticStats.getLeatherCost() + " Trjes \n (7) Iron Armor: " + staticStats.getIronCost() + " Trjes";
        return menu;
    }

    public String getArtifactHouseMenu() {
        DragonInfo dInfo = new DragonInfo();
        String menu = "'Welcome, " + dInfo.getHeroName() + ", to the house of artifacts. Do you have an artifact you would like to reveal to me?' \n (1) 'Yes, could you take a look?' \n"
                + " (2) 'No, I'll be gone now' \nEnter Selection: ";
        return menu;
    }

    public String getInventory(int sword, int knives, int bow, int arrows, int potion, int leather, int iron, int magic) {
        String inventory = "Inventory: \nSwords: " + sword + "\nKnives: " + knives + "\nBows: " + bow + "\nArrows: " + arrows + "\nPotions: "
                + potion + "\nLeather Armor: " + leather + "\nIron Armor: " + iron + "\nMagic Level: " + magic;
        return inventory;
    }

    public int getAttack() {
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        System.out.print("Choose your weapon: \n (1) Sword \n (2) Throwing Knives \n (3) Bow \n (4) Damage Potion \nSelection: ");
        int choice = scan.nextInt();//one more catch here for variables
        return choice;
    }

    public String getInnMenu() {
        String innMenu = "Welcome to the Roaring Boar, the best inn on this side of the DragonFells! \nWhat'd you like, mister? \n (1) 'I would like to rent a room for the night' \n"
                + " (2) 'Some food to eat, if you would?' \n (3) 'Nothing, I'll be leaving now' \nMake your selection: ";
        return innMenu;
    }

    public String getWild() {
        String wild = "You've entered the " + getWildernessName() + "\n (1) Explore \n (2) Head for the mountains, and the Vale of Dragons \n (3) Enter the Valley of the Magical Demons\nEnter selection: ";
        return wild;
    }

    public String getExploreChoice() {
        String choice = "Would you like to keep exploring? \n (1) Yes \n (2) No";
        return choice;
    }

    public int getContinueExplore() {
        DragonInfo dInfo = new DragonInfo();
        boolean keepChecking = true;
        int choice = 0;
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        while (keepChecking) {
            System.out.print("Would you like to continue exploring? \n (1) Yes \n (2) No \nEnter Selection: ");
            if (dInfo.getCheckerOneTwo(scan.next())) {
                keepChecking = false;
                choice = dInfo.getChoiceValue();
            } else {
                keepChecking = true;
            }
        }
        return choice;
    }

    public String getWildernessName() {
        String[] names = {"Wild lands of Hassayampa", "Fissure of the Glacier", "Hills of the Diablo", "Old Chasm", "Cricketthorn Woods", "Troglodyte's Desert",
            "Sinking Canyon", "Halfling Fen", "Northern Pinnacle", "Howling Plains", "Black Forest", "Devil Rock", "Resonant Caverns"};
        Random rand = new Random();
        return names[rand.nextInt(names.length)];
    }

    public String getVictoryText() {
        String text = "You've defeated the dragon oppression of Belecthor! You are truly a hero among the one's of legend!";
        return text;
    }

    public String getIntroduction(String name) {
        String str = "Welcome to Dragons and Mages! \nYou are a mysterious hero, exploring the land in search of justice and adventure. \nYou have arrived near a town"
                + " in need of a hero to save them from a dragon infestation. \nA 12-dragon clan resides in the Vale, and a wicked Mage resides in the wild lands. Collect items and money to gain weapons and armor \n"
                + "to defeat them! Good luck, o mighty " + name + "! \n" + "Enter any character to begin: ";
        return str;
    }

    public String getWizardPreface() {
        DragonInfo dInfo = new DragonInfo();
        String str = "The evil " + dInfo.getWizardName() + " approaches you. \nPrepare for a magical battle! \nEnter any character to begin: ";
        return str;
    }

    public String getMarketMenu() {
        DragonBattleStaticStats staticStats = new DragonBattleStaticStats();
        String str = "Welcome to the Belecthor Flea Market? What would you like to sell? \n"
                + "1) Swords (" + staticStats.getSwordSale() + " Trjes) \n"
                + "2) Throwing Knives (" + staticStats.getKnifeSale() + " Trjes)\n"
                + "3) Bows (" + staticStats.getBowSale() + " Trjes)\n"
                + "4) Potions (" + staticStats.getPotionSale() + " Trjes)\n"
                + "5) Nothing, I'll be leaving now... \n"
                + "Enter selection: ";
        return str;
    }

    public void getIntroStats() {
        System.out.println(getSplitter());
        System.out.println("Version 4.1.0");
        System.out.println("Current High Score: 1557 Experience");
        System.out.println(getSplitter());
    }

    public String getForcedWiz() {
        String words = "You have killed off all the dragons! Only the evil wizard remains to be defeated.";
        return words;
    }

    public String getTrainingDialogue() {
        String words = "Welcome to the training center! What skill would you like to train? \n (1) Strength \n (2) Accuracy \n "
                + "(3) Witchcraft \n (4) Nothing, I'll be leaving... \nEnter selection: ";
        return words;
    }
}
