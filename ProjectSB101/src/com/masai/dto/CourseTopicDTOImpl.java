package com.masai.dto;

public class CourseTopicDTOImpl implements CourseTopicDTO {
private int planid;
private int batchId;
private int totaldays;
private String topic ;
private int is_Active;
public CourseTopicDTOImpl() {
	super();
}
public CourseTopicDTOImpl(int planid, int batchId, int totaldays, String topic, int is_Active) {
	super();
	this.planid = planid;
	this.batchId = batchId;
	this.totaldays = totaldays;
	this.topic = topic;
	this.is_Active = is_Active;
}
@Override
public int getPlanid() {
	return planid;
}
@Override
public void setPlanid(int planid) {
	this.planid = planid;
}
@Override
public int getBatchId() {
	return batchId;
}
@Override
public void setBatchId(int batchId) {
	this.batchId = batchId;
}
@Override
public int getTotaldays() {
	return totaldays;
}
@Override
public void setTotaldays(int totaldays) {
	this.totaldays = totaldays;
}
@Override
public String getTopic() {
	return topic;
}
@Override
public void setTopic(String topic) {
	this.topic = topic;
}
@Override
public int getIs_Active() {
	return is_Active;
}
@Override
public void setIs_Active(int is_Active) {
	this.is_Active = is_Active;
}
@Override
public String toString() {
	return "CourseTopicDTOImpl [planid=" + planid + ", batchId=" + batchId + ", totaldays=" + totaldays + ", topic="
			+ topic + ", is_Active=" + is_Active + "]";
}




}
