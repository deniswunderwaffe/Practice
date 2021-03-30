package garisov.webapp.dao;

import garisov.webapp.medics.Medic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;

@Component
public class MedicDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MedicDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Medic> show(){
        return jdbcTemplate.query("SELECT * FROM medic",new MedicMapper());
        //Если поля совпадают по названиям можно обойтись мапером Спринга
       // return jdbcTemplate.query("SELECT * FROM medic",new BeanPropertyRowMapper<>(Medic.class));
    }
    public Medic showId(int id){
        return jdbcTemplate.query("SELECT * FROM medic WHERE id=?",
                new Object[]{id},
                new MedicMapper()).stream().findAny().orElse(null);
    }
    public void update(int id, Medic updatedMedic){
        jdbcTemplate.update("UPDATE medic SET name =?," +
                        "experience=?,domain=?,post=?,info=? WHERE id =?",
                updatedMedic.getName(),updatedMedic.getExperience(),
                updatedMedic.getDomain(),updatedMedic.getPost(),updatedMedic.getInfo(),
                updatedMedic.getId()
                );
    }
}
