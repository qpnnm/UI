package com.ui.dao;

import java.util.List;
import java.util.Map;

public interface MemberInfoDAO {

	List<Map<String, Object>> selectMemberList(Map<String, Object> mi);

}
