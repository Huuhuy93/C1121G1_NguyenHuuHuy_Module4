//package com.codegym.formatter;
//
//import com.codegym.model.Province;
//import com.codegym.service.province.IProvinceService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.text.ParseException;
//import java.util.Formattable;
//import java.util.Formatter;
//import java.util.Locale;
//import java.util.Optional;
//
//public class ProvinceFormatter implements Formattable<Province> {
//    private IProvinceService provinceService;
//
//    @Autowired
//    public ProvinceFormatter(IProvinceService provinceService) {
//        this.provinceService = provinceService;
//    }
//
//    @Override
//    public Province parse(String text, Locale locale) throws ParseException {
//        Optional<Province> provinceOptional = provinceService.findById(Long.parseLong(text));
//        return provinceOptional.orElse(null);
//    }
//
//    @Override
//    public String print(Province object, Locale locale) {
//        return "[" + object.getId() + ", " +object.getName() + "]";
//    }
//}
