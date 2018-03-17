package dragonbattlev2;

public class BooleanChecker {

    boolean keepBuying = true;
    boolean keepPlaying = true;
    boolean battle = true;
    boolean staySelling = true;
    boolean marketSelling = true;
    boolean explore = true;
    boolean engageWizard = true;
    boolean wizDead = true;
    boolean keepChoosing = true;
    boolean training = true;
    boolean stayTraining = false;

    //Store booleans

    public boolean getBuying() {
        return keepBuying;
    }

    public void falseBuying() {
        keepBuying = false;
    }

    public void resetBuying() {
        keepBuying = true;
    }

    //playing booleans

    public boolean getPlaying() {
        return keepPlaying;
    }

    public void falsePlaying() {
        keepPlaying = false;
    }

    public void resetPlaying() {
        keepPlaying = true;
    }

    //battle booleans

    public boolean getBattle() {
        return battle;
    }

    public void falseBattle() {
        battle = false;
    }

    public void resetBattle() {
        battle = true;
    }

    //staySelling boolean

    public boolean getSelling() {
        return staySelling;
    }

    public void falseSelling() {
        staySelling = false;
    }

    public void resetSelling() {
        staySelling = true;
    }

    //marketSelling boolean

    public boolean getMarket() {
        return marketSelling;
    }

    public void falseMarket() {
        marketSelling = false;
    }

    public void resetMarket() {
        marketSelling = true;
    }

    //explore boolean

    public boolean getExplore() {
        return explore;
    }

    public void falseExplore() {
        explore = false;
    }

    public void resetExplore() {
        explore = true;
    }

    //engageWizard boolean

    public boolean getWizard() {
        return engageWizard;
    }

    public void falseWizard() {
        engageWizard = false;
    }

    public void resetWizard() {
        engageWizard = true;
    }

    //wizDead boolean

    public boolean getwizDead() {
        return wizDead;
    }

    public void falsewizDead() {
        wizDead = false;
    }

    public void resetwizDead() {
        wizDead = true;
    }

    //keepChoosing boolean

    public boolean getChoosing() {
        return keepChoosing;
    }

    public void falseChoosing() {
        keepChoosing = false;
    }

    public void resetChoosing() {
        keepChoosing = true;
    }

    //training boolean

    public boolean getTraining() {
        return training;
    }

    public void falseTraining() {
        training = false;
    }

    public void resetTraining() {
        training = true;
    }

    //staytraining boolean

    public boolean getstayTraining() {
        return stayTraining;
    }

    public void falsestayTraining() {
        stayTraining = false;
    }

    public void resetstayTraining() {
        stayTraining = true;
    }

    // engageWizard boolean

    public boolean getEngageWiz() {
        return engageWizard;
    }

    public void falseEngageWiz() {
        engageWizard = false;
    }

    public void resetEngageWiz() {
        engageWizard = true;
    }

}
