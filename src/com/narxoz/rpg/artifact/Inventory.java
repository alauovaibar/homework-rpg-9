package com.narxoz.rpg.artifact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Container for a hero's or vault's artifact collection.
 */
public class Inventory {

    private final List<Artifact> artifacts;

    // Конструктор для создания пустого инвентаря
    public Inventory() {
        this.artifacts = new ArrayList<>();
    }

    // Конструктор для создания инвентаря на основе существующего списка (используется в copy)
    public Inventory(List<Artifact> artifacts) {
        this.artifacts = artifacts == null ? new ArrayList<>() : new ArrayList<>(artifacts);
    }

    public int size() {
        return artifacts.size();
    }

    /**
     * Visits each artifact in order.
     *
     * @param visitor the visitor to apply to each artifact
     */
    public void accept(ArtifactVisitor visitor) {
        for (Artifact artifact : artifacts) {
            artifact.accept(visitor);
        }
    }

    /**
     * Creates a shallow copy of this inventory.
     *
     * @return a new inventory containing the same artifact references
     */
    public Inventory copy() {
        // Оставляем только один корректный возврат
        return new Inventory(new ArrayList<>(this.artifacts));
    }

    // Не забудьте добавить метод для добавления артефактов, иначе инвентарь будет всегда пуст
    public void addArtifact(Artifact artifact) {
        if (artifact != null) {
            artifacts.add(artifact);
        }
    }

    public List<Artifact> getArtifacts() {
        return Collections.unmodifiableList(artifacts);
    }
}