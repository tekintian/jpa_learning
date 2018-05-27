package cn.tekin.jpa.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Teacher
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int tid;
    private String tname;
    private String subject;

    @ManyToMany(targetEntity=Banji.class)
    private Set banjiSet;

    public Set getBanjiSet() {
        return banjiSet;
    }

    public void setBanjiSet(Set banjiSet) {
        this.banjiSet = banjiSet;
    }

    public Teacher()
    {
        super();
    }
    public Teacher(int tid, String tname, String subject,
                   Set banjiSet)
    {
        super();
        this.tid = tid;
        this.tname = tname;
        this.subject = subject;
        this.banjiSet = banjiSet;
    }
    public int getTid()
    {
        return tid;
    }
    public void setTid(int tid)
    {
        this.tid = tid;
    }
    public String getTname()
    {
        return tname;
    }
    public void setTname(String tname)
    {
        this.tname = tname;
    }
    public String getSubject()
    {
        return subject;
    }
    public void setSubject(String subject)
    {
        this.subject = subject;
    }

}