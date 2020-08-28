package com.ui.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ui.dao.MemberInfoDAO;
import com.ui.servlet.MybatisServlet;

public class MemberInfoDAOImpl implements MemberInfoDAO {

	@Override
	public List<Map<String, Object>> selectMemberList(Map<String, Object> mi) {
		try (SqlSession ss = MybatisServlet.getSession()) {
			return ss.selectList("Member.selectMemberList", mi);
		}
	}

	public static void main(String[] args) {
		MemberInfoDAO midao = new MemberInfoDAOImpl();
		Map<String, Object> param = new HashMap<>();
		param.put("startNum", 51);
		param.put("endNum", 60);
		List<Map<String, Object>> sList = midao.selectMemberList(param);
		for (Map<String, Object> s : sList) {
			System.out.println(s);

		}

	}
}
