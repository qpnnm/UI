package com.ui.service;

import java.util.List;
import java.util.Map;

public interface MemberInfoService {
	List<Map<String, Object>> selectMemberList(Map<String, Object> mi);
}
