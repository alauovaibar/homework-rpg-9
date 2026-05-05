package com.narxoz.rpg.artifact;


public class Scroll extends Artifact {

    private final String spellName;

    public Scroll(String name, int value, int weight, String spellName) {
        super(name, value, weight);
        this.spellName = spellName;
    }

    public String getSpellName() {
        return spellName;
    }

    @Override
    public void accept(ArtifactVisitor visitor) {
        // TODO: call visitor.visit(this) for double dispatch.
    }
}
