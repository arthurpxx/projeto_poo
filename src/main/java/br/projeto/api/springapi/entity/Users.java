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
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date data_nascimento;

    @Column(name = "telefone", nullable = false)
    private Integer telefone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "endereco", nullable = false)
    private String endereco;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "senha", nullable = false)
    private String senha;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="agendamento_id")
    private List<Agendamento> agendamentos;

    // public Users(Long id, String nome, String data_nascimento, String senha) {
    //     this.id = id;
    //     this.nome = nome;
    //     this.data_nascimento = data_nascimento;
    //     this.senha = senha;
    // }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public Date getDataNascimento() {
        return data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public String getendereco() {
        return endereco;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setendereco(String endereco) {
        this.endereco = endereco;
    }

    public void setId(long id) {
        this.id = id;
    }
}