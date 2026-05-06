package com.narxoz.rpg.artifact;

public class GoldAppraiser implements ArtifactVisitor {
    private int totalValue = 0;

    @Override
    public void visit(Weapon weapon) { totalValue += weapon.getValue() + 50; }
    @Override
    public void visit(Potion potion) { totalValue += potion.getValue(); }
    @Override
    public void visit(Scroll scroll) { totalValue += scroll.getValue() * 2; }
    @Override
    public void visit(Ring ring) { totalValue += ring.getValue() + 100; }
    @Override
    public void visit(Armor armor) { totalValue += armor.getValue() + 30; }

    public int getTotalValue() { return totalValue; }
}