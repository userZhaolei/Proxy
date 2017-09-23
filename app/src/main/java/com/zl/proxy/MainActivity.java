package com.zl.proxy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {

    private PersonDao p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PersonDao personDao = new PersonImp();
        PersonHanlder handler = new PersonHanlder(personDao);
        p = (PersonDao) Proxy.newProxyInstance(personDao.getClass().getClassLoader(), personDao.getClass().getInterfaces(), handler);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.pay();
            }
        });
    }
}
