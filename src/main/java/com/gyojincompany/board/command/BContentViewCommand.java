package com.gyojincompany.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gyojincompany.board.dao.BoardDao;
import com.gyojincompany.board.dto.BoardDto;

public class BContentViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String bid = request.getParameter("bid");
		
		BoardDao dao = new BoardDao();
		BoardDto dto = dao.contentView(bid);
		
		request.setAttribute("dto", dto);
		
	}

}
