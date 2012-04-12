/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shiro.demo.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Ravi Kumar
 */
@Entity
@Table(name="task")
public class Task implements Serializable{

    private Integer taskId;
    private String name;
    private String description;
    private Integer priority;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="task_id")
    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

   

}
