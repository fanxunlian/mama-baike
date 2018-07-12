package com.mama.baike.entity.topic;

import com.mama.baike.entity.page.PageQuery;

public class TopicQuery extends PageQuery {
    private Integer id;
    private String topicType;
    private String classType;
    private String name;
    private String remark;
    private String topicUid;
    private Integer manageId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTopicUid() {
        return topicUid;
    }

    public void setTopicUid(String topicUid) {
        this.topicUid = topicUid;
    }

    public Integer getManageId() {
        return manageId;
    }

    public void setManageId(Integer manageId) {
        this.manageId = manageId;
    }
}
