package henrique.com.CardsBords.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import henrique.com.CardsBords.Model.Board;

public interface BoradsRepository extends JpaRepository<Board, Long>{

}
