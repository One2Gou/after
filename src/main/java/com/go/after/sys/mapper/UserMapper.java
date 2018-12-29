package com.go.after.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.go.after.sys.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dong
 * @since 2018-12-25
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询用于拥有的角色
     *
     * @param pagination
     * @return
     */
    List<Map<String, Object>> listUserToRole(Pagination pagination);

}
