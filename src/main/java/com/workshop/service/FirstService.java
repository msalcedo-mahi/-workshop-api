package com.workshop.service;

import com.workshop.rest.dto.FirstDTO;
import org.springframework.stereotype.Service;


@Service
public class FirstService {

    public void getLastUpdatesInfo(FirstDTO firstDTO)  {
        System.out.println(firstDTO.getFirstAtt());
        System.out.println(firstDTO.getSecondAtt());
    }
}
