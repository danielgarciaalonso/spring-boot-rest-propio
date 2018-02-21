package cmc.formacion.springbootrest.exception;

public class ErrorResponse {
	
	private Integer httpCore;
	
	private String httpMessage;
	
	private String moreInformation;

	public ErrorResponse(Integer httpCore, String httpMessage, String moreInformation) {
		super();
		this.httpCore = httpCore;
		this.httpMessage = httpMessage;
		this.moreInformation = moreInformation;
	}

	public Integer getHttpCore() {
		return httpCore;
	}

	public void setHttpCore(Integer httpCore) {
		this.httpCore = httpCore;
	}

	public String getHttpMessage() {
		return httpMessage;
	}

	public void setHttpMessage(String httpMessage) {
		this.httpMessage = httpMessage;
	}

	public String getMoreInformation() {
		return moreInformation;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}
	
	

}
