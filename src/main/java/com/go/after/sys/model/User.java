package com.go.after.sys.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author dong
 * @since 2018-12-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 数据效验组
     */
    public interface UserGroup {

        /**
         * 添加
         */
        interface AddUser {

        }

        /**
         * 删除
         */
        interface DelUser {
        }

        /**
         * 修改
         */
        interface EditUser {
        }


    }

    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    @NotNull(message = "用户ID不能为空!", groups = {UserGroup.DelUser.class, UserGroup.EditUser.class})
    private Long userId;



    /**
     * 用户姓名
     */
    @TableField("user_name")
    @NotBlank(message = "用户名不能为空!", groups = {UserGroup.AddUser.class, UserGroup.EditUser.class})
    private String userName;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
