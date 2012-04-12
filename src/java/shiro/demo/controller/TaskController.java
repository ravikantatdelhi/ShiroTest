/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shiro.demo.controller;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import shiro.demo.dao.TaskDao;
import shiro.demo.model.Task;


/**
 *
 * @author Ravi Kumar
 */

@Named
@SessionScoped
public class TaskController implements Serializable{

    @Inject
    private TaskDao taskDao;
    private List<Task> instanceList;
    private Task instance;
    private Integer instanceId;

    private static final String addView ="addTask";
    private static final String deleteView="deleteTask";
    private static final String editView="editTask";
    private static final String listView="listTask";

    
    public Task newInstance(){
        return new Task();
    }
   
    public void setInstanceId(Integer id){
         instanceId=id;
         if(instanceId == null){
             instance = this.newInstance();
         }else{
             instance = taskDao.find(instanceId);

         }
    }

    public void loadInstanceList(){
        instanceList = taskDao.list();
    }
    public List<Task> getInstanceList(){
        if(instanceList == null)
                loadInstanceList();
        return instanceList;
    }
    public Integer getInstanceId(){
        return instanceId;
    }
     public Task getInstance(){
        return instance;
    }

    public String add(){
        try{
            taskDao.add(instance);
             setMessage("Added Successfully!");
        }catch(Exception ex){
             setMessage("Add Failed!!!");
        }
        loadInstanceList();
        return listView;
    }

    public String edit(){
        try{
        taskDao.edit(instance);
              setMessage("Edited Successfully!");
        }catch(Exception ex){
             setMessage("Edit Failed!!!");
        }
        loadInstanceList();
        return listView;
    }

    public String delete(){
        try{
            taskDao.delete(instance);
              setMessage("Delete Successfully!");
        }catch(Exception ex){
             setMessage("Delete Failed!!!");
        }
        loadInstanceList();
        return listView;
    }

    //VIEW MANAGING
    public String addNewTask(){
        setInstanceId(null);
        return addView;
    }
    public String deleteTask(Integer id){
        setInstanceId(id);
        return deleteView;
    }
    public String editTask(Integer id){
        setInstanceId(id);
        return editView;
    }

    private void setMessage(String message){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
    }
}
