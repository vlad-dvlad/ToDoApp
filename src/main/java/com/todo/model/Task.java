package com.todo.model;

/**
 * This class contain fields
 * for task, as id, name, category,
 * isComplete, isImportant
 * @author vlad-dvlad
 * @version 1.0
 * @since 2021-02-04
 */
public class Task {

    private Long id;
    private String title;
    private String category;
    private boolean isComplete;
    private boolean isImportant;

    public Task(Long id, String title, String category, boolean isComplete, boolean isImportant) {
        this.id = id;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", isComplete=" + isComplete +
                ", isImportant=" + isImportant +
                '}';
    }
}
