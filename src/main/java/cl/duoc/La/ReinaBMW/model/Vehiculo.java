package cl.duoc.La.ReinaBMW.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {

    @NotBlank(message = "La marca es obligatoria")
    private String marca;
    @NotBlank(message = "El modelo es obligatorio")
    private String modelo;
    @NotNull(message = "El año es obligatorio")
    private int año;
    @NotNull(message = "El precio es obligatorio")
    private double precio;

   
}
