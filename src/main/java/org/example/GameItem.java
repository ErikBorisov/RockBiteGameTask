package org.example;



public class GameItem {
    private String name;
    private Rarity rarity;
    private int upgradeCount;

    public GameItem(String name, Rarity rarity) {
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount = 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    @Override
    public String toString() {
        return "GameItem{" +
                "name='" + name + '\'' +
                ", rarity=" + rarity +
                ", upgradeCount=" + upgradeCount +
                '}';
    }

    public void upgrade() {
        switch (rarity){
            case EPIC:
                upgradeCount++;
                break;
            case LEGENDARY:
                System.out.println("Already Legendary");
            default:
                upgradeRarity();
                break;
        }
    }

    private void upgradeRarity() {
        switch (rarity){
            case COMMON:
                rarity = Rarity.GREAT;
                break;
            case GREAT:
                rarity = Rarity.RARE;
                break;
            case RARE:
                rarity = Rarity.EPIC;
                break;
            case EPIC:
                rarity = Rarity.LEGENDARY;
                upgradeCount = 0;
                break;
            default:
                System.out.println("Already Legendary");
                return;
        }
        upgradeCount = 0;
    }


}
