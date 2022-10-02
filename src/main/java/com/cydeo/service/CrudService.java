package com.cydeo.service;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface CrudService <T,ID> {

    T save (T user);

    T findById(ID username); // UserDTO findById(String username);

    List<T> findAll();  // List<UserDTO> findAll();

    void deleteById(ID username); //void deleteById(String username);
}
