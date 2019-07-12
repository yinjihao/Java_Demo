package com.example.demo.i;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class contrll {

    @Autowired
    @Qualifier(value = "saleClueJdbcTemplate")
    private JdbcTemplate mSale;

    @RequestMapping(path = "/get")
    public String get() {
        mSale.execute("sql");
        return "赵汉是狗";
    }
}


