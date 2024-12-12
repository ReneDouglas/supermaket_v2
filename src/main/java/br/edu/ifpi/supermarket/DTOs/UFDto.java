package br.edu.ifpi.supermarket.DTOs;


public class UFDto {

    private Integer id;
    private String sigla;
    private String nome;
    private RegiaoDTO regiao;

    public UFDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RegiaoDTO getRegiao() {
        return regiao;
    }

    public void setRegiao(RegiaoDTO regiao) {
        this.regiao = regiao;
    }
}
