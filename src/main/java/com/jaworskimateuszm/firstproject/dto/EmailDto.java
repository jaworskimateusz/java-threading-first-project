package com.jaworskimateuszm.firstproject.dto;

public class EmailDto {

    private String recipient;
    private String content;
    private String signature;
    private Boolean status;

    public EmailDto(String recipient, String content, String signature, Boolean status) {
        this.recipient = recipient;
        this.content = content;
        this.signature = signature;
        this.status = status;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmailDto{" +
                "recipient='" + recipient + '\'' +
                ", content='" + content + '\'' +
                ", signature='" + signature + '\'' +
                ", status=" + status +
                '}';
    }
}
