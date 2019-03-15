package com.third.easyprice.service;


import com.third.easyprice.bean.China;
import java.util.List;
import java.util.Map;

/**
 * @author Zhangyibo
 */
public interface IChinaMobile {
      void insertData(Map<String, Object> params);
      List<China> getCity();
}
