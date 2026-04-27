package cl.duoc.La.ReinaBMW.service;

import cl.duoc.La.ReinaBMW.model.Vehiculo;
import cl.duoc.La.ReinaBMW.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoService {

    private final VehiculoRepository repository;

    // Crear vehículo
    public Vehiculo save(Vehiculo vehiculo) {

        if (!List.of("BMW", "Audi", "Mercedes").contains(vehiculo.getMarca())) {
            throw new RuntimeException("Marca no permitida");
        }

        return repository.save(vehiculo);
    }

    // Listar todos
    public List<Vehiculo> findAll() {
        return repository.findAll();
    }

    // Vender vehículo
    public Vehiculo vender(Long id) {
        Vehiculo v = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));

        if (v.getStock() == null || v.getStock() <= 0) {
            throw new RuntimeException("Sin stock");
        }

        v.setStock(v.getStock() - 1);
        return repository.save(v);
    }

    // Agregar stock
    public Vehiculo agregarStock(Long id, int cantidad) {

        if (cantidad <= 0) {
            throw new RuntimeException("La cantidad debe ser mayor a 0");
        }

        Vehiculo v = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));

        v.setStock(v.getStock() + cantidad);
        return repository.save(v);
    }
}