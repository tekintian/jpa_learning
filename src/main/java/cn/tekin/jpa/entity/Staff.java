package cn.tekin.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @DescriminatorColumn指定字段名称（类型）和它的值显示剩余（Teaching和NonTeachingStaff）字段。
 */
@Entity
@Table
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name="type" )
public class Staff implements Serializable
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int sid;
    private String sname;
    public Staff( int sid, String sname )
    {
        super( );
        this.sid = sid;
        this.sname = sname;
    }
    public Staff( )
    {
        super( );
    }
    public int getSid( )
    {
        return sid;
    }
    public void setSid( int sid )
    {
        this.sid = sid;
    }
    public String getSname( )
    {
        return sname;
    }
    public void setSname( String sname )
    {
        this.sname = sname;
    }
}
