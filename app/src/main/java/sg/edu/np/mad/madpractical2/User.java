package sg.edu.np.mad.madpractical2;

public class User {
    String name;
    String description;
    Integer id;
    Boolean followed;

    public User() {
        this.name = "TestName";
        this.description = "TestDescription";
        this.id = 0;
        this.followed = followed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getFollowed() {
        return followed;
    }

    public void setFollowed(Boolean followed) {
        this.followed = followed;
    }
}