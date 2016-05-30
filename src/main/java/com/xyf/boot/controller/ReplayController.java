package com.xyf.boot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyf.boot.domain.FmtCode;
import com.xyf.boot.domain.base.JsonResult;
import com.xyf.boot.domain.info.FmtDetail;
import com.xyf.boot.service.FmtCodeService;
import com.xyf.boot.util.JsonUtil;

@Controller
@RequestMapping("/replay")
public class ReplayController {

	private static final Logger logger = LoggerFactory
			.getLogger(ReplayController.class);

	@Autowired
	private FmtCodeService fmtCodeService;

	@RequestMapping
	public String replayList() {
		logger.info("进入报文比对查询主页面");
		return "replay/list";
	}

	@RequestMapping("/list.json")
	@ResponseBody
	public JsonResult listJson(FmtCode fmtCode) {
		logger.info("请求参数: " + fmtCode);
		int size = fmtCodeService.selectTotalSize(fmtCode);
		List<FmtCode> fmtCodes = fmtCodeService.selectEverPage(fmtCode);
		return JsonUtil.genJsonResultModel(size, fmtCodes);
	}

	@RequestMapping("/detail/{uuid}")
	public String showDetail(@PathVariable("uuid") String uuid,
			ModelMap modelMap) {
		logger.debug("传入参数: " + uuid);
		FmtCode fmtCode = fmtCodeService.findFmtCode(uuid);
		FmtDetail fmtDetail = new FmtDetail();
		fmtDetail.setUuid(fmtCode.getUuid());
		fmtDetail.setResponseMsg(crtData());
		fmtDetail.setNewResponseMsg(fmtDetail.getResponseMsg());
		fmtDetail.setCompResult(fmtDetail.getResponseMsg());
		modelMap.addAttribute("fmtCode", fmtDetail);
		return "replay/detail";
	}

	private String crtData() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 100; i++) {
			sb.append("<root>abcdefg</root>");
		}
		return sb.toString();
	}

}
