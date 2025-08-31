package Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Treino;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {

}
