package com.example.demo.i;

import io.reactivex.Observable;
import jdk.nashorn.internal.codegen.CompilerConstants;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@RestController
public class contrll {

    @Autowired
    @Qualifier(value = "saleClueJdbcTemplate")
    private JdbcTemplate mSale;

    @RequestMapping(path = "/get")
    public String get() {
        return getData();
    }


    private String getData() {
        FutureTask<String> task = new FutureTask<String>(() -> call());
        try {
            return task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "1";
    }

    private String call() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "d";
    }


}


