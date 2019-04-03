package com.example.skypay;

public class Response {
    private String responseTime;
    private String responseCode;
    private String responseDescription;
    private String referenceNo;

    /**
     * @return the responseTime
     */
    public String getResponseTime() {
        return responseTime;
    }

    /**
     * @param responseTime the responseTime to set
     */
    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * @return the responseCode
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * @param responseCode the responseCode to set
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * @return the responseDescription
     */
    public String getResponseDescription() {
        return responseDescription;
    }

    /**
     * @param responseDescription the responseDescription to set
     */
    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    /**
     * @return the referenceNo
     */
    public String getReferenceNo() {
        return referenceNo;
    }

    /**
     * @param referenceNo the referenceNo to set
     */
    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    
}