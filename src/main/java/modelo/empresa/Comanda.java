package modelo.empresa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import enums.EstadoComanda;
import modelo.configEmpresa.Mesa;
import modelo.configEmpresa.Producto;

public class Comanda {

    private Date fecha;
    private Mesa mesa;
    private Collection<Pedido> listaDePedidos;
    private EstadoComanda estado;
    
    
    
    
    public Comanda(Mesa mesa) {
		super();
		this.mesa = mesa;
		this.estado = EstadoComanda.Abierta;
		this.listaDePedidos=new ArrayList<Pedido>();
		this.fecha = new Date();
		
		
	}

	/**
     * Se encarga de agregar un pedido a la comanda
     * @param prod : producto a agregar
     * @param cant : la cantidad que se desea pedir
     * pre : prod != null
     * pre: cant>0
     * post : se agrega un nuevo pedido a la coleccion
     */
    
	public void AgregarPedido(Producto prod,int cant) {
		Pedido aux=new Pedido(prod,cant);
		this.listaDePedidos.add(aux);
		
		
	}
	
	public void CerrarComanda() {
		this.estado=EstadoComanda.Cerrada;
		
	}

	public Date getFecha() {
		return fecha;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public Collection<Pedido> getListaDePedidos() {
		return listaDePedidos;
	}

	public EstadoComanda getEstado() {
		return estado;
	}
	
	
    
}
