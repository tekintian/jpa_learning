package cn.tekin.jpa.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 班级实体
 */
@Entity
public class Banji {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int cid;
    private String cname;

    @ManyToMany(targetEntity=Teacher.class)
    private Set teacherSet;

    public Banji()
    {
        super();
    }
    public Banji(int cid,
                String cname, Set teacherSet)
    {
        super();
        this.cid = cid;
        this.cname = cname;
        this.teacherSet = teacherSet;
    }
    public int getCid()
    {
        return cid;
    }
    public void setCid(int cid)
    {
        this.cid = cid;
    }
    public String getCname()
    {
        return cname;
    }
    public void setCname(String cname)
    {
        this.cname = cname;
    }
    public Set getTeacherSet()
    {
        return teacherSet;
    }
    public void setTeacherSet(Set teacherSet)
    {
        this.teacherSet = teacherSet;
    }
}
