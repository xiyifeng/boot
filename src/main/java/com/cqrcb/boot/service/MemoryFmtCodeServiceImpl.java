/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cqrcb.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.cqrcb.boot.domain.FmtCode;

/**
 * 
 * @author Administrator
 * 
 */
public class MemoryFmtCodeServiceImpl implements FmtCodeService {

	private final ConcurrentMap<String, FmtCode> fmtCodes = new ConcurrentHashMap<String, FmtCode>();

	@Override
	public List<FmtCode> findAll() {
		FmtCode fmtCode = new FmtCode();
//		fmtCode.randomInit();
		fmtCodes.put(fmtCode.getUuid(), fmtCode);
		return new ArrayList<FmtCode>(fmtCodes.values());
	}

	@Override
	public FmtCode save(FmtCode fmtCode) {
		String uuid = fmtCode.getUuid();
		if (fmtCodes.containsKey(uuid)) {
			return fmtCodes.get(uuid);
		}
		fmtCodes.put(uuid, fmtCode);
		return fmtCode;
	}

	@Override
	public FmtCode findFmtCode(String uuid) {
		FmtCode fmtCode = new FmtCode();
//		fmtCode.randomInit();
		return fmtCode;
	}

	@Override
	public void deleteFmtCode(String uuid) {
		fmtCodes.remove(uuid);
	}

	@Override
	public void passFmtCode(String uuid) {
		FmtCode fmtCode = fmtCodes.get(uuid);
//		fmtCode.setDiffCode("1");
	}

	@Override
	public List<FmtCode> selectList(FmtCode fmtCode) {
		return null;
	}

	@Override
	public int selectTotalSize(FmtCode fmtCode) {
		return 0;
	}

	@Override
	public List<FmtCode> selectEverPage(FmtCode fmtCode) {
		return null;
	}

}