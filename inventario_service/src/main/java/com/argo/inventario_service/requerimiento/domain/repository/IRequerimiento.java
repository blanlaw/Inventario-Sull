package com.argo.inventario_service.requerimiento.domain.repository;


import com.argo.inventario_service.dashboard.models.requerimientoModelDashboard;
import com.argo.inventario_service.requerimiento.application.models.RequerimientoQuery;
import com.argo.inventario_service.requerimiento.domain.Requerimiento;
import com.argo.inventario_service.requerimiento.domain.enm.EstadoRequerimiento;
import com.argo.inventario_service.requerimiento.domain.enm.TipoRequerimiento;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Requerimiento.
 */
@Repository
public interface IRequerimiento extends JpaRepository<Requerimiento, String> {


    /**
     * Count by codigo requerimiento starting with long.
     *
     * @param codigo the codigo
     * @return the long
     */
    long countByCodigoRequerimientoStartingWith(String codigo);

    /**
     * Mis requerimientos list.
     *
     * @param almacen the almacen
     * @return the list
     */
    @Query("select req.codigoRequerimiento as codigo,req.requeridoPor.email as empleado,req.fechaEmision as fechaEmision,req.tipoRequerimiento as tipoRequerimiento,req.estadoRequerimiento as estadoRequerimiento from  Requerimiento req where req.almacenPide=?1")
    List<RequerimientoQuery> misRequerimientos(Almacen almacen);


    /**
     * Mis peticiones list.
     *
     * @param almacen           the almacen
     * @param tipoRequerimiento the tipo requerimiento
     * @return the list
     */
    @Query("select req.codigoRequerimiento as codigo,req.almacenPide.almacen as remitente,req.fechaEmision as fechaEmision,req.tipoRequerimiento as tipoRequerimiento,req.estadoRequerimiento as estadoRequerimiento from  Requerimiento req where req.almacenRecibe=?1 and req.tipoRequerimiento=?2")
    List<RequerimientoQuery> misPeticiones(Almacen almacen , TipoRequerimiento tipoRequerimiento);


    /**
     * Find by requerido por list.
     *
     * @param user the user
     * @return the list
     */
    List<Requerimiento> findByRequeridoPor(User user);

    /**
     * Find by requerido por and almacen pide list.
     *
     * @param user    the user
     * @param almacen the almacen
     * @return the list
     */
    List<Requerimiento> findByRequeridoPorAndAlmacenPide(User user,Almacen almacen);

    /**
     * Find by almacen pide list.
     *
     * @param user the user
     * @return the list
     */
    List<Requerimiento> findByAlmacenPide(Almacen user);

    /**
     * Dashboard requerimiento list.
     *
     * @param a                   the a
     * @param estadoRequerimiento the estado requerimiento
     * @param pageable            the pageable
     * @return the list
     */
    @Query("select requerimiento.codigoRequerimiento as codigo,requerimiento.fechaEmision as fechaEmision,requerimiento.almacenPide.almacen as almacenRequiere from detalles_requerimiento  detreq inner join detreq.idRequerimiento requerimiento where requerimiento.almacenPide=?1  and requerimiento.estadoRequerimiento=?2")
    List<requerimientoModelDashboard> dashboardRequerimiento(Almacen a, EstadoRequerimiento estadoRequerimiento, Pageable pageable);

    /**
     * Count by almacen pide and estado requerimiento long.
     *
     * @param a                   the a
     * @param estadoRequerimiento the estado requerimiento
     * @return the long
     */
    long countByAlmacenPideAndEstadoRequerimiento(Almacen a,EstadoRequerimiento estadoRequerimiento);

}
