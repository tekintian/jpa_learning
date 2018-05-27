package cn.tekin.jpa.entity;

import javax.persistence.Entity;

@Entity
public class NonTeachingStaff extends Staff
{
    private String areaexpertise;

    public NonTeachingStaff( int sid, String sname,
                             String areaexpertise )
    {
        super( sid, sname );
        this.areaexpertise = areaexpertise;
    }

    public NonTeachingStaff( )
    {
        super( );
    }

    public String getAreaexpertise( )
    {
        return areaexpertise;
    }

    public void setAreaexpertise( String areaexpertise )
    {
        this.areaexpertise = areaexpertise;
    }
}