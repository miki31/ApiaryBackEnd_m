package domain.repository.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "user" ,schema = "public")
public class User {

    @Id
    @Column(name = "usr_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "usr_login")
    @NotBlank
    private String login;

    @Column(name = "usr_password")
    @NotBlank
    private String pass;

    @Column(name = "usr_role")
    private String role;

    @Column(name = "usr_create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;

    @Column(name = "usr_remove_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate removeDate;

    public User() {
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(LocalDate removeDate) {
        this.removeDate = removeDate;
    }
}
