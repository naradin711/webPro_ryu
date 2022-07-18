package com.lec.ch11.bservice;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;

public class BcontentService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); // model을 map
		int bid = (Integer)map.get("bid");
		BoardDao boardDao = BoardDao.getInstance();
		model.addAttribute("bDto", boardDao.contentView(bid));

	}

}
