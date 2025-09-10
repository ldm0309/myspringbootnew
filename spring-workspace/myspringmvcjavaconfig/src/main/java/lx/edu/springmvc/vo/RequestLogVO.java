package lx.edu.springmvc.vo;

public class RequestLogVO {
	/*
	 *   ab_id number(11) NOT NULL PRIMARY KEY ,
  ab_name varchar(15) NOT NULL,
  ab_email varchar(50) DEFAULT NULL,
  ab_comdept varchar(20) NOT NULL,
  ab_birth varchar(10) NOT NULL,
  ab_tel varchar(20) DEFAULT NULL,
  ab_memo varchar(100) DEFAULT NULL
	 */
	public int id;
	public String reqClass;
	public String reqMethod;
	public String reqTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReqClass() {
		return reqClass;
	}
	public void setReqClass(String reqClass) {
		this.reqClass = reqClass;
	}
	public String getReqMethod() {
		return reqMethod;
	}
	public void setReqMethod(String reqMethod) {
		this.reqMethod = reqMethod;
	}
	public String getReqTime() {
		return reqTime;
	}
	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}
	@Override
	public String toString() {
		return "RequestLogVO [id=" + id + ", reqClass=" + reqClass + ", reqMethod=" + reqMethod + ", reqTime=" + reqTime
				+ "]";
	}
}	