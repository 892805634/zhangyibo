package com.third.easyprice.bean;

/**
 * @创建人 zhangyibo
 * @创建时间 2018/10/17
 * @描述
 */
public class China {
    int id;
    String name;
    int pid;

    @Override
    public String toString() {
        return "China{" + "id=" + id + ", name='" + name + '\'' + ", pid=" + pid + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }




}
