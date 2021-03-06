package com.inhouse.core.models;

import com.inhouse.core.dtos.LinkDto;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeaderComponentModel {

    @SlingObject
    private Resource currentResource;

    @SlingObject
    private ResourceResolver resourceResolver;

    @ValueMapValue
    private String logoImagePath;

    @ValueMapValue
    private String urlImagePath;

    private List<LinkDto> linkDtos;

    @PostConstruct
    protected void init(){
        linkDtos = new ArrayList<>();
        Resource childResource = currentResource.getChild("pagesLink");//resource and current resource is header component//.
         if(childResource!=null){
             childResource.getChildren().forEach(linkResource -> {
                 LinkDto linkDto = new LinkDto();
                 linkDto.setLinkName((String) linkResource.getValueMap().getOrDefault("PageName",""));
                 linkDto.setLinkURL((String) linkResource.getValueMap().getOrDefault("PageLinkURL",""));
                 linkDtos.add(linkDto);
                }
             );
         }
    }
    public List<LinkDto> getLinkDtos() {
        return linkDtos;
    }
    public String getLogoImagePath() {
        return logoImagePath;
    }
    public String getUrlImagePath() { return urlImagePath; }
}
