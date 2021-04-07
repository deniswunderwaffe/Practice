package garisov.webapp.clients;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Client {
    private int id;

    @NotEmpty(message = "Can not be empty!!")
    @Size(min = 2, max = 50,message = "Enter valid name!!")
    private String name;
    @NotEmpty(message = "Enter valid phone!!")
    private String phone;
    @NotEmpty(message = "Can not be empty!!")
    @Email(message = "Enter valid Email!!")
    private String email;

    public Client() {

    }

    public Client(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}