package com.pfe.pfe.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.pfe.pfe.bean.Fonctionnalite;


public class FonctionnaliteMapper implements RowMapper<Fonctionnalite> {
   public Fonctionnalite mapRow(ResultSet rs, int rowNum) throws SQLException {
	   Fonctionnalite student = new Fonctionnalite();
      student.setId(rs.getInt("id"));
      student.setName(rs.getString("name"));
      student.setDesscription(rs.getString("desscription"));
      student.setFileActivation(rs.getString("file_activation"));
      student.setFilaDesactivation(rs.getString("fila_desactivation"));
      student.setFileChek(rs.getString("file_chek"));
      return student;
   }
}