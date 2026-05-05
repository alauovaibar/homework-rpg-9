package com.narxoz.rpg.artifact;


public class Ring extends Artifact {

    private final int magicBonus;

    public Ring(String name, int value, int weight, int magicBonus) {
        super(name, value, weight);
        this.magicBonus = magicBonus;
    }

    public int getMagicBonus() {
        return magicBonus;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}