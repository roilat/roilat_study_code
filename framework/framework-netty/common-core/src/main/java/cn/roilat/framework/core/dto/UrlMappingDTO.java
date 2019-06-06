package cn.roilat.framework.core.dto;

import java.io.Serializable;

public class UrlMappingDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String urlMapping;

    public String getUrlMapping() {
        return urlMapping;
    }

    public void setUrlMapping(String urlMapping) {
        this.urlMapping = urlMapping;
    }
}
