package dragonbattlev2;

public class DragonBattleStaticStats {

    //Default Character stats at startup

    private final int health = 50;
    private final int hunger = 30;
    private final int startingCash = 100;
    private final int nullStart = 0;
    //Default health values for opponents
    private final int dragonHealth = 100;
    //costs for items
    private final int swordCost = 50;
    private final int bowCost = 35;
    private final int potionCost = 15;
    private final int arrowCost = 15;
    private final int leatherCost = 20;
    private final int ironCost = 45;
    private final int knifeCost = 25;
    //resale price for items
    private final int sellSword = 40;
    private final int sellBow = 28;
    private final int sellPotion = 12;
    private final int sellKnife = 22;
    //Inn Prices
    private final int stewCost = 10;
    private final int roomCost = 5;
    //XP values for occurences
    private final int foodPurchaseXP = 5;
    private final int roomPurchaseXP = 5;
    private final int itemSaleXP = 12;
    private final int questItemXP = 15;
    private final int exploreXP = 1;
    private final int battleRoundXP = 2;
    private final int wizBattleRoundXP = 4;

    public int getHealth() {
        return health;
    }

    public int getHunger() {
        return hunger;
    }

    public int getTrjes() {
        return startingCash;
    }

    public int getZero() {
        return nullStart;
    }

    public int getSwordCost() {
        return swordCost;
    }

    public int getBowCost() {
        return bowCost;
    }

    public int getPotionCost() {
        return potionCost;
    }

    public int getArrowCost() {
        return arrowCost;
    }

    public int getLeatherCost() {
        return leatherCost;
    }

    public int getIronCost() {
        return ironCost;
    }

    public int getKnifeCost() {
        return knifeCost;
    }

    public int getSwordSale() {
        return sellSword;
    }

    public int getBowSale() {
        return sellBow;
    }

    public int getKnifeSale() {
        return sellKnife;
    }

    public int getPotionSale() {
        return sellPotion;
    }

    public int getStewCost() {
        return stewCost;
    }

    public int getRoomCost() {
        return roomCost;
    }

    public int getDragonHealth() {
        return dragonHealth;
    }

    public int getFoodPurchaseXP() {
        return foodPurchaseXP;
    }

    public int getRoomPurchseXP() {
        return roomPurchaseXP;
    }

    public int getItemSaleXP() {
        return itemSaleXP;
    }

    public int getQuestItemXP() {
        return questItemXP;
    }

    public int getExploreXP() {
        return exploreXP;
    }

    public int getBattleRoundXP() {
        return battleRoundXP;
    }

    public int getWizBattleRoundXP() {
        return wizBattleRoundXP;
    }
}
