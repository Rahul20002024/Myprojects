package com.demo.crud.Util;

import com.demo.crud.DAO.FilmDAO;
import com.demo.crud.DTO.FilmDTO;

public class FilmTester {

	public static void main(String[] args) {
		
		FilmDTO dto=new FilmDTO();
		dto.setFilm_name("Avengers");
		dto.setFilm_dirname("Kevin Feige");
		dto.setFilm_budget(800000);
		
		FilmDAO dao=new FilmDAO();
		dao.save(dto);
		//dao.selectALL(3); 
		dao.update(4,"Titanic");
		//dao.delete(4);
		//System.out.println("Film deleted successfully");

	}

}
