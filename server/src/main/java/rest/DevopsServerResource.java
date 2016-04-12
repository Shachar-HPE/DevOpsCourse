package rest;

import com.codahale.metrics.annotation.Timed;
import tasks.Task;
import tasks.TaskStorage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Collections;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
public class DevopsServerResource {

    private TaskStorage taskStorage;

    public DevopsServerResource(TaskStorage taskStorage) {
        this.taskStorage = taskStorage;
    }

    @GET
    @Timed
    public Collection<Task> getTasks(@QueryParam("id") Long id) {
        Collection<Task> returnCol;
        if (id != null) {
            returnCol = Collections.EMPTY_LIST;
            Task task = taskStorage.getTask(id);
            if (task != null) {
                returnCol.add(task);
            }
        } else {
            returnCol = taskStorage.getAllTasks();
        }
        return returnCol;
    }

    @POST
    @Timed
    public Task addTask(Task task) throws Exception {
        if (task != null) {
            taskStorage.addTask(task);
        }
        return task;
    }

    @PUT
    @Timed
    public Task updateTask(Task task) {
        Task currentTask = null;
        if (task != null) {
            currentTask = taskStorage.getTask(task.getId());
            if (currentTask!=null) {
                currentTask.setTaskName(task.getTaskName());
                currentTask.setTaskContent(task.getTaskContent());
            }
        }
        return currentTask;
    }

    @DELETE
    @Path("/{id}")
    @Timed
    public Task deleteTask(@PathParam("id") Integer id) {
        Task currentTask = null;
        if (id != null) {
            currentTask = taskStorage.removeTask(id);
        }
        return currentTask;
    }
}