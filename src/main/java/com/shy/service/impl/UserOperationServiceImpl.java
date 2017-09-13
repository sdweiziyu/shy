package com.shy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shy.dao.primary.UserOperationDao;
import com.shy.service.UserOperationService;
import com.shy.vo.primary.User;

/**  
 * 类说明   
 *  
 * @author weizy  
 * @version v1.0
 * @date 2017年2月24日 上午11:00:18
 */
@Service
public class UserOperationServiceImpl implements UserOperationService{

	@Autowired
	private UserOperationDao userOperationDao;
	
	@Override
	public User getUser(String loginId) {
		
		return userOperationDao.getUser(loginId);
	}

	
}
