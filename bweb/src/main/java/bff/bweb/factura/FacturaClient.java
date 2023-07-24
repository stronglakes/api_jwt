package bff.bweb.factura;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.factura", url = "http://localhost:8083/api/factura")
public interface FacturaClient {

    @GetMapping("/{id}/")
    FacturaDTO findFacturaById(@PathVariable("id") Long id);

    @GetMapping("/pdf/{id}/")
    ResponseEntity<byte[]> pdfById( @PathVariable("id") Long id);

    @GetMapping("/")
    List<FacturaDTO> findAll();

    @PostMapping("/") 
    FacturaDTO save(FacturaDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id")  Long id);

    @PutMapping("/{id}/")
    FacturaDTO update(@PathVariable("id")  Long id, FacturaDTO entity);

}