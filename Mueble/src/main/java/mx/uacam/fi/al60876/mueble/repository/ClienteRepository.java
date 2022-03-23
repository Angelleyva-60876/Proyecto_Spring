package mx.uacam.fi.al60876.mueble.repository;

import mx.uacam.fi.al60876.mueble.Model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Integer> {
}
