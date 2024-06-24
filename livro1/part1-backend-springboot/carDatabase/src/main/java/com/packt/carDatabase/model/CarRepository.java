package com.packt.carDatabase.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;


@RepositoryRestResource(path="vehicles")
public interface CarRepository extends CrudRepository<Car,Long>{
    List<Car> findByBrand(@Param("brand") String brand);
}
