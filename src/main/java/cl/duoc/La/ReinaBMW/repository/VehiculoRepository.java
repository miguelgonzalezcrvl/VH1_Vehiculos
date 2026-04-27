package cl.duoc.La.ReinaBMW.repository;

import cl.duoc.La.ReinaBMW.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    // Buscar por marca (BMW, Audi, Mercedes)
    List<Vehiculo> findByMarca(String marca);

    // Buscar por modelo
    List<Vehiculo> findByModelo(String modelo);

    // Buscar vehículos con stock mayor a X
    List<Vehiculo> findByStockGreaterThan(int stock);

    // Buscar por rango de precio
    List<Vehiculo> findByPrecioBetween(double min, double max);

}