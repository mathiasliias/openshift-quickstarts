package org.openshift.quickstarts.todolist.dao;


import java.util.List;

/**
 *
 */
public interface TodoListDAO {

    void save(String entry);

    List<String> list();
}
