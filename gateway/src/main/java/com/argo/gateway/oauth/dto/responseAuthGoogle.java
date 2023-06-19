package com.argo.gateway.oauth.dto;

import java.util.Map;

public class responseAuthGoogle {

    public responseAuthGoogle(Map<String, ?> response, boolean validate) {
        this.response = response;
        this.validate = validate;
    }

    private Map<String,?> response;
    private boolean validate;

    public Map<String, ?> getResponse() {
        return response;
    }

    public void setResponse(Map<String, ?> response) {
        this.response = response;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }
}
