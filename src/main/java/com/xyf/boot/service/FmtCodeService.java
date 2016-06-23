/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.xyf.boot.service;

import java.util.List;

import com.xyf.boot.domain.FmtCode;
import com.xyf.boot.domain.info.FmtDetail;

/**
 * @author Rob Winch
 */
public interface FmtCodeService {

	FmtCode save(FmtCode message);

	FmtCode findFmtCode(String uuid);

	void deleteFmtCode(String uuid);

	void passFmtCode(String uuid);

	List<FmtCode> selectEverPage(FmtCode fmtCode);
	
	int selectTotalSize(FmtCode fmtCode);

	FmtDetail findFmtMessageByUuid(String uuid);

}