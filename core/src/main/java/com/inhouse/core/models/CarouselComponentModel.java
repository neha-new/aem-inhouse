package com.inhouse.core.models;

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
public class CarouselComponentModel {
    @SlingObject
    private Resource currentResource;

    @ValueMapValue
    private String numberOfSlides;

    private List<Integer> slides;

    @PostConstruct
    protected void init() {
         slides = new ArrayList<>();
         if(numberOfSlides != null) {
             Integer numOfSlides = Integer.parseInt(numberOfSlides);
             while (numOfSlides >= 1) {
                 slides.add(numOfSlides);
                 numOfSlides--;
             }
         }
    }
    public String getNumberOfSlides() {
        return numberOfSlides;
    }
    public List<Integer> getSlides() {
        return slides;
    }
    }


