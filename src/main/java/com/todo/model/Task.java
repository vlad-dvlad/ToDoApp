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

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
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
