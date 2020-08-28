package com.ui.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ui.dao.MemberInfoDAO;
import com.ui.dao.impl.MemberInfoDAOImpl;
import com.ui.service.MemberInfoService;

public class MemberInfoServiceImpl implements MemberInfoService {
	private MemberInfoDAO midao = new MemberInfoDAOImpl();

	@Override
	public List<Map<String, Object>> selectMemberList(Map<String, Object> mi) {
		int page = Integer.parseInt(mi.get("page").toString());
		int pageSize = Integer.parseInt(mi.get("pageSize").toString());
		int startNum = (page - 1) * pageSize + 1;
		int endNum = (startNum - 1) + pageSize;
		mi.put("startNum", startNum);
		mi.put("endNum", endNum);
		return midao.selectMemberList(mi);
	}

	public static void main(String[] args) {
		MemberInfoService mis = new MemberInfoServiceImpl();
		Map<String, Object> param = new HashMap<>();
		param.put("page", 3);
		param.put("pageSize", 10);
		List<Map<String, Object>> sList = mis.selectMemberList(param);
		for (Map<String, Object> s : sList) {
			System.out.println(s);
		}
	}
}
