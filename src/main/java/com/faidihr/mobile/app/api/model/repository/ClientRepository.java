package com.faidihr.mobile.app.api.model.repository;


import com.faidihr.mobile.app.api.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {

     List<Client> findClientsByActiveStatus(Integer status);

     public Client findClientsByAdminEmailAndActiveStatus(String email,Integer status);
}
