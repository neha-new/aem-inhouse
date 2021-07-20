package com.inhouse.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TextAndImageComponentModel {
    @SlingObject
    private Resource currentResource;

    @ValueMapValue
    private String headingText;

    @ValueMapValue
    private String subHeadingLink;

    @ValueMapValue
    private String subHeadingText;

    @ValueMapValue
    private String longDescriptionText;

    @ValueMapValue
    private String imageLink;

    @ValueMapValue
    private String selectVariation;

    public String getHeadingText() { return headingText; }

    public String getSubHeadingLink() { return subHeadingLink; }

    public String getSubHeadingText() { return subHeadingText; }

    public String getLongDescriptionText() { return longDescriptionText; }

    public String getImageLink() { return imageLink; }

    public String getSelectVariation() { return selectVariation; }
}
