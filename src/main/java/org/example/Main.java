package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addItem(new GameItem("knight's shield", Rarity.COMMON));
        inventory.addItem(new GameItem("knight's shield", Rarity.COMMON));
        inventory.addItem(new GameItem("knight's shield", Rarity.COMMON));
        inventory.addItem(new GameItem("knight's shield", Rarity.COMMON));
        inventory.addItem(new GameItem("knight's shield", Rarity.COMMON));
        inventory.addItem(new GameItem("knight's shield", Rarity.COMMON));
        inventory.addItem(new GameItem("knight's shield", Rarity.COMMON));

        System.out.println("Before upgraded");
        inventory.printInventory();


        inventory.upgradeMultipleItems("knight's shield", Rarity.COMMON);


        System.out.println("After upgraded");
        inventory.printInventory();


//        GameItem gameItem = new GameItem("GameItem", Rarity.COMMON);
//
//        gameItem.upgrade();
//        System.out.println(gameItem);
//
//
//        gameItem.upgrade();
//        System.out.println(gameItem);
//
//        gameItem.upgrade();
//        System.out.println(gameItem);
//
//        gameItem.upgrade();
//        System.out.println(gameItem);
//
//        gameItem.upgrade();
//        System.out.println(gameItem);
//
//        gameItem.upgrade();
//        System.out.println(gameItem);

    }
}