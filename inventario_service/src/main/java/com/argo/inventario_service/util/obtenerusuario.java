package com.argo.inventario_service.util;


import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.ws.rs.HeaderParam;
import java.util.List;


/**
 * The interface Obtenerusuario.
 */
@FeignClient("gateway-service")
public interface obtenerusuario {

    /**
     * Gets user.
     *
     * @param authtoken the authtoken
     * @return the user
     */
    @GetMapping("/user")
    User getUser(@RequestHeader("Authorization") String authtoken);

    /**
     * Gets jefe.
     *
     * @param idAlmacen the id almacen
     * @param authtoken the authtoken
     * @return the jefe
     */
    @GetMapping("/user/jefe/{id}")
    User getJefe(@PathVariable("id") int idAlmacen, @RequestHeader("Authorization") String authtoken);

    /**
     * Gets empleado.
     *
     * @param idEmpleado the id empleado
     * @param authtoken  the authtoken
     * @return the empleado
     */
    @GetMapping("/user/empleado/{id}")
    User getEmpleado(@PathVariable("id") String idEmpleado, @RequestHeader("Authorization") String authtoken);

    /**
     * Lista empleados list.
     *
     * @param token the token
     * @return the list
     */
    @GetMapping("/user/empleado")
    List listaEmpleados(@RequestHeader("Authorization") String token);

}
