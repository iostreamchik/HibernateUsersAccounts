package hibernate.classes;

import javax.persistence.*;

@Entity
@Table(name = "userdata")
public class UserData {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(name = "pass")
    @GeneratedValue
    private Long pass;
    @Column(name = "email")
    private String email;
    @Column(name = "ustatus")
    private Long ustatus;
    @Column(name = "udata")
    private Long udata;

    public UserData() {

    }

    public UserData(String login, Long pass, String email, Long ustatus, Long udata) {
        this.login = login;
        this.pass = pass;
        this.email = email;
        this.ustatus = ustatus;
        this.udata = udata;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getPass() {
        return pass;
    }

    public void setPass(Long pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUstatus() {
        return ustatus;
    }

    public void setUstatus(Long ustatus) {
        this.ustatus = ustatus;
    }

    public Long getUdata() {
        return udata;
    }

    public void setUdata(Long udata) {
        this.udata = udata;
    }
}
