package tasks;

import java.util.*;

public class TaskStorage {
    private Map<Long, Task> taskList;

    public TaskStorage() {
        taskList = new HashMap<Long, Task>();
    }

    public void addTask(Task task) throws Exception {
        if (task != null) {
            if (taskList.get(task.getId()) != null) {
                throw new Exception("task id already exist");
            }
            taskList.put(task.getId(), task);
        }
    }

    public Task removeTask(long taskId) {
        Task removed = taskList.remove(taskId);
        return removed;
    }

    public Task getTask(long id) {
        return taskList.get(id);
    }

    public Collection<Task> getAllTasks() {
        return taskList.values();
    }
}