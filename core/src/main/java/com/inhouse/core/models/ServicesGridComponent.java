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
public class ServicesGridComponent {
    @ValueMapValue
    private String headingText;

    @ValueMapValue
    private String buttonText;

    @ValueMapValue
    private String buttonLink;

    @SlingObject
    private Resource currentResource;

    private List<LinkDto> linkDtoList;

    @PostConstruct
    protected void init(){
        linkDtoList = new ArrayList<>();
        Resource childResource = currentResource.getChild("servicesLink");//resource and current resource is header component//.
        if(childResource!=null){
            childResource.getChildren().forEach(linkResource -> {
                    String headingText1 = (String) linkResource.getValueMap().getOrDefault("headingText","");
                    String buttonName1 = (String) linkResource.getValueMap().getOrDefault("buttonName","");
                    String buttonUrl1 = (String) linkResource.getValueMap().getOrDefault("buttonLinkUrl","");
                    LinkDto linkDto = new LinkDto(buttonName1,buttonUrl1,headingText1);
                    linkDtoList.add(linkDto);
                 }
            );
        }
    }

    public String getHeadingText() { return headingText; }

    public String getButtonText() { return buttonText; }

    public String getButtonLink() { return buttonLink; }

    public List<LinkDto> getLinkDtoList() { return linkDtoList; }
}
