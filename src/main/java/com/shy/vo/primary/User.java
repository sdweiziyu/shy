package com.shy.vo.primary;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**  
 * 类说明   
 *  
 * @author weizy  
 * @version v1.0
 * @date 2017年2月24日 上午10:41:27
 */
@Entity
@Table(name = "tbl_sys_user")
public class User implements Serializable{
	private static final long serialVersionUID = -922747706994142627L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid",strategy = "uuid")
	@Column(name = "ID")
	private String userId;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "LOGIN_ID")
	private String loginId;
	@Column(name = "LOGIN_PASSWORD")
	private String loginPassword;
	@Column(name = "CREATED_DATE")
	private Date createDate;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
