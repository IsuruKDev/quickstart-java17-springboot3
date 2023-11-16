package com.isuruk.dev.app.beans.impl;

import com.isuruk.dev.app.beans.BlueInk;
import com.isuruk.dev.app.beans.ColorPrinter;
import com.isuruk.dev.app.beans.GreenInk;
import com.isuruk.dev.app.beans.RedInk;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ColorPrinterImpl implements ColorPrinter {

    @Autowired
    private BlueInk blueInk;

    @Autowired
    private RedInk redInk;
    @Autowired
    private GreenInk greenInk;

    @Override
    public void print() {

        log.info("Printing started :: {}{}{}",blueInk.draw(),redInk.draw(),greenInk.draw());
    }
}
