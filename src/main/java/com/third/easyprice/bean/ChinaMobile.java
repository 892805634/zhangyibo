package com.third.easyprice.bean;

/**
 * @创建人 zhangyibo
 * @创建时间 2018/10/17
 * @描述
 */
public class  ChinaMobile {
    private String title ;
    private String province ;
    private String city ;
    private String district  ;
    private String address ;
    private String lng ;
    private String lat ;

    @Override
    public String toString() {
        return "TencentApi{" + "title='" + title + '\'' + ", province='" + province + '\'' + ", city='" + city + '\'' + ", district='" + district + '\'' + ", address='" + address + '\'' + ", lng='" + lng + '\'' + ", lat='" + lat + '\'' + '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
