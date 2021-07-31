package com.inhouse.core.models;

import com.inhouse.core.dtos.LinkDto;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OurServicesComponentModel {
    @SlingObject
    private Resource currentResource;

    @ValueMapValue
    private String headingText;

    @ValueMapValue
    private String subHeadingText;

    @ValueMapValue
    private String longDescriptionText;

    private List<LinkDto> linkDtoList;

    @PostConstruct
    protected void init(){
        linkDtoList = new ArrayList<>();
        Resource childResource = currentResource.getChild("servicesLink");
            if(childResource!=null){
                childResource.getChildren().forEach(linkResource -> {
                    String buttonName2 = (String) linkResource.getValueMap().getOrDefault("buttonName2", "");
                    String buttonLinkUrl2 =(String) linkResource.getValueMap().getOrDefault("buttonLinkUrl2","");
                    LinkDto linkDto = new LinkDto(buttonName2,buttonLinkUrl2);
                    linkDtoList.add(linkDto);
                });
            }
    }
    public List<LinkDto> getLinkDtoList() { return linkDtoList; }

    public String getHeadingText() { return headingText; }

    public String getSubHeadingText() { return subHeadingText; }

    public String getLongDescriptionText() { return longDescriptionText; }
}
