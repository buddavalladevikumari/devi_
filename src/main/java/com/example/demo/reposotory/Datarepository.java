package com.example.demo.reposotory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CarData;

@Repository("dataRepository")
public class Datarepository {

//	@Autowired
//	private JDBCType template;

	@Autowired
	private JdbcTemplate temp;

	@Autowired
	private DataSource datasrc;

	public int addcar(CarData entity) {
//		SimpleJdbcInsert inserter = new SimpleJdbcInsert(template);
//		SimpleJdbcInsert inserter = new SimpleJdbcInsert(datasrc);
//		inserter.withTableName("cardata").usingColumns("");
//		BeanPropertySqlParameterSource sql = new BeanPropertySqlParameterSource(entity);
//		return inserter.execute(sql);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasrc);
//		String sqlInsert = "INSERT INTO contact (name, email, address) VALUES (?, ?, ?)";
//		jdbcTemplate.update(sqlInsert, "Tom", "tomea@mail.com", "USA");
		String sqlInsert = "INSERT INTO cardata (carnumber,model,year_of_manufacture,kilometerts_travalled,ownername,status) VALUES (?, ?, ?,?,?,?)";
//		jdbcTemplate.update(sqlInsert, 6778, "maruthi", 2019, 4567, "devi", "sold");
//		
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(datasrc);
		insertActor.withTableName("cardata");
		Map<String, Object> params = new HashMap<>();
		params.put("carnumber", 6778);
		params.put("model", "maruthi");
		params.put("year_of_manufacture", 2019);
		params.put("kilometerts_travalled", 4567);
		params.put("ownername", "deviu");
		params.put("status", "sold");

		int result = insertActor.execute(params);
		return result;

	}

	public List<CarData> getallcardata() {

		String sql = "select * from CarData";

		List<CarData> custList = temp.query(sql, BeanPropertyRowMapper.newInstance(CarData.class));
		
		for(CarData c:custList) {
			System.out.println(c);
		}

		return custList;
	}

//	public void addcar(CarData cardata) {
//		// TODO Auto-generated method stub
//
//	}

}
