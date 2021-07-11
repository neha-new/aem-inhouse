package com.inhouse.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BannerComponentModel {
    @ValueMapValue
    private String headingText;

    @ValueMapValue
    private String descriptionText;

    @ValueMapValue
    private String imageUpload;

    @ValueMapValue
    private String buttonText;

    public String getHeadingText() {
        return headingText;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public String getImageUpload() {
        return imageUpload;
    }

    public String getButtonText() {
        return buttonText;
    }
}
