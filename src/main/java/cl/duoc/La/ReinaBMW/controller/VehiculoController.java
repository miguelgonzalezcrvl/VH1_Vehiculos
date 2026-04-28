package cl.duoc.La.ReinaBMW.controller;

import cl.duoc.La.ReinaBMW.dto.ApiResponse;
import cl.duoc.La.ReinaBMW.model.Vehiculo;
import cl.duoc.La.ReinaBMW.service.VehiculoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
a

@RestController
@RequestMapping("/api/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService service;

    @PostMapping
    public ResponseEntity<ApiResponse<Vehiculo>> crear(
            @Valid @RequestBody Vehiculo vehiculo) {

        Vehiculo v = service.save(vehiculo);

        return ResponseEntity.ok(
                new ApiResponse<>(200, "Vehículo creado", v)
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Vehiculo>>> listar() {

        List<Vehiculo> lista = service.findAll();

        return ResponseEntity.ok(
                new ApiResponse<>(200, "Listado de vehículos", lista)
        );
    }

    @PutMapping("/vender/{id}")
    public ResponseEntity<ApiResponse<Vehiculo>> vender(@PathVariable Long id) {

        Vehiculo v = service.vender(id);

        return ResponseEntity.ok(
                new ApiResponse<>(200, "Vehículo vendido", v)
        );
    }

    @PutMapping("/stock/{id}")
    public ResponseEntity<ApiResponse<Vehiculo>> agregarStock(
            @PathVariable Long id,
            @RequestParam int cantidad) {

        Vehiculo v = service.agregarStock(id, cantidad);

        return ResponseEntity.ok(
                new ApiResponse<>(200, "Stock actualizado", v)
        );
    }
}