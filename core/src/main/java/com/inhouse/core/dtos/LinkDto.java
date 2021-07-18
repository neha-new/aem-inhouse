package com.inhouse.core.dtos;

public class LinkDto {
    private String linkName;
    private String linkURL;
    private String headingText;

    public LinkDto() {
       super();
    }

    public LinkDto(String linkName, String linkURL) {
        this.linkName = linkName;
        this.linkURL = linkURL;
    }

    public LinkDto(String linkName, String linkURL, String headingText) {
        this.linkName = linkName;
        this.linkURL = linkURL;
        this.headingText = headingText;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkURL() {
        return linkURL;
    }

    public void setLinkURL(String linkURL) {
        this.linkURL = linkURL;
    }

    public String getHeadingText() { return headingText; }

    public void setHeadingText(String headingText) { this.headingText = headingText;}



}