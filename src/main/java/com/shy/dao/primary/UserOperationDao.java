package com.shy.dao.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shy.vo.primary.User;

/**  
 * 类说明   
 *  
 * @author weizy  
 * @version v1.0
 * @date 2017年2月24日 上午11:00:29
 */
public interface UserOperationDao extends JpaRepository<User,String>{

	@Query("select u from User u where u.loginId = ?1")
	User getUser(String loginId);
}
