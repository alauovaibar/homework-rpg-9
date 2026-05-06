package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.memento.Caretaker;
import java.util.List;

/**
 * Orchestrates the Chronomancer's Vault demo run.
 */
public class ChronomancerEngine {

    /**
     * Runs the vault sequence for the supplied party.
     *
     * @param party the heroes entering the vault
     * @return a summary of the vault run result
     */
    public VaultRunResult runVault(List<Hero> party) {
        // Инициализация счетчиков
        int mementosCreated = 0;
        int restoredCount = 0;
        int appraisedCount = 0;

        Caretaker caretaker = new Caretaker();

        // Создаем инвентарь хранилища для демонстрации Visitor
        Inventory vaultInventory = new Inventory();
        vaultInventory.addArtifact(new Weapon("Void Blade", 500, 10, 25));
        vaultInventory.addArtifact(new Potion("Time Fluid", 100, 1, 50));
        vaultInventory.addArtifact(new Scroll("Rewind Rune", 200, 1, "Chronos"));
        vaultInventory.addArtifact(new Ring("Loop Band", 1000, 0, 15));
        vaultInventory.addArtifact(new Armor("Crystal Plate", 400, 20, 40));

        for (Hero hero : party) {
            System.out.println("Hero " + hero.getName() + " enters the vault.");

            // ПАТТЕРН MEMENTO: Сохраняем состояние перед опасностью
            caretaker.save(hero.createMemento());
            mementosCreated++;

            System.out.println("Appraising vault artifacts...");
            // ПАТТЕРН VISITOR: Применяем различные операции к инвентарю
            GoldAppraiser appraiser = new GoldAppraiser();
            WeightCalculator physical = new WeightCalculator();
            // Если EnchantmentScanner не создан, его можно пока закомментировать

            vaultInventory.accept(appraiser);
            vaultInventory.accept(physical);

            System.out.println("Total Est. Value: " + appraiser.getTotalValue() + " gold");
            System.out.println("Total Est. Weight: " + physical.getTotalWeight() + " units");
            appraisedCount += vaultInventory.size();

            // Симуляция изменений состояния героя
            System.out.println("A temporal trap activates!");
            hero.takeDamage(80);
            hero.spendGold(50);
            hero.setInventory(new Inventory()); // Герой теряет вещи

            System.out.println("Before rewind: " + hero);

            // ПАТТЕРН MEMENTO: Восстановление состояния
            hero.restoreFromMemento(caretaker.undo());
            restoredCount++;

            System.out.println("After rewind: " + hero);
            System.out.println("---");
        }

        // Возвращаем итоговый результат со всеми собранными данными
        return new VaultRunResult(appraisedCount, mementosCreated, restoredCount);
    }
}