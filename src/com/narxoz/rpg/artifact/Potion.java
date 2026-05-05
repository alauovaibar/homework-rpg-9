package com.narxoz.rpg.artifact;


public class Potion extends Artifact {

    private final int healing;

    public Potion(String name, int value, int weight, int healing) {
        super(name, value, weight);
        this.healing = healing;
    }

    public int getHealing() {
        return healing;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}