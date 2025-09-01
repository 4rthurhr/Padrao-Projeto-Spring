package henrique.com.CardsBords.Service;

import org.springframework.stereotype.Service;

import henrique.com.CardsBords.Model.Board;
import henrique.com.CardsBords.Repository.BoradsRepository;

@Service
public class BoardService {
	
	private BoradsRepository boardrepository;
	

	public Board criar(Board bord) {
		return boardrepository.save(bord);
	}

}
