package com.robot.mymvpdemo.base;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

/** 家政服务实体
 * Created by leo on 2017/12/14.
 */

@Entity
public class HouseKeeper implements Serializable {

    private static final long serialVersionUID = -6928338831106474607L;
    /**
     * id : 7
     * name : 上门私厨
     * image : http://shequo2o.oss-cn-shanghai.aliyuncs.com/images/2017/11/08/201711081511130069343.jpg
     * brief : 专业技术 口味独选
     * data : {"1":{"text":"\u79c1\u4eba\u8ba2\u5236\u8425\u517b\u9910","img":"http:\/\/shequo2o.oss-cn-shanghai.aliyuncs.com\/images\/2017\/10\/27\/201710271412434586336.jpg"},"2":{"text":"\u6839\u636e\u53e3\u5473\u7279\u5236\u7f8e\u98df","img":"http:\/\/shequo2o.oss-cn-shanghai.aliyuncs.com\/images\/2017\/10\/27\/201710271412586992392.jpg"},"3":{"text":"\u5feb\u901f\u4e0a\u95e8\u670d\u52a1","img":"http:\/\/shequo2o.oss-cn-shanghai.aliyuncs.com\/images\/2017\/10\/27\/201710271413038551871.jpg"},"4":{"text":"\u98df\u6750\u5b89\u5168\u65e0\u5fe7","img":"http:\/\/shequo2o.oss-cn-shanghai.aliyuncs.com\/images\/2017\/10\/27\/201710271413087999802.jpg"}}
     * working : 2小时班制
     * money : 500
     * sort : 200
     * isPast : 1
     * briefText : <p>
     * 餐饮计时服务
     * </p>
     * <p>
     * 菜系自选、厨师上门、优选食材、看得见放心吃
     * </p>
     * userId : 0
     * createdAt : 0
     */

    @Id(autoincrement = true)
    private Long tableId;

    private int id;
    private String name;
    private String image;
    private String brief;
    private String data;
    private String working;
    private String money;
    private int sort;
    private int status;
    private String briefText;
    private int userId;
    private int createdAt;


    @Generated(hash = 1458194745)
    public HouseKeeper() {
    }


    @Generated(hash = 1456088428)
    public HouseKeeper(Long tableId, int id, String name, String image, String brief, String data, String working, String money, int sort, int status, String briefText, int userId, int createdAt) {
        this.tableId = tableId;
        this.id = id;
        this.name = name;
        this.image = image;
        this.brief = brief;
        this.data = data;
        this.working = working;
        this.money = money;
        this.sort = sort;
        this.status = status;
        this.briefText = briefText;
        this.userId = userId;
        this.createdAt = createdAt;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getWorking() {
        return working;
    }

    public void setWorking(String working) {
        this.working = working;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBriefText() {
        return briefText;
    }

    public void setBriefText(String briefText) {
        this.briefText = briefText;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "HouseKeeper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", brief='" + brief + '\'' +
                ", data='" + data + '\'' +
                ", working='" + working + '\'' +
                ", money='" + money + '\'' +
                ", sort=" + sort +
                ", isPast=" + status +
                ", briefText='" + briefText + '\'' +
                ", userId=" + userId +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HouseKeeper that = (HouseKeeper) o;

        if (id != that.id) return false;
        if (sort != that.sort) return false;
        if (status != that.status) return false;
        if (userId != that.userId) return false;
        if (createdAt != that.createdAt) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (brief != null ? !brief.equals(that.brief) : that.brief != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (working != null ? !working.equals(that.working) : that.working != null) return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;
        return briefText != null ? briefText.equals(that.briefText) : that.briefText == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (working != null ? working.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + sort;
        result = 31 * result + status;
        result = 31 * result + (briefText != null ? briefText.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + createdAt;
        return result;
    }

    public Long getTableId() {
        return this.tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }
}
