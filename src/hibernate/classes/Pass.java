package hibernate.classes;

import javax.persistence.*;

@Entity
@Table(name="pass")
public class Pass {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "upass")
    private String upass;

    public Pass() {

    }

    public Pass(String upass) {
        this.upass = upass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }
}
