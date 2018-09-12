package com.lizhi.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
//rg.projectlombok 可以使用注解@Data 编译时自动生成get,set方法,构造函数,toString方法
@Data
@Entity
@NamedQuery(name = "Message.countid",query = "select a from Message a where a.id = ?1 ") //一个名称对应一个方法
public class Message implements Serializable {

	private static final long serialVersionUID = 2128346393707857300L;

	@Id
	@GeneratedValue //插入自增
	private Integer id;

	@Column(name = "NICK_NAME")
	private String nickName;

	private String ip;

	@Column(name = "insert_time")
	private Date insertTime;

	
	public Message() {
		super();
	}

	public Message(Integer id, String nickName, String ip, Date insertTime) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.ip = ip;
		this.insertTime = insertTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

}
