package com.todo.model;

/**
 * This class contain fields
 * for task, as id, name, category,
 * isComplete, isImportant
 */

public class Task {

    private Long id;
    private String name;
    private String category;
    private boolean isComplete;
    private boolean isImportant;

    public Task(Long id, String name, String category, boolean isComplete, boolean isImportant) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isComplete = isComplete;
        this.isImportant = isImportant;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean complete) {
        isComplete = complete;
    }

    public boolean getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(boolean important) {
        isImportant = important;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", isComplete=" + isComplete +
                ", isImportant=" + isImportant +
                '}';
    }
}
