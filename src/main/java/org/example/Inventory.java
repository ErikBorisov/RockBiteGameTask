package org.example;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Map<Rarity, Integer>> inventory = new HashMap<String, Map<Rarity, Integer>>();


    public void addItem(GameItem item) {
        Map<Rarity, Integer> itemRarities = inventory.get(item.getName());

        if (itemRarities == null) {
            itemRarities = new HashMap<>();
            inventory.put(item.getName(), itemRarities);
        }

        int currentCount = itemRarities.getOrDefault(item.getRarity(), 0);
        itemRarities.put(item.getRarity(), currentCount + 1);
    }


    public boolean hasEnoughItem(String itemName, Rarity rarity, int count) {
        return inventory.containsKey(itemName) && inventory.get(itemName).getOrDefault(rarity, 0) >= count;
    }

    public void removeItem(String itemName, Rarity rarity, int count) {
        if (hasEnoughItem(itemName, rarity, count)) {
            int currentCount = inventory.get(itemName).get(rarity);
            if (currentCount > count) {
                inventory.get(itemName).put(rarity, currentCount - count);
            } else {
                inventory.get(itemName).remove(rarity);
            }
        } else {
            System.out.println("Not enough item");
        }
    }

    public GameItem upgradeItem(String itemName, Rarity rarity) {
        switch (rarity) {
            case COMMON:
                if (hasEnoughItem(itemName, Rarity.COMMON, 3)) {
                    removeItem(itemName, Rarity.COMMON, 3);
                    return new GameItem(itemName, Rarity.GREAT);
                }
                break;
            case GREAT:
                if (hasEnoughItem(itemName, Rarity.GREAT, 3)) {
                    removeItem(itemName, Rarity.GREAT, 3);
                    return new GameItem(itemName, Rarity.RARE);
                }
                break;
            case RARE:
                if (hasEnoughItem(itemName, Rarity.RARE, 3)) {
                    removeItem(itemName, Rarity.RARE, 3);
                    return new GameItem(itemName, Rarity.EPIC);
                }
                break;
            case EPIC:
                if (hasEnoughItem(itemName, Rarity.EPIC, 2)) {
                    removeItem(itemName, Rarity.EPIC, 2);
                    return new GameItem(itemName, Rarity.EPIC_1);
                }
                break;
            case EPIC_1:
                if (hasEnoughItem(itemName, Rarity.EPIC_1, 2)) {
                    removeItem(itemName, Rarity.EPIC_1, 2);
                    return new GameItem(itemName, Rarity.EPIC_2);
                }
                break;
            case EPIC_2:
                if (hasEnoughItem(itemName, Rarity.EPIC_2, 3)) {
                    removeItem(itemName, Rarity.EPIC_2, 3);
                    return new GameItem(itemName, Rarity.LEGENDARY);
                }
                break;
            default:
                System.out.println("NO ENOUGH ITEM TO UPGRADE");
                break;
        }

        return null;
    }



    private GameItem upgradeEpic(String itemName) {
        if (hasEnoughItem(itemName, Rarity.EPIC, 2)) {
            removeItem(itemName, Rarity.EPIC, 2);
            return new GameItem(itemName, Rarity.EPIC_1);
        }
        return null;
    }

    private GameItem upgradeEpic1(String itemName) {
        if (hasEnoughItem(itemName, Rarity.EPIC_1, 2)) {
            removeItem(itemName, Rarity.EPIC_1, 2);
            return new GameItem(itemName, Rarity.EPIC_2);
        }
        return null;
    }


    public void upgradeMultipleItems(String itemName, Rarity rarity) {
        while (hasEnoughItem(itemName, rarity, 3)) {  // Пока есть 3 предмета нужной редкости
            GameItem upgradedItem = upgradeItem(itemName, rarity);
            if (upgradedItem != null) {
                addItem(upgradedItem);
            }
        }
    }


    public void printInventory() {
        for (Map.Entry<String, Map<Rarity, Integer>> entry : inventory.entrySet()) {
            System.out.println("Item: " + entry.getKey());
            for (Map.Entry<Rarity, Integer> rarity : entry.getValue().entrySet()) {
                System.out.println("Rarity: " + rarity.getKey() + ", Count: " + rarity.getValue());
            }
        }
    }
}

//    public GameItem upgradeItem(String itemName, Rarity rarity) {
//        Rarity nextRarity = getNextRarity(rarity);
//        int requiredCount = (rarity == Rarity.EPIC || rarity == Rarity.EPIC_1) ? 2 : 3;
//
//        if (nextRarity != null && hasEnoughItem(itemName, rarity, requiredCount)) {
//            removeItem(itemName, rarity, requiredCount);
//            return new GameItem(itemName, nextRarity);
//        }
//        return null;
//    }
//
//
//    private Rarity getNextRarity(Rarity current) {
//        switch (current) {
//            case COMMON: return Rarity.GREAT;
//            case GREAT: return Rarity.RARE;
//            case RARE: return Rarity.EPIC;
//            case EPIC: return Rarity.EPIC_1;
//            case EPIC_1: return Rarity.EPIC_2;
//            case EPIC_2: return Rarity.LEGENDARY;
//            default: return null;
//        }
//    }
