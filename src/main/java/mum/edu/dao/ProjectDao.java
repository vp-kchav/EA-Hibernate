/*
 * Created on Dec 2, 2017
 */
package mum.edu.dao;

import java.util.List;

import mum.edu.constant.TaskStatus;
import mum.edu.model.Project;

public interface ProjectDao extends DataAccessObject<Project,Long> {
    List<Project> getProjectByStatus(TaskStatus status);
}
