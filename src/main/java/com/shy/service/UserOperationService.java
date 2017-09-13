package com.shy.service;

import com.shy.vo.primary.User;

/**  
 *  
 * @author weizy  
 * @version v1.0
 * @date 2017年2月24日 上午10:41:04
 */
public interface UserOperationService {

	User getUser(String loginId);
	
}
