package garisov.webapp.dao;

import garisov.webapp.clients.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public ClientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Client client){
        jdbcTemplate.update("INSERT INTO orders(name,phone,email) VALUES(?,?,?)",
                client.getName(),client.getPhone(),client.getEmail());
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM orders " +
                "WHERE id=?",id);
    }
    public List<Client> showClientBase(){
        return jdbcTemplate.query("SELECT * FROM clients",new ClientMapper());
    }
    public List<Client> show(){
        return jdbcTemplate.query("SELECT * FROM orders",new ClientMapper());
    }
}
