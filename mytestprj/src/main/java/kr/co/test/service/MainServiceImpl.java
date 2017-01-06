package kr.co.test.service;

import java.util.List;
import java.util.Map;

import kr.co.test.dao.MainDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mainServiceImpl")
public class MainServiceImpl implements MainService{

	private Logger logger = LoggerFactory.getLogger(MainServiceImpl.class);
	
	@Autowired
	private MainDao mainDao;

	@Override
	public List<Map<String, Object>> getUsers() throws Exception {
		return mainDao.selectList("userList");
	}
	
	
}
