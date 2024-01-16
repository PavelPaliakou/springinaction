package sia.tacocloud.tacos.repository;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.tacos.Taco;

public interface TacoRepository extends CrudRepository<Long, Taco> {
}
