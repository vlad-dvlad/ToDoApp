package com.todo.web;

import com.todo.dao.TaskDAO;
import com.todo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is main controller, which
 * perform CRUD operation
 */

@RestController
@RequestMapping("/app/todo/")
public class ToDoController {

    @Autowired
    private TaskDAO taskDAO;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> getTask(@PathVariable("id") Long id){
        if (id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Task task = this.taskDAO.getTaskById(id);

        if(task == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        HttpHeaders headers = new HttpHeaders();

        if(task == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.taskDAO.createTask(task);
        return new ResponseEntity<>(task, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        HttpHeaders headers = new HttpHeaders();

        if(task == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.taskDAO.updateTask(task);
        return new ResponseEntity<>(task, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Task> deleteTask(@PathVariable("id") Long id){
        Task task = this.taskDAO.getTaskById(id);

        if(task == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.taskDAO.deleteTask(task);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = this.taskDAO.getAllTask();

        if(tasks.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
