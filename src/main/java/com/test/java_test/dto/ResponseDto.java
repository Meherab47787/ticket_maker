package com.test.java_test.dto;

public class ResponseDto {
    private String statusCode;
    private String StatusMsg;

    public ResponseDto(String statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.StatusMsg = statusMsg;
    }

    //Getter
    public String getStatusCode() {
        return statusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }
    ///GETTER END

    //SETTER

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusMsg(String statusMsg) {
        StatusMsg = statusMsg;
    }

    //SETTER END
}

