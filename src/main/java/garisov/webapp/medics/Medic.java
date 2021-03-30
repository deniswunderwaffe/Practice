package garisov.webapp.medics;

public class Medic {
    private int id;
    private String name;
    private int experience;
    private String domain;
    private String post;
    private String info;

    public Medic(int id, String name, int experience, String domain, String post, String info) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.domain = domain;
        this.post = post;
        this.info = info;
    }

    public Medic() {

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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}