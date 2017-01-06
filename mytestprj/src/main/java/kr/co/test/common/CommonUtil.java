package kr.co.test.common;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public class CommonUtil {
	
	private Logger logger = LoggerFactory.getLogger(CommonUtil.class);
	
	/**
	 * map List의 key를 소문자로 변경한다.
	 * @param paramList
	 * @return
	 * @throws Exception
	 */
	public static List<Map<String, Object>> renameKey(List<Map<String, Object>> paramList)throws Exception{
		List<Map<String, Object>> returnList = null;
		if(!ObjectUtils.isEmpty(paramList)){
			returnList = new ArrayList<Map<String,Object>>();
			for(Map<String, Object> map : paramList){
				returnList.add(renameKey(map));
			}
		}
		return returnList;
	}
	
	public static Map<String, Object> renameKey(Map<String, Object> paramMap) throws Exception{
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Set<String> set = paramMap.keySet();
		Object[] arrKey = set.toArray();
		int keyCnt = arrKey.length;
		
		for(int i=0; i < keyCnt; i++){
			String reNameStr = arrKey[i].toString().toLowerCase();
			returnMap.put(reNameStr, paramMap.get((String) arrKey[i]));
		}
		return returnMap;
	}

}
