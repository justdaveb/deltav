package dragonbattlev2;

import java.util.*;

public class BattlesAndWilderness {

    Scanner scan = new Scanner(System.in);
    DAesthetic visual = new DAesthetic();
    DragonInfo dInfo = new DragonInfo();
    DragonBattleStaticStats staticStats = new DragonBattleStaticStats();
    BooleanChecker bc = new BooleanChecker();
    Random rand = new Random();
    int select;
    int wizNum;
    int dragonHealth;
    int hunger;
    int result;
    int dragonAttack;
    int going;
    String dName;
    private String[] names = {"Smaug", "Belthcor", "Deascrith", "Ungol the Mighty", "Kenith the Adorable", "Brynioth",
        "Ith", "Perenth the Creep", "Ohm the Deathlord", "Lagrocius, Lord of the Skies", "Franae, the Eater of Bunnies", "Visalauth the Strong"};
    LinkedList<String> dragNames = new LinkedList<String>();
    

    public int Wilderness(int trjesTotal) {
        dName = getDragonName();
        System.out.println("You have chosen to enter the wild!");
        dInfo.healthDamage(rand.nextInt(2) + 1);
        System.out.println(visual.getSplitter());
        System.out.print(visual.getWild());
        if (dInfo.getCheckerOneThroughThree(scan.next())) {
            select = dInfo.getChoiceValue();
        } else {
            select = 4;
        }
        if (dInfo.getTotalHealth() <= 0 || dInfo.getTotalHealth() <= 0) {
            System.out.println("You died! Game over!");
            System.out.println("Your final XP Score is: " + dInfo.getFinalXP());
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
                System.out.println(dInfo.getExploration());
                trjesTotal += dInfo.addToTrjes();
                dInfo.healthDamage(rand.nextInt(2) + 1);
                dInfo.addXP(staticStats.getExploreXP());
                System.out.println("Your hunger is " + dInfo.getHungerTotal());
                int selct = visual.getContinueExplore();
                if (selct == 1) {
                    bc.resetExplore();
                } else {
                    bc.falseExplore();
                    bc.falseBattle();
                }
                if (dInfo.getHungerTotal() <= 0) {
                    System.out.println("You starved and died! Game over!");
                    System.out.println("Your final XP Score is: " + dInfo.getFinalXP());
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
                if (dInfo.getMagicLevel() >= 10) {
                    System.out.println("You enter the Valley of the Magical Demons!");
                    dInfo.healthDamage(rand.nextInt(2) + 1);
                    System.out.println(visual.getSplitter());
                    System.out.print(visual.getWizardPreface());
                    @SuppressWarnings("unused")
                    String character = scan.next();
                    System.out.println(visual.getSplitter());
                    while (bc.getEngageWiz()) {
                        dInfo.addXP(staticStats.getWizBattleRoundXP());
                        int magicAttack = dInfo.getMagicAttack() + dInfo.getWitchcraftBoost() * 5;
                        int wizAttack = dInfo.getWizardAttack();
                        System.out.println("Your magic spell: " + magicAttack + "\nSpringscare's Spell: " + wizAttack);
                        int attackResult = dInfo.getResults(magicAttack, wizAttack) + (2) * (dInfo.getMagicLevel() - 10);
                        if (attackResult > 0) {
                            dInfo.dealDamagetoWiz(attackResult);
                            dInfo.addXP(attackResult);
                        } else if (attackResult < 0) {
                            dInfo.healthAdd(attackResult);
                        } else {
                            System.out.println("Your attacks counteract each other! No damage dealt!");
                        }
                        if (dInfo.getTotalHealth() <= 0) {
                            System.out.println("You died! Game over!");

                            System.out.println("Your final XP Score is: " + dInfo.getFinalXP());
                            bc.falseBattle();
                            bc.falsePlaying();
                            bc.falseEngageWiz();
                            System.out.println(visual.getSplitter());
                            System.out.println(visual.getSplitter());
                            System.out.println(visual.getSplitter());
                            System.out.println(visual.getSplitter());
                        } else if (dInfo.getWizardHealth() <= 0) {
                            int booty = rand.nextInt(300) + 1000; //do he got the booty????!!!
                            System.out.println(dInfo.getWizardName() + " has been defeated! \nYou collected " + booty + " Trjes in booty from his valley lair!");
                            System.out.println(visual.getSplitter());
                            System.out.println("Your hunger:" + dInfo.getHungerTotal());
                            System.out.println("Your Health: " + dInfo.getTotalHealth());
                            dInfo.addXP(booty + 1000);
                            System.out.println("Your experience is: " + dInfo.getCurrentXP());
                            trjesTotal += booty;
                            bc.falseEngageWiz();
                            bc.falsewizDead();
                        } else {
                            boolean wizBattleQuestion = true;
                            System.out.println("Your health: " + dInfo.getTotalHealth() + "\n" + dInfo.getWizardName() + "'s health: " + dInfo.getWizardHealth());
                            System.out.println("Your experience is: " + dInfo.getCurrentXP());
                            System.out.println("Your hunger: " + dInfo.getHungerTotal());
                            while (bc.getChoosing()) {
                                System.out.print("Continue the battle? \n (1) Yes \n (2) No \nEnter Selection:");
                                if (dInfo.getCheckerOneTwo(scan.next())) {
                                    wizNum = dInfo.getChoiceValue();
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
                    dInfo.addXP(staticStats.getBattleRoundXP());
                    System.out.println(visual.getInventory(dInfo.getSwordTotal(), dInfo.getKnifeTotal(), dInfo.getBowTotal(), dInfo.getArrowTotal(), dInfo.getPotionTotal(), dInfo.getLeatherArmor(), dInfo.getIronArmor(), dInfo.getMagicLevel()));
                    System.out.println(visual.getSplitter());
                    dInfo.setHungerTotal((rand.nextInt(2) + 1) * (-1));
                    hunger = dInfo.getHungerTotal();
                    result = dInfo.getBattleResults(visual.getAttack(), dInfo.getArrowTotal());
                    dragonAttack = dInfo.getDragonAttack();
                    if (result > dragonAttack) {
                        dragonHealth = dInfo.returnDamage(result, dragonAttack, dragonHealth);
                        dInfo.addXP(result - dragonAttack);
                    } else {
                        int healthCheck = dInfo.getTotalHealth();
                        dInfo.setHealth(dInfo.returnDamage(dragonAttack, result, dInfo.getTotalHealth()));
                        int save = dInfo.getArmorSave();
                        if (dInfo.getTotalHealth() + save > healthCheck) {
                            dInfo.setHealth(healthCheck);
                        } else {
                            dInfo.healthAdd(save);
                        }
                    }
                    if (dInfo.getTotalHealth() <= 0) {
                        System.out.println("You died! Game over!");
                        System.out.println("Your final XP Score is: " + dInfo.getFinalXP());
                        bc.falseBattle();
                        bc.falsePlaying();
                        System.out.println(visual.getSplitter());
                        System.out.println(visual.getSplitter());
                        System.out.println(visual.getSplitter());
                        System.out.println(visual.getSplitter());
                    } else if (hunger <= 0) {
                        System.out.println("You starved and died! Game over!");
                        System.out.println("Your final XP Score is: " + dInfo.getFinalXP());
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
                        System.out.println("Your hunger:" + dInfo.getHungerTotal());
                        System.out.println("Your Health: " + dInfo.getTotalHealth());
                        dInfo.addXP(booty + 100); //HE DOOOOOO
                        System.out.println("Your experience is: " + dInfo.getCurrentXP());
                        dInfo.addMagic();
                        System.out.println("Magic Level: " + dInfo.getMagicLevel());
                        removeDeadDragon(dName);
                        trjesTotal += booty;
                        dInfo.dragonKill();
                        bc.falseBattle();
                        dragonHealth = staticStats.getDragonHealth();
                    } else {
                        bc.resetChoosing();
                        System.out.println("Your health: " + dInfo.getTotalHealth() + "\n" + dName + "'s health: " + dragonHealth);
                        System.out.println("Your experience is: " + dInfo.getCurrentXP());
                        System.out.println("Your hunger: " + dInfo.getHungerTotal());
                        while (bc.getChoosing()) {
                            System.out.println(visual.getSplitter());
                            System.out.print("Continue the battle? \n"
                                    + "1) Yes \n"
                                    + "2) No \n"
                                    + "Enter Selection: ");
                            if (dInfo.getCheckerOneTwo(scan.next())) {
                                going = dInfo.getChoiceValue();
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
        for(int i = 0; i < names.length; i++) {
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
        for(int i = 0; i < dragNames.size(); i++) {
            if(dragNames.get(i).equalsIgnoreCase(deadName)) {
                dragNames.remove(i);
            }
        }
    }
}
