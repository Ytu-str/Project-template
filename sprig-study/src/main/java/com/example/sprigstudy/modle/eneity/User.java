package com.example.sprigstudy.modle.eneity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@TableName(value ="users")
@ApiModel(value="user对象",description="用户对象user")
public class User implements Serializable {

    @ApiModelProperty(value="用户id",name="id")
    @TableId(value ="id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="用户名",name="userName")
    @TableField(value = "userName")
    private String userName;

    @ApiModelProperty(value="用户密码",name="passWord")
    @TableField(value = "passWord")
    private String passWord;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id)
                && Objects.equals(userName, user.userName)
                && Objects.equals(passWord, user.passWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, passWord);
    }
}
