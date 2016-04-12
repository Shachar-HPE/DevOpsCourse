package tasks;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Task {
    private long id;

    private String taskName;

    private String taskContent;

    public Task() {
        // Jackson deserialization
        this.id = Sequence.getNewId();
    }

    public Task(Long id, String taskName, String taskContent) {
        this.id = id;
        this.taskName = taskName;
        this.taskContent = taskContent;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getTaskName() {
        return taskName;
    }

    @JsonProperty
    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskName(@NotNull String name){
        taskName = name;
    }

    public void setTaskContent(@NotNull String content){
        taskContent = content;
    }
}