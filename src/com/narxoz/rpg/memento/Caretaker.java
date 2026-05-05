package com.narxoz.rpg.memento;

import com.narxoz.rpg.combatant.HeroMemento;
import java.util.Stack;

public class Caretaker {
    private final Stack<HeroMemento> history = new Stack<>();

    public void save(HeroMemento memento) {
        if (memento != null) {
            history.push(memento);
        }
    }

    public HeroMemento undo() {
        return history.isEmpty() ? null : history.pop();
    }

    public HeroMemento peek() {
        return history.isEmpty() ? null : history.peek();
    }

    public int size() {
        return history.size();
    }
}