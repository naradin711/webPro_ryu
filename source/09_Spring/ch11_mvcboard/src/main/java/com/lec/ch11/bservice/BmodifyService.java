package com.lec.ch11.bservice;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;
import com.lec.ch11.dto.BoardDto;

public class BmodifyService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		BoardDto bDto =(BoardDto)map.get("bDto");
		bDto.setBip(request.getRemoteAddr()); 
		BoardDao boardDao = BoardDao.getInstance();
		// boardDao.modify(bDto);
		model.addAttribute("modifyResult", boardDao.modify(bDto));

	}

}
