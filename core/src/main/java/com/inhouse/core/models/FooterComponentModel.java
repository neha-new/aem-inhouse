package com.inhouse.core.models;

import com.inhouse.core.dtos.LinkDto;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FooterComponentModel {

    private static final Logger logger = LoggerFactory.getLogger(FooterComponentModel.class);
    @SlingObject
    private Resource currentResource;

    @ValueMapValue
    private String copyRightDetails;

    private List<LinkDto> linkDtos;

    @PostConstruct
    protected void init() {
        logger.info("Under Init ");
        linkDtos = new ArrayList<>();
        Resource childResource = currentResource.getChild("socialShareItems");
        if (childResource != null) {
            childResource.getChildren().forEach(tmpResource -> {
                        logger.info("path of tmpResource is {}", tmpResource.getPath());
                        LinkDto linkDto = new LinkDto();
                        linkDto.setLinkName((String) tmpResource.getValueMap().getOrDefault("LinkName", ""));
                        linkDto.setLinkURL((String) tmpResource.getValueMap().getOrDefault("LinkURL", ""));
                        linkDtos.add(linkDto);
                    }
            );
        }
        logger.info("List Size is {}", linkDtos.size());
    }

    public List<LinkDto> getLinkDtos() {
        return linkDtos;
    }

    public String getCopyRightDetails() {
        return copyRightDetails;
    }

}

