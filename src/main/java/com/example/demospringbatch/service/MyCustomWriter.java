package com.example.demospringbatch.service;

import com.example.demospringbatch.domain.destination.Manager;
import com.example.demospringbatch.repository.destination.ManagerRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyCustomWriter implements ItemWriter<Manager> {

    @Autowired
    private ManagerRepository managerRepository;


    @Override
    public void write(List<? extends Manager> items) throws Exception {
        for (Manager data : items) {
            System.out.println("MyCustomWriter    : Writing data    : " + data.getId() + " : " + data.getName() + " : " + data.getDepartment());
            managerRepository.save(data);
        }
    }
}
