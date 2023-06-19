package com.argo.inventario_service.area.infrastructure;

import com.argo.inventario_service.area.domain.repository.IAccess;
import com.argo.inventario_service.area.domain.repository.IAlmacen;
import com.argo.inventario_service.area.domain.repository.IArea;
import com.argo.inventario_service.util.obtenerusuario;
import com.commons.user.models.entity.accessUser.domain.Access;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.rol.domain.Rol;
import com.commons.user.models.entity.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * The type Almacen controller.
 */
@RestController
public class almacenController {

    @Autowired
    private IAlmacen iAlmacen;
    @Autowired
    private IArea iArea;


    @Autowired
    private IAccess iAccess;


    @Autowired
    private obtenerusuario obtenerusuario;


    /**
     * Lista almacen list.
     *
     * @param token the token
     * @return the list
     */
    @RequestMapping("/almacen")
    public List listaAlmacen(@RequestHeader("Authorization") String token) {

        User user = this.obtenerusuario.getUser(token);
        Almacen idAlmacen = user.getIdAlmacen();

        int almacen = idAlmacen.getIdAlmacen();

        return this.iAlmacen.findByIdAlmacenIsNot(almacen);


    }

    /**
     * Lista area list.
     *
     * @param request the request
     * @param token   the token
     * @return the list
     */
    @RequestMapping("/area")
    public List listaArea(HttpServletRequest request,@RequestHeader("Authorization") String token) {



        return iArea.findAll();

    }

    /**
     * Test token response entity.
     *
     * @param token  the token
     * @param token2 the token 2
     * @return the response entity
     */
    @GetMapping("/test")
    public ResponseEntity<?> testToken(@RequestHeader("Token") String token, @RequestHeader("Authorization") String token2) {


        Access access = this.iAccess.findByToken(token2.split(" ")[1]).orElseThrow(RuntimeException::new);

        access.setSessionId(token);


        this.iAccess.save(access);

        Map<String, Object> mapa = new HashMap<>();
        User user = this.obtenerusuario.getUser(token2);
        Rol idRol = user.getIdRol();
        Almacen idAlmacen = user.getIdAlmacen();

        Map<String, Object> mapaalmacenes = new HashMap<>();
        mapaalmacenes.put("almacen", idAlmacen.getAlmacen());
        mapaalmacenes.put("almacenId", idAlmacen.getIdAlmacen());
        List<Map<String, Object>> lista = new ArrayList<>();
        lista.add(mapaalmacenes);
        Map<String, Object> mapaalmacenes2 = new HashMap<>();
        mapaalmacenes2.put("almacen", idAlmacen.getAlmacen() + "dasda");
        mapaalmacenes2.put("almacenId", idAlmacen.getIdAlmacen() + 1);
        lista.add(mapaalmacenes2);

        mapa.put("almacenes", lista);

        mapa.put("rol", idRol.getRol().toString());
        return new ResponseEntity<>(mapa, HttpStatus.OK);

    }
}
