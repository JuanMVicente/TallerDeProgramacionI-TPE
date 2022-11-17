package modelo.empresa;

import java.util.ArrayList;
import java.util.Collection;

import modelo.configEmpresa.Producto;

public class PromocionProducto extends Promocion {

	

	private Collection<Producto> productos;
	private boolean dosporuno;
	private boolean dtoporcant;
	private int cantminima;
	private double preciounitario;
	
	public PromocionProducto(int idprom,int dias,boolean dosporuno,boolean dtoporcant,int cantminima,double preciounitario) {
		super(idprom,dias);
		this.dosporuno=dosporuno;
		this.dtoporcant=dtoporcant;
		this.cantminima=cantminima;
		this.preciounitario=preciounitario;
		this.productos= new ArrayList<Producto>();
		
		
	
	}
	/**
     * Se encarga de agregar un producto a la promocion
     * @param producto : producto a agregar
     * pre : producto != null
     * post : se agrega un nuevo producto a la coleccion
     */
	
	public void AgregaPorducto(Producto producto) { //ver contrato
		this.productos.add(producto);
		
	}

	public Collection<Producto> getProductos() {
		return productos;
	}

	public boolean isDosporuno() {
		return dosporuno;
	}

	public boolean isDtoporcant() {
		return dtoporcant;
	}

	public int getCantminima() {
		return cantminima;
	}

	public double getPreciounitario() {
		return preciounitario;
	}
	
	
	
	
	
	
}
