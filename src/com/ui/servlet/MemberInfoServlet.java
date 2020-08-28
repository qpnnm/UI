package com.ui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ui.service.MemberInfoService;
import com.ui.service.impl.MemberInfoServiceImpl;

@WebServlet("/ajax/member")
public class MemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberInfoService mis = new MemberInfoServiceImpl();
	private Gson g = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("page", request.getParameter("page"));
		param.put("pageSize", request.getParameter("pageSize"));
		List<Map<String, Object>> pList = mis.selectMemberList(param);
		PrintWriter pw = response.getWriter();
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("list", pList);
		rMap.put("totalCnt", 9999);
		pw.println(g.toJson(rMap));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
