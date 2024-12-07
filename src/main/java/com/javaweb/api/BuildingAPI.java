package com.javaweb.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;
import com.mysql.cj.protocol.Resultset;

@RestController
public class BuildingAPI {

	@Autowired
	private BuildingService buildingService;
	
	
	@GetMapping(value = "api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam(name = "name", required = false) String name,
			                             @RequestParam(name = "districtid", required = false) Long district,
			                             @RequestParam(name = "typeCode", required = false) List<String> typeCode){
		List<BuildingDTO> result = buildingService.findAll(name, district);
		return result;
		
	}

//	@RequestMapping(value = "/api/building/", method = RequestMethod.POST)
//	public Object getBuilding2(@RequestBody BuildingDTO buildingDTO) {
//
////		try {
////			
////			valiDate(buildingDTO);
////		} catch (Exception e) {
////			ErrorCustom err = new ErrorCustom();
////			err.setName(e.getMessage());
////			List<String> detail = new ArrayList<String>();
////			detail.add("check lai name di");
////			err.setDetail(detail);
////			return err;
////		}
//		System.out.print(5 / 0);
//
//		return 0; // chỉ là test thoi
//
//	}

	public void valiDate(BuildingDTO buildingDTO) throws FieldRequiredException {
		if (buildingDTO.getName() == null || buildingDTO.getName().equals("")) {
			throw new FieldRequiredException("name is null");
		}
	}

//	@RequestMapping(value = "/api/building/", method = RequestMethod.POST)
//	public void getBuilding2(@RequestBody BuildingDTO buildingDTO) {
//		System.out.print("ok");
//		
//	}

}
