package com.feedo.application;

import com.feedo.presenter_web.ViewController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {
        ViewController.class
})
public class ApplicationConfiguration {


}
