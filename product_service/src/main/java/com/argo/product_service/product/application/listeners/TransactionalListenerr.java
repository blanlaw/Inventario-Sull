package com.argo.product_service.product.application.listeners;

import com.argo.product_service.product.application.productService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Date;


@Component
public class TransactionalListenerr {



    @TransactionalEventListener(classes = {productService.ProductServiceEvent.class},phase = TransactionPhase.AFTER_COMMIT)
    public void historiaCreado(productService.ProductServiceEvent product){


        switch (product.getEstado()){

            case "delete":
                System.out.println("borro");


                break;
            case "create":
                System.out.println("creo");
                break;

            case "update":
                System.out.println("actualizo");
                break;



        }
    }

}
