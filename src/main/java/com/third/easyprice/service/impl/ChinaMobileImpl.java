package com.third.easyprice.service.impl;

import com.third.easyprice.bean.China;
import com.third.easyprice.dao.ChinaMobileDao;
import com.third.easyprice.service.IChinaMobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Zhangyibo
 */
@Service
public class ChinaMobileImpl implements IChinaMobile {
    @Autowired
    private ChinaMobileDao chinaMobileDao;

    /**
     * 插入查询数据
     *
     * @param
     * @return
     */
    @Override
    public void insertData(Map<String, Object> params) {

        chinaMobileDao.insertData(params);

    }


    @Override
    public List<China> getCity() {

        return chinaMobileDao.getCity();
    }
}
