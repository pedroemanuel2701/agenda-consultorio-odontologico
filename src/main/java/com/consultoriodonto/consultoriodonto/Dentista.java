package com.consultoriodonto.consultoriodonto;

import jakarta.persistence.*; //JPA: Entity, Id, Talbe, etc
import jakarta.validation.constraints.*; //Validações: NotBlanck, Size, etc
import lombok.*;

@Getter
@Setter
@AllArgsConstructor //construtor vazio (Exigido pela JPA/Hibernate)
@NoArgsConstructor //Contrutor com todos os campos (útil para testes)
@ToString //Gera um metodo toString() para loggin/depuração
@Entity
@Table(name = "dentista")

public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Cria uma ID pro dentista
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 a 100 caracteres")
    private String nome;

    @NotBlank(message = "A especialidade é obrigatória")
    private String especialidade;

    @Column(unique = true)
    @Pattern(regexp = "\\d{4}-[A-Z]{2}", message = "CRO deve seguir o padrão 1234-SP")
    private String cro; //Registro profissional, CRO
}
