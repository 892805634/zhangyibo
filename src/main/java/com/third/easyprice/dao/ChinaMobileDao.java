package com.third.easyprice.dao;


import com.third.easyprice.bean.China;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Zhangyibo
 */
@Mapper
public interface ChinaMobileDao {
    /**
     * 描述一下方法的作用
     *
     * @param
     * @return
     * @author zhangyibo
     */
    void insertData(Map<String, Object> paramsList);

    /**
     * 描述一下方法的作用
     *
     * @param
     * @return
     * @author zhangyibo
     */
    List<China> getCity();

}
