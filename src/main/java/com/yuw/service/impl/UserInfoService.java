package com.yuw.service.impl;

import com.yuw.bean.UserInfoBean;
import com.yuw.dao.UserInfoBeanMapper;
import com.yuw.service.IUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoService implements IUserInfoService {

    // 依赖注入和反转控制
    @Resource
    private UserInfoBeanMapper userInfoM;

    @Override
    public List<UserInfoBean> doLogin(UserInfoBean userInfoBean) {
        // 调用Dao层进行数据库查询操作
        List<UserInfoBean> lstUserInfos = userInfoM.doLogin(userInfoBean);
        return lstUserInfos;
    }

    @Override
    public int saveOrUpdateUserInfo(UserInfoBean userInfoBean) {
        // 默认返回值
        int i = 0;
        // 调用Dao层进行数据库数据保存和修改操作
        // 进行新增还是保存的业务逻辑处理
        // 通过判定实体类中的主键字段 suerid 是否为null，来决定进行新增还是修改操作
        if (userInfoBean != null && userInfoBean.getUserid() != null) {
            // 修改操作
            i = userInfoM.updateByPrimaryKeySelective(userInfoBean);
        } else {
            // 新增操作
            i = userInfoM.insertSelective(userInfoBean);
        }
        return i;
    }

    @Override
    public List<UserInfoBean> selectUserInfoByParams(UserInfoBean record) {
        // 调用dao曾经进行数据库查询操作
        List<UserInfoBean> lstUserInfos = userInfoM.selectUserInfoByParams(record);
        // 返回结果集
        return lstUserInfos;
    }

    @Override
    public int deleteUserInfoByID(Integer userid) {
        // 默认返回值
        int i = 0;
        // 调用Dao层进行删除操作
        // 物理删除
        //i = userInfoM.deleteByPrimaryKey(userid);
        // 逻辑删除
        i = userInfoM.deleteByPrimaryKey4Logic(userid);
        return i;
    }

}
