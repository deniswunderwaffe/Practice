package garisov.webapp.dao;

import garisov.webapp.clients.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet resultSet, int i) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getInt("id"));
        client.setName(resultSet.getString("name"));
        client.setPhone(resultSet.getString("phone"));
        client.setEmail(resultSet.getString("email"));

        return client;
    }
}
