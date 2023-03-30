package com.masai.dao;

import java.util.List;

import com.masai.dto.FacultyDTO;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomewentWrong;

public interface FacultyDao {
	public FacultyDTO loginFaculty(String username, String password) throws SomewentWrong;
	
}
