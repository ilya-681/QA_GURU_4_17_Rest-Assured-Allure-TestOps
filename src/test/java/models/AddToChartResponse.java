package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)


public class AddToChartResponse {

    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("message")
    private String message;
    @JsonProperty("updatetopcartsectionhtml")
    private String updatetopcartsectionhtml;
    @JsonProperty("updateflyoutcartsectionhtml")
    private String updateflyoutcartsectionhtml;

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("updatetopcartsectionhtml")
    public String getUpdatetopcartsectionhtml() {
        return updatetopcartsectionhtml;
    }

    @JsonProperty("updatetopcartsectionhtml")
    public void setUpdatetopcartsectionhtml(String updatetopcartsectionhtml) {
        this.updatetopcartsectionhtml = updatetopcartsectionhtml;
    }

    @JsonProperty("updateflyoutcartsectionhtml")
    public String getUpdateflyoutcartsectionhtml() {
        return updateflyoutcartsectionhtml;
    }

    @JsonProperty("updateflyoutcartsectionhtml")
    public void setUpdateflyoutcartsectionhtml(String updateflyoutcartsectionhtml) {
        this.updateflyoutcartsectionhtml = updateflyoutcartsectionhtml;
    }

}