package com.narxoz.rpg.artifact;

public class EnchantmentScanner implements ArtifactVisitor {
    @Override
    public void visit(Weapon weapon) { System.out.println("Weapon: " + weapon.getName() + " Power +" + weapon.getAttackBonus()); }
    @Override
    public void visit(Potion potion) { System.out.println("Potion: " + potion.getName() + " Heal " + potion.getHealing()); }
    @Override
    public void visit(Scroll scroll) { System.out.println("Scroll: " + scroll.getName() + " Spell: " + scroll.getSpellName()); }
    @Override
    public void visit(Ring ring) { System.out.println("Ring: " + ring.getName() + " Magic +" + ring.getMagicBonus()); }
    @Override
    public void visit(Armor armor) { System.out.println("Armor: " + armor.getName() + " Def +" + armor.getDefenseBonus()); }
}
