package sia.tacocloud.tacos.repository;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.tacos.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}
