package henrique.com.CardsBords.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import henrique.com.CardsBords.Model.Board;
import henrique.com.CardsBords.Service.BoardService;

@Controller
public class BoardController {
	
	private BoardService boardService;
	
	@GetMapping
	public Board criar(Board bord) {
		return boardService.criar(bord);
	}

}
