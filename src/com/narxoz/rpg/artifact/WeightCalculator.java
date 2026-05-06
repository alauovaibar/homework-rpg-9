package com.narxoz.rpg.artifact;

public class WeightCalculator implements ArtifactVisitor {
    private int totalWeight = 0;

    @Override
    public void visit(Weapon weapon) { totalWeight += weapon.getWeight(); }
    @Override
    public void visit(Potion potion) { totalWeight += potion.getWeight(); }
    @Override
    public void visit(Scroll scroll) { totalWeight += 1; }
    @Override
    public void visit(Ring ring) { totalWeight += 0; }
    @Override
    public void visit(Armor armor) { totalWeight += armor.getWeight() + 5; }

    public int getTotalWeight() { return totalWeight; }
}