package com.springcloud.userservice.repository;

import com.springcloud.userservice.model.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/*
    * al colocar el nombre del proyecto con el que aparece en eureka (hostname) del
    * recurso a consumir nos ahorramos el tener que colocar la url
 */

/*
* Cuando se use balanceador de carga con varias instancias en varias puertos:
*   1. El obligatorio usar solo el name -> hostname del servicio a consumir.
*   2. No se debe definir url puesto que esta contiene puerto y enviaría las solicitudes
*       a una sola instancia
* */
@FeignClient (name = "posts-service")
public interface IPostApiClient {

    @GetMapping("/posts/find-by-user/{user_id}")
    List<PostDTO> findPostsByUser(
            @PathVariable("user_id") Long user_id);

}
