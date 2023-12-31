package org.ey.dto;

import java.util.Date;

public class UserInfoDto {

    private Integer id;
    private Date createddate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }
}
