package com.bo.redis_demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author bo
 * @DATE 2020/9/16
 **/

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    private String phone;

    private String email;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;

}
