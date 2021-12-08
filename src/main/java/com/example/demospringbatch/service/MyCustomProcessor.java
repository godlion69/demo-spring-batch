package com.example.demospringbatch.service;

import com.example.demospringbatch.domain.destination.Manager;
import com.example.demospringbatch.domain.source.Staff;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
public class MyCustomProcessor implements ItemProcessor<Staff, Manager> {

    @Override
    public Manager process(Staff item) throws Exception {
        System.out.println("Batch processor: Processing data: " + item);
        var result = new Manager();
        result.setId(item.getId());
        result.setName(item.getName());
        result.setDepartment(item.getDepartment());
        return result;
    }
}
