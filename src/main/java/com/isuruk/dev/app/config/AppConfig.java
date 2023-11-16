package com.isuruk.dev.app.config;

import com.isuruk.dev.app.beans.BlueInk;
import com.isuruk.dev.app.beans.ColorPrinter;
import com.isuruk.dev.app.beans.GreenInk;
import com.isuruk.dev.app.beans.RedInk;
import com.isuruk.dev.app.beans.impl.BlueInkImpl;
import com.isuruk.dev.app.beans.impl.ColorPrinterImpl;
import com.isuruk.dev.app.beans.impl.GreenInkImpl;
import com.isuruk.dev.app.beans.impl.RedInkImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BlueInk createBlueInk(){
        return new BlueInkImpl();
    }

    @Bean
    public RedInk createRedInk(){
        return new RedInkImpl();
    }

    @Bean
    public GreenInk createGreenInk(){
        return new GreenInkImpl();
    }

    @Bean
    public ColorPrinter createColorPrinter(){
        return new ColorPrinterImpl();
    }
}
