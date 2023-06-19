package com.argo.product_service.product.application;

import com.argo.product_service.product.domain.repository.IType;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class typeService {



    private final IType iType;

    @Autowired
    public typeService(IType iType) {
        this.iType = iType;
    }




}
