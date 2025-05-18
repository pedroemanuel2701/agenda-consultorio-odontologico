package com.consultoriodonto.consultoriodonto;

import jakarta.persistence.*; //Mapear como entidade no banco de dados
import jakarta.validation.constraints.*; //Para validações
import lombok.*; //Para gerar getters, setters etc.

import java.time.LocalDate;

//Lombok:
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "pacientes")

public class Paciente {

    @Id //Indica que o campo é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-incremento no banco
    private Long id;

    @NotBlank(message = "O nome é obrigatório") //Valida que não pode ser vazio/nulo
    private String nome;

    @Pattern(regexp = "^\\d{10,11}$", message = "Telefone inválido") //Valida formato de 10 ou 11 dígitos
    private String telefone;

    @Column(unique = true) //Garante que o CPF seja único no banco
    private String cpf;

    @Past(message = "A dara de nascimento deve ser no passado") //valida data passada
    private LocalDate dataNascimento;
}
