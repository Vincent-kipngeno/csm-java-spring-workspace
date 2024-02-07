package tech.csm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tech.csm.domain.Technology;
import tech.csm.util.DBUtil;

public class TechnologyDaoImpl implements TechnologyDao {

	private Connection con;

	public TechnologyDaoImpl() {
		con = DBUtil.getConnection();
	}

	@Override
	public List<Technology> getAllTechnologies() {
		final String seQuery = "select TechnologyId, TechnologyName from technology_master";
		List<Technology> technologyList = null;
		try {
			PreparedStatement ps = con.prepareStatement(seQuery);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				technologyList = new ArrayList<>();
				do {
					Technology technology = new Technology();
					technology.setTechnologyId(rs.getInt(1));
					technology.setTechnologyName(rs.getString(2));
					technologyList.add(technology);
				} while (rs.next());
			}

		} catch (SQLException sq) {
			sq.printStackTrace();
		}
		return technologyList;
	}

	@Override
	public Technology getTechnologyById(Integer technologyId) {
		final String seQuery = "select TechnologyId, TechnologyName from technology_master where TechnologyId=?";
		Technology t = null;
		try {
			PreparedStatement ps = con.prepareStatement(seQuery);
			ps.setInt(1, technologyId.intValue());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				t = new Technology();
				t.setTechnologyId(rs.getInt(1));
				t.setTechnologyName(rs.getString(2));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return t;
	}
	
	@Override
	public Technology getTechnologyByName(String technologyName) {
		final String seQuery = "select TechnologyId, TechnologyName from technology_master where TechnologyName=?";
		Technology t = null;
		try {
			PreparedStatement ps = con.prepareStatement(seQuery);
			ps.setString(1, technologyName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				t = new Technology();
				t.setTechnologyId(rs.getInt(1));
				t.setTechnologyName(rs.getString(2));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return t;
	}
}
