package hibernate.classes;


import javax.persistence.*;

@Entity
@Table(name = "firstname")
public class FirstName {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="uname")
    private String uname;

    public FirstName() {
    }

    public FirstName(String uname) {
        this.uname = uname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
