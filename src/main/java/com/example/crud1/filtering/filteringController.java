package com.example.crud1.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class filteringController {

    @GetMapping("/filter")
    public MappingJacksonValue listSomeBean(){
        SomeBean some =  new SomeBean("value1","value2","value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filter1","filter3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("bean_filter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(some);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/filter-list")
    public MappingJacksonValue listSomeBeanfilter(){
        List <SomeBean> some =  Arrays.asList(
            new SomeBean("value1","value2","value3"),
            new SomeBean("value1","value2","value3"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filter3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("bean_filter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(some);
        mapping.setFilters(filters);
        return mapping;
    }
}
