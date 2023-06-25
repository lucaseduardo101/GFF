package br.com.fiap.gff.adapter.dataprovider.entity;

import br.com.fiap.gff.domain.entity.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class ClienteJPA {
    @Column(name = "id_cliente")
    @Id
    int idCliente;
    @Column
    String nome;
    @Column
    String cpf;
    @Column
    String email ;
    @Column
    String telefone;
    @Column
    String senha ;

    public ClienteJPA() {
    }

    public Cliente toEntity(){
        return new Cliente(this.idCliente, this.nome,this.cpf, this.email,this.telefone,this.senha);
    }

    public ClienteJPA(int idCliente, String nome, String cpf, String email, String telefone, String senha) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
