package com.consultoriodonto.consultoriodonto;

import jakarta.persistence.*; //Banco de dados @Entity, @Id
import jakarta.validation.*; //@Future, @NotBlanck
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*; //Reduz o código com os @Getter e @Setter
import java.time.LocalDateTime; //Para Datas e horas, LocalDateTime

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "agendamentos")

public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    //Garante datas futuras
    @Future(message = "A data da consulta deve ser futura")
    private LocalDateTime dataHora;

    //Relacionamento Paciente x Dentista, muitos agendamentos para 1 paciente/dentista
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false) //Nomeia a coluna de chave estrangeira do banco
    private Paciente paciente;

    @NotBlank(message = "status é obrigatório")
    @Pattern(regexp = "AGENDADO | CONCLUÍDO | CANCELADO",
            message = "Status deve ser AGENDADO, CONCLUIDO ou CANCELADO")
    private String status;

    @Size(max = 200, message = "Observação muito longa")
    private String observacao;

}
