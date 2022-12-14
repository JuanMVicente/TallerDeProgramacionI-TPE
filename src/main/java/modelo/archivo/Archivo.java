package modelo.archivo;

import java.util.Collection;

import modelo.empresa.Comanda;
import modelo.empresa.MozoMesa;

/**
 * Clase que archiva todos los documentos históricos relacionados al sistema
 * @author
 *
 */
public class Archivo {
	
	private static Archivo instance = null;
    private Collection<Factura> facturas;
    private Collection<Comanda> comandas;
    private Collection<MozoMesa> mozoMesas;
    private Collection<Asistencia> registroDeAsistencia;
	
    
    /**
     * Constructor de la clase Archivo que llama al get instance
     */
    public Archivo() {
    	Archivo.getInstance();
    }
    
    
    /**
     * Patron Singleton para el sistema de archivos del sistema
     * @return instancia única de archivos
     */
    public static Archivo getInstance() {
    	if(instance == null)
    		return instance = new Archivo();
    	else
    		return instance;
    }
    
    
    /**
     * Permite la consulta de la lista de registros históricos
     * @return colección de facturas históricas
     */
    public Collection<Factura> getFacturas() {
    	return facturas;
    }
    
    
    /**
     * Agrega al listado histórico un nuevo registro
     * @param factura que se desea agregar al listado histórico
     */
	public void agregaFacturas(Factura factura) {
		this.facturas.add(factura);
	}
	
	
	/**
	 * Permite la consulta de la lista de registros históricos
	 * @return colección de comandas históricas
	 */
	public Collection<Comanda> getComandas() {
		return comandas;
	}
	
	
	/**
	 * Agrega al listado histórico un nuevo registro
	 * @param comanda que se desea agregar al listado histórico
	 */
	public void agregaComandas(Comanda comanda) {
		this.comandas.add(comanda);
	}
	
	
	/**
	 * Permite la consulta de la lista de registros históricos
	 * @return colección de registro mozo-meza históricas
	 */
	public Collection<MozoMesa> getMozoMesas() {
		return mozoMesas;
	}
	
	
	/**
	 * Agrega al listado histórico un nuevo registro
	 * @param mozoMesa que se desea agregar al listado histórico
	 */
	public void agregaMozoMesa(MozoMesa mozoMesa) {
		this.mozoMesas.add(mozoMesa);
	}
	
	
	/**
	 * Permite la consulta de la lista de registros históricos
	 * @return colección de registro de asistencias históricas
	 */
	public Collection<Asistencia> getRegistroDeAsistencia() {
		return registroDeAsistencia;
	}
	
	
	/**
	 * Agrega al listado histórico un nuevo registro
	 * @param registroDeAsistencia que se desea agregar al listado histórico
	 */
	public void agregaRegistroDeAsistencia(Asistencia registroDeAsistencia) {
		this.registroDeAsistencia.add(registroDeAsistencia);
	}
    
}
