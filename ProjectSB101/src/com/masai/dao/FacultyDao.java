package com.masai.dao;

import java.util.List;

import com.masai.dto.FacultyDTO;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomewentWrong;

public interface FacultyDao {
	public void Login(String username, String password) throws SomewentWrong, NoRecordFound;
	public List<FacultyDTO> searchByModleNo(int batchId) throws SomewentWrong, NoRecordFound;
}
