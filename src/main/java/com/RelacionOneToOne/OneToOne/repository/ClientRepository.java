package com.RelacionOneToOne.OneToOne.repository;

import com.RelacionOneToOne.OneToOne.domain.Client;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{

}
