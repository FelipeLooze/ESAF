package br.com.value.projects.modelo;

public class CPF {
    private String numero;

    public CPF(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
    
    public boolean isValid() {
        return numero.length() == 11;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        CPF other = (CPF) obj;
        return numero != null && numero.equals(other.numero);
    }

    @Override
    public int hashCode() {
        return numero != null ? numero.hashCode() : 0;
    }
}