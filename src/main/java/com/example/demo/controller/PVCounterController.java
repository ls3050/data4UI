package com.example.demo.controller;



import com.example.demo.mapper.PVCounterMapper;
import com.example.demo.pojo.PVCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PVCounterController {
    @Autowired
    PVCounterMapper pVCounterMapper;

    @RequestMapping("/listPVCounter")
    public List<PVCounter> listPVCounter() throws Exception {
        List<PVCounter> pvs = pVCounterMapper.findAll();
        return pvs;
    }

    @RequestMapping("/onePVCounter")
    public PVCounter onePVCounter(String id) throws Exception {
        PVCounter pv = pVCounterMapper.findById(id);
        return pv;
    }
}
