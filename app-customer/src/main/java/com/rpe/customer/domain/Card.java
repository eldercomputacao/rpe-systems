package com.rpe.customer.domain;

import java.io.Serializable;

public class Card implements Serializable {
    private Long customerId;
    private Long productId;
    private String number;
    private String password;
    private String personalizedName;
    private String status;
    private String createdAt;
    private String updatedAt;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonalizedName() {
        return personalizedName;
    }

    public void setPersonalizedName(String personalizedName) {
        this.personalizedName = personalizedName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Card{");
        sb.append("customerId=").append(customerId);
        sb.append(", productId=").append(productId);
        sb.append(", number='").append(number).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", personalizedName='").append(personalizedName).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", createdAt='").append(createdAt).append('\'');
        sb.append(", updatedAt='").append(updatedAt).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
