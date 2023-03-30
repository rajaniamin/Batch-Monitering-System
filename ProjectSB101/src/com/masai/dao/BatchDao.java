package com.masai.dao;

import com.masai.dto.BatchDTO;
import com.masai.exception.SomewentWrong;

public interface BatchDao {
	public BatchDTO searchBatchById(String id) throws SomewentWrong;
	public String updateBatch(String str, String set, String name) throws SomewentWrong;
	public String addBatch(BatchDTO batch) throws SomewentWrong;
	public String deleteBatch(String batchId) throws SomewentWrong ;
	public String allocateFaculty(int fName, String batchId) throws SomewentWrong;
}
