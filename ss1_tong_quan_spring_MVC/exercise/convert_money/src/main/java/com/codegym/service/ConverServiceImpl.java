package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class ConverServiceImpl implements IConvertService{
    @Override
    public double convert(double rate, double usd) {
        double vnd;
        vnd = rate * usd;
        return vnd;
    }
}
