package cl.conversor.modelos;
import cl.conversor.modelos.ConsultaApi;
import cl.conversor.modelos.RespuestaApi;

public class Service {
    private double monto;
    private double resultado;
    private String monedaUno;
    private String monedaDos;

    public void convertir(String monedaUno, String monedaDos, double monto){
        this.monto = monto;
        this.monedaUno = monedaUno;
        this.monedaDos = monedaDos;
        ConsultaApi consulta = new ConsultaApi();
        RespuestaApi respuesta = consulta.obtenerDatos(monedaUno, monedaDos);

        resultado = monto * respuesta.conversion_rate();

        System.out.println("\n=====Monto trnasformado====");
        System.out.printf("%.2f %s = %.2f %s\n", monto, monedaUno, resultado, monedaDos);

    }

    @Override
    public String toString() {
        return String.format("%.2f %s = %.2f %s\n", monto, monedaUno, resultado, monedaDos);
    }
}
