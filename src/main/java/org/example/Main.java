package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameItem gameItem = new GameItem("GameItem", Rarity.COMMON);

        gameItem.upgrade();
        System.out.println(gameItem);


        gameItem.upgrade();
        System.out.println(gameItem);

        gameItem.upgrade();
        System.out.println(gameItem);

        gameItem.upgrade();
        System.out.println(gameItem);

        gameItem.upgrade();
        System.out.println(gameItem);

        gameItem.upgrade();
        System.out.println(gameItem);

    }
}