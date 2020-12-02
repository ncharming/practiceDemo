package org.practice.redis.domain;

/**
 * @Author :nihongyu
 * @Description:
 * @Date:Created in 2020/12/2 0002.
 * @Modified By:
 */
public class ReturnObject {
	private String respCode;
	private String respDesc;
	private String respInfo;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespDesc() {
		return respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

	public String getRespInfo() {
		return respInfo;
	}

	public void setRespInfo(String respInfo) {
		this.respInfo = respInfo;
	}

	@Override
	public String toString() {
		return "ReturnObject{" +
				"respCode='" + respCode + '\'' +
				", respDesc='" + respDesc + '\'' +
				", respInfo='" + respInfo + '\'' +
				'}';
	}
}
