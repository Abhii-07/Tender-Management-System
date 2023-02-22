package com.project.Dao;

import java.util.List;

import com.project.Bean.Tender;


public interface TenderDao {

	public List<Tender> getAllTenders();

	public String createTender(Tender tender);

	public String updateTender(Tender tender);

	public Tender getTenderDataById(int tenderId);

	public String getTenderStatus(int tenderId);

	public String assignTender(int tenderId);

	public List<Tender> getAllAssignedTenders();
	
	public int getTenderId(Tender tender);
	
	
}
