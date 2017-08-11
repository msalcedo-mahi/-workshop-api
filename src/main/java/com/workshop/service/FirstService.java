package com.workshop.service;

import com.workshop.rest.dto.FirstDTO;
import org.springframework.stereotype.Service;


@Service
public class FirstService {

    public FirstDTO getLastUpdatesInfo()  {
        FirstDTO firstDTO = FirstDTO.builder().
                firstAtt("First Att").
                secondAtt("Second Att").
                build();
        System.out.println(firstDTO.getFirstAtt());
        System.out.println(firstDTO.getSecondAtt());
        return firstDTO;
    }
}
