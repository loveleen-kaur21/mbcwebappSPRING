package net.codejava.mbcwebapp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tips")
public class Tip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @Column(name = "createdDate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    public Date createdDate;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    public Tip() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
