/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shiro.demo.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.shiro.SecurityUtils;
import shiro.demo.model.Task;

/**
 *
 * @author Ravi Kumar
 */
@Stateless
public class TaskDao implements Serializable{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Task> list(){
        //Programatic
       //if( SecurityUtils.getSubject().hasRole("developer")){
        //This also works as expected!
            return entityManager.createQuery("SELECT task FROM Task task").getResultList();
       // }
       // return null;
    }
    
    public Task find(Integer id){
        return entityManager.find(Task.class, id);
    }

    public void delete(Task task){
        entityManager.remove(find(task.getTaskId()));
    }

    public Task add(Task task){
        return entityManager.merge(task);
    }

    public Task edit(Task task){
        return entityManager.merge(task);
    }
    
}
