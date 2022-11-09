package modelo.configEmpresa;

import java.io.Serializable;

import enums.EstadoMesa;
import exceptions.MesaYaLiberadaException;
import exceptions.MesaYaOcupadaException;


public class Mesa implements Serializable {
    
    private int nroMesa;
    private int cantSillas;
    private EstadoMesa estado = EstadoMesa.LIBRE;

    /**
     * Crea una nueva mesa en estado LIBRE
     *
     * @param nroMesa    : el numero de la mesa
     * @param cantSillas : la cantidad de que posee sillas la mesa
     *                   pre: cantSillas > 0 && (nroMesa >= 1 ) ? cantSillas >= 2
     *                   nroMesa >= 0
     */
    public Mesa(int nroMesa, int cantSillas) {
    	this.nroMesa = nroMesa;
    	this.cantSillas = cantSillas;
    }

    /**
     *Retorna la cantidad de sillas de la mesa
     * @return Cantidad de sillas de la mesa
     */
    public int getCantSillas() {
        return cantSillas;
    }

    /**
     * Determina la cantidad de sillas de la mesa
     * @param cantSillas : Nueva cantidad de sillas
     */
    protected void setCantSillas(int cantSillas){
    	this.cantSillas = cantSillas;
    }

    /**
     * Retorna el estado de la mesa
     *
     * @return estado de la mesa
     */
    public EstadoMesa getEstado() {
        return this.estado;
    }

    /**
     * Se encarga de ocupar la mesa
     * @throws MesaYaOcupadaException : Si la mesa ya se encuentra ocupada
     */
    public void ocuparMesa() throws MesaYaOcupadaException {
    	if(this.estado != EstadoMesa.OCUPADA) {
    		this.estado = EstadoMesa.OCUPADA;
    	}
    	else
    		throw new MesaYaOcupadaException();
    }
    

    /**
     * Se encarga de liberar la mesa actual
     * @throws MesaYaLiberadaException : Si la mesa ya se encuentra liberada
     */
    public void liberarMesa() throws MesaYaLiberadaException {
    	if(this.estado != EstadoMesa.LIBRE) {
    		this.estado = EstadoMesa.LIBRE;
    	}
    	else
    		throw new MesaYaLiberadaException();
    }

}

