package com.argo.gateway.task;

import com.argo.gateway.user.domain.repository.IAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;

@Component
public class task {



    @Value("${pathbackup}")
    private String path;

    @Value("${pathmysql}")
    private String mysql;


    @Value("${spring.datasource.username}")
    private String root;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${database}")
    private String database;

    @Autowired
    private IAccess iAccess;

    @Scheduled(cron = "0 0 1 * * *")
    @Transactional(rollbackFor = Exception.class)
    public void limpiarSesiones(){


        try {
            this.iAccess.deleteAllInBatch();
        }catch (Exception ex){
            throw new RuntimeException("Error al borrar las sesiones");
        }


    }

    @Scheduled(cron = "0 0 2 * * *")
    public void backup(){

        try {
            Process p = Runtime
                    .getRuntime()
                    .exec(mysql + " -u" + root + " -p" + password + " " + database);


            Date fecha = new Date();
            String name=fecha.getYear()+""+fecha.getMonth()+""+fecha.getDay()+".sql";

            InputStream is = p.getInputStream();
            FileOutputStream fos = new FileOutputStream(path+name);
            byte[] buffer = new byte[1000];

            int leido = is.read(buffer);
            while (leido > 0) {
                fos.write(buffer, 0, leido);
                leido = is.read(buffer);
            }

            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
