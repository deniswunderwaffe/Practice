package garisov.webapp.dao;

import garisov.webapp.medics.Medic;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicMapper implements RowMapper<Medic> {
    @Override
    public Medic mapRow(ResultSet resultSet, int i) throws SQLException {
        Medic medic = new Medic();

        medic.setId(resultSet.getInt("id"));
        medic.setName(resultSet.getString("name"));
        medic.setDomain(resultSet.getString("domain"));
        medic.setExperience(resultSet.getInt("experience"));
        medic.setPost(resultSet.getString("post"));
        medic.setInfo(resultSet.getString("info"));

        return medic;
    }
}
