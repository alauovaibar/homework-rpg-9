package com.narxoz.rpg;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");

        // 1. Создаем героев
        Hero arthur = new Hero("Arthur", 100, 20, 10);
        arthur.addGold(100);
        arthur.getInventory().addArtifact(new Weapon("Excalibur", 500, 10, 50));
        arthur.getInventory().addArtifact(new Armor("Plate", 200, 30, 20));

        Hero merlin = new Hero("Merlin", 60, 15, 5);
        merlin.restoreMana(100);
        merlin.getInventory().addArtifact(new Scroll("Fireball", 100, 1, "Inferno"));

        // 2. Запускаем движок
        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(List.of(arthur, merlin));

        // 3. Печатаем итог
        System.out.println(result);
        System.out.println("Final State Arthur: " + arthur);
        System.out.println("Final State Merlin: " + merlin);
    }
}