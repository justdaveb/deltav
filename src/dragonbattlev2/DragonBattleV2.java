package dragonbattlev2;

/*Current Projects towards Version 4.0:
 --------------------------------- CHANGELOG ---------------------------------------------------------------
 --- Converted entire health change system over to DragonInfo, all "health" variables removed from Main (3.6.0)
 --- Cleaned up explore to include health changes and the RARE find (3.6.2)
 --- Changed "Stranger" to heroName (3.6.3)
 --- Ran full gameplay test 10/19/17 to confirm no major bugs in any significant changes to 3.6 and previous
 --- Moved Store to DragonInfo (3.6.4)
 --- Moved inn to DragonInfo (3.6.5)
 --- adjusted XP tracking system to be stored in dragonInfo (3.6.8)
 --- moved artifact house to DragonInfo (3.6.9)
 --- moved the training grounds to DragonInfo (3.6.10)
 --- Shift wilderness and Dragon Battle into its own class file (3.8.0)
 --- shift all Boolean checkers over to its own class as well (3.7.0)
 --- Track dragon kills in DragonInfo (3.7.1)
 --- Repaired the call to BAW class (3.8.1
 --- Fixed the dragonName array to make it fully accesible from BAW (3.8.6)
 --- fixed artifact house exit option in main menu (3.8.2)
 --- moved entire dragonName string set and array initialization over to the baw class, as it is only used by the BAW class (3.9.0)
 --- fixed exploration randInt to include the possability of the greatest treasure (3.9.1)
 --- added three additional artifacts that give strength/accuracy/witchcraft. (4.0.0)

5.0 updates

 --- Adjusted from baw class, move back into DInfo. Too many cross-class calls to dInfo to get it to work (4.1.0)

 Version 5.0: Quest System, GUI interface
 --- fix hunger tracker
 --- Add probability adjustment to new quest items to reduce their likelyhood of being found. Alternate option being greater gold amounts but the item is used already
 --- Add Quest item artifacts, quest givers, and certain dragons that must be killed for rewards. Said rewards could be boosters
 --- add booster potions/items for health and hunger, to either slow loss or increase maximum.
 --- GUI CONVERSION

 */

//peter test comment
import java.util.*;

public class DragonBattleV2 {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        //initiations
        Scanner scan = new Scanner(System.in);
        DragonInfo dInfo = new DragonInfo();
        DAesthetic visual = new DAesthetic();
        DragonBattleStaticStats staticStats = new DragonBattleStaticStats();
        BooleanChecker bc = new BooleanChecker();
        Random rand = new Random();
        //String initiations
        String heroName, variableChecker;
        //integer initiation
        int choices, storeChoice, innChoice, keepPurchasing, going, select, wizNum, hunger, trjesTotal,
                dragonAttack, result, dragonKills, dragonHealth;

        //turn sorter for in-store purchases, look to consolodate this later
        int x = 1;
        boolean market = true;
        //Defined start-game values
        hunger = staticStats.getHunger();
        trjesTotal = staticStats.getTrjes();

        //Int values starting at 0 in the pregame
        dragonAttack = staticStats.getZero();
        result = staticStats.getZero();
        dragonKills = staticStats.getZero();

        visual.getIntroStats();

        System.out.print("Enter your hero's name: ");
        heroName = scan.nextLine();
        dInfo.setHeroName(heroName);
        dInfo.setHungerTotal(hunger);
        System.out.println(visual.getSplitter());
        System.out.print(visual.getIntroduction(heroName));
        @SuppressWarnings("unused")
        String filler = scan.next();
        dInfo.setDragonNames();

        while (bc.getPlaying()) {
            System.out.println(visual.getSplitter());
            //System.out.println(dInfo.namesSize());
            bc.resetBuying();
            bc.resetBattle();
            bc.resetExplore();
            bc.resetSelling();
            bc.resetMarket();
            bc.resetChoosing();
            bc.resetEngageWiz();
            x = 1;
            System.out.println("You have " + trjesTotal + " Trjes in your pouch.");
            System.out.print(visual.getTownInfo());
            if (dInfo.getCheckerOneThroughSeven(scan.next())) {
                choices = dInfo.getChoiceValue();
            } else {
                choices = 8;
            }
            System.out.println(visual.getSplitter());

            if (choices == 1) { //store class
                trjesTotal = dInfo.runStore(trjesTotal);
            } else if (choices == 4) { //artifact class
                trjesTotal = dInfo.ArtifactHouse(trjesTotal);
            } else if (choices == 5) { //market class
                market = bc.getMarket();
                while (market) {
                    market = dInfo.getSalesResult();
                }
                trjesTotal += dInfo.addToTrjes();
                dInfo.addXP(staticStats.getItemSaleXP());
            } else if (choices == 6) { //inventory
                System.out.println(visual.getInventory(dInfo.getSwordTotal(), dInfo.getKnifeTotal(), dInfo.getBowTotal(), dInfo.getArrowTotal(), dInfo.getPotionTotal(), dInfo.getLeatherArmor(), dInfo.getIronArmor(), dInfo.getMagicLevel()));
            } else if (choices == 7) { //training grounds
                dInfo.TrainingGrounds();
            } else if (choices == 3) { //the inn
                trjesTotal = dInfo.runInn(trjesTotal);
            } else if (choices == 2) { //wilderness and battles
                dInfo.Wilderness(trjesTotal);
            }
            if (dInfo.getDragonKills() == 12 && bc.getwizDead() == false) {
                bc.falseBattle();
                bc.falsePlaying();
                System.out.println(visual.getVictoryText());
                int endgameXP = dInfo.getFinalXP() + dInfo.getTotalHealth() + hunger + trjesTotal;
                System.out.println("Your final cumulative experience score is " + endgameXP + "! Congratulations, " + heroName + "!");
                System.out.println(visual.getSplitter());
            } else if (dInfo.getDragonKills() == 12 && bc.getwizDead() == true) {
                System.out.println(visual.getForcedWiz());
                System.out.println(visual.getSplitter());
            }
        }
    }
}
