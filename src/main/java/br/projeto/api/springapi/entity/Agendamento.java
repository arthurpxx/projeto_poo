package br.projeto.api.springapi.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agendamento_id", nullable = false)
    private Long id;
    
    
    @Column(name = "horario", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date horario;

    // public Users(Long id, String nome, String data_nascimento, String senha) {
    //     this.id = id;
    //     this.nome = nome;
    //     this.data_nascimento = data_nascimento;
    //     this.senha = senha;
    // }
    
    public Long getId() {
        return id;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public void setId(long id) {
        this.id = id;
    }

	public Object getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNome(Object nome) {
		// TODO Auto-generated method stub
		
	}
}