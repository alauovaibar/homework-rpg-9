package com.narxoz.rpg.artifact;

public class Weapon extends Artifact {

    private final int attackBonus;

    public Weapon(String name, int value, int weight, int attackBonus) {
        super(name, value, weight);
        this.attackBonus = attackBonus;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}
