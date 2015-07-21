package com.example.android.adapters;

/**
 * Created by Ismael on 04/06/2015.
 */
public class Clima {
    private String dia;
    private String estado;
    private String temperatura;
    private int icono;

    public Clima(){
        this.dia="";
        this.estado="";
        this.temperatura="";
        this.icono=0;
    }

    public Clima(String dia, String estado, String temperatura, int icono) {
        this.dia = dia;
        this.estado = estado;
        this.temperatura = temperatura;
        this.icono = icono;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }



    @Override
    public String toString() {
        return "Dia: " + dia + ", estado: "+ estado + ", temperatura: " + temperatura;
    }
}
