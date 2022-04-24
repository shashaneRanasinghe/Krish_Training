package com.example.MicroservicersCloudConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController {

    @Autowired
    ProfileConfiguration profileConfiguration;

    @RequestMapping("/profile")
    public ProfileConfiguration getProfileConfiguration(){
        return profileConfiguration;
    }


}
