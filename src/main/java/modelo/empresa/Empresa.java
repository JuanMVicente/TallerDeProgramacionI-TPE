
package modelo.empresa;

import java.util.Collection;
import java.util.Date;

import enums.EstadoMesa;
import exceptions.IdIncorrectoException;
import exceptions.MesaYaLiberadaException;
import exceptions.MesaYaOcupadaException;
import modelo.archivo.Archivo;
import modelo.configEmpresa.ConfiguracionEmpresa;
import modelo.configEmpresa.Mesa;
import modelo.configEmpresa.Mozo;
import modelo.configEmpresa.Operario;

public class Empresa {
    private ConfiguracionEmpresa configuracion;
    private Archivo archivo;
    private Collection<Comanda> comandas;
    private Collection<MozoMesa> asignacionMozosMesas;
    private Collection<Promocion> promociones;
    private Operario usuario; 
    
    
    
    public Empresa(ConfiguracionEmpresa configuracion, Operario usuario) {
		super();
		this.configuracion = configuracion;
		this.usuario = usuario;
		
	}

	/**
     * Se encarga de asignarle un Mozo a una mesa un determinado dia, y guarda esta asignacion en la coleccion asignacionMozosMesas
     * @param mozo : el mozo al que se le asignara la mesa
     * @param mesa : la mesa que se le asignara al mozo
     * @param dia : dia especifico en que va a ocurrir esta asignacion
     * pre: mozo debe ser distinto de null
     * post: se añadira una nueva asignacion a la coleccion 
     */
    public void AsignarMozo(Mozo mozo,Mesa mesa,Date dia) {
    	MozoMesa aux= new MozoMesa(dia,mozo,mesa);
    	this.asignacionMozosMesas.add(aux);
    	
    }
    
    /**
     * Se encarga de generar una nueva comanda y agregarla a la coleccion de Comandas
     * @param mesa : la mesa a la cual se le asignaran los distinos pedidos
     * @throws MesaYaOcupadaException : si la mesa ya esta ocupada con otra comanda
     * pre : mesa != null
     * post : se añadira una nueva comanda a la coleccion 
     * post : la mesa pasa a estado ocupado
     */
    
    public void NuevaComanda(Mesa mesa) throws MesaYaOcupadaException{ //falta cumplir contrato
    	if(mesa.getEstado()==EstadoMesa.LIBRE) {
    		Comanda aux= new Comanda(mesa);
    		mesa.ocuparMesa();
    		this.comandas.add(aux);
    		
    	}
    	else
    		throw new MesaYaOcupadaException();
    	
    }
    
    /**
     * Se encarga de crear una nueva promocion de prodcuto
     * @param dias : los dias que se activara esta nueva promocion
     * @param posporuno : si esta promocion hace 2x1 en los productos
     * @param dtoporcant : si esta promocion agrega descuento por comprar determinada cantidad
     * @param cantmin : la cantidad minima que se tiene que comprar para poder aplicar el descuento
     * @param preciounitario : el precio por cada unidad aplicando el descuento
     * pre: cantmin >= 1
     * pre : preciounitario >0
     * pre : dias != null
     * post: se añadira una nueva promocion a la coleccion 
     */
    
    public void NuevaPromocion(int dias,boolean dosporuno, boolean dtoporcant,int cantmin,double preciounitario){
    	int id=this.promociones.size()+1;
    	Promocion aux = new PromocionProducto(id,dias,dosporuno,dtoporcant,cantmin,preciounitario);
    	this.promociones.add(aux);
    	
    	
    }
    
    /**
     * Se encarga de crear una nueva promocion de prodcuto
     * @param dias : los dias que se activara esta nueva promocion
     * @param nombre : nombre de la promocion
     * @param formapago : metodo de pago disponibles para que se aplique el descuento
     * @param porcentajedto : la cantidad que se descontara al precio aplicando esta promocion
     * @param acumulable : si es acumulable esta promocion temporal con las promociones de productos especificos
     * pre: dias es distindo de null y son dias validos
     * pre : nombre != null
     * pre : formapago es distinto de null y son validas
     * post: se añadira una nueva promocion a la coleccion 
     */
    
    public void NuevaPromocionTemp(int dias,String nombre,String formapago,int porcentajedto,boolean acumulable){
    	int id=this.promociones.size()+1;
    	Promocion aux = new PromocionTemp(id,dias,formapago,porcentajedto,acumulable,nombre);
    	this.promociones.add(aux);
    	
    }
    
    /**
     * Se encarga de desactivar una comanda activa
     * @param comanda : comanda que se quiere cerrar
     * @throws MesaYaLiberadaException : si la mesa ya fue liberada
     * pre : comanda != null
     * post : la comanda pasara a estado "Cerrada"
     * post : la mesa asociada a la comanda pasara de estado "ocupada" a estado "libre"
     * post : facturacion de la comanda , verifica si cumple con alguna promocion activa
     */
    
    public void CerrarComanda(Comanda comanda){
    	comanda.CerrarComanda();
    	try {
			comanda.getMesa().liberarMesa();
		} catch (MesaYaLiberadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//solicitar facturacion
    	
    }
    
    /**
     * Se encarga de desactivar una promocion activa
     * @param inpromo : id de la promocion que se desea desactivar
     * @throws IdIncorrectoExceptionn : Si no existe el id ingresado
     * pre : idpromo != null
     * post : el estado de la promocion asociada al idpromo pasa a desactivada (activa=false)
     */
    
    public void Desactivarpromocion(int idpromo) throws IdIncorrectoException {
    	if(idpromo>0 && idpromo<=this.promociones.size()) {
        	Promocion aux=(Promocion) this.promociones.toArray()[idpromo];
        	aux.DesactivarPromocion();
        	}
        	else
        		throw new IdIncorrectoException();
    	
    }
    
    /**
     * Se encarga de activar una promocion desactivada
     * @param inpromo : id de la promocion que se desea activar
     * @throws IdIncorrectoExceptionn : Si no existe el id ingresado
     * pre : idpromo != null
     * post : el estado de la promocion asociada al idpromo pasa a activa (activa=true)
     */
    
    public void ActivarPromocion(int idpromo) throws IdIncorrectoException {
    	if(idpromo>0 && idpromo<=this.promociones.size()) {
    	Promocion aux=(Promocion) this.promociones.toArray()[idpromo];
    	aux.ActivarPromocion();
    	}
    	else
    		throw new IdIncorrectoException();
    }

}


