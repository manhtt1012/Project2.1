package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{

	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "123456"; 
	
	@Override
	public List<BuildingEntity> findAll(String name, Long districtId) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building b WHERE 1=1 ");
		if(name != null && !name.equals("") ) {
			sql.append("AND b.name like '%" + name + "%'  ");
		}
		if(districtId != null) {
			sql.append("AND b.districtid = " + districtId + ""); 
		}
		
		List<BuildingEntity> result = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) {
			
			while(rs.next()) {
				BuildingEntity Building = new BuildingEntity();
				Building.setName(rs.getNString("Name"));
				Building.setStreet(rs.getNString("street"));
				Building.setWard(rs.getNString("ward"));
				Building.setNumberOfBasement(rs.getInt("numberofbasement"));
				result.add(Building);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return result;
	}

	@Override
	public void DeleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}

