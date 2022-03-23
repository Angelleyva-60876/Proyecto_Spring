package mx.uacam.fi.al60876.mueble.repository;

import mx.uacam.fi.al60876.mueble.Model.Mueble;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuebleRepository extends CrudRepository<Mueble,Integer> {
}
