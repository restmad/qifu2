/* 
 * Copyright 2012-2016 bambooCORE, greenstep of copyright Chen Xin Nien
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
 * 
 * -----------------------------------------------------------------------
 * 
 * author: 	Chen Xin Nien
 * contact: chen.xin.nien@gmail.com
 * 
 */
package org.qifu.job;

import org.apache.commons.lang3.StringUtils;
import org.qifu.sys.BackgroundProgramUserUtils;
import org.qifu.util.SimpleUtils;
import org.springframework.scheduling.quartz.QuartzJobBean;

public abstract class BaseJob extends QuartzJobBean {
	
	public String getAccountId() {		
		return StringUtils.defaultString( (String)BackgroundProgramUserUtils.getSubject().getPrincipal() );		
	}	
	
	public String generateOid() {
		return SimpleUtils.getUUIDStr();
	}
	
	public void login() throws Exception {		
		BackgroundProgramUserUtils.login();
	}
	
	public void logout() throws Exception {
		BackgroundProgramUserUtils.logout();
	}
	
}
