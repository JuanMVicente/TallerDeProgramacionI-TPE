package modelo.configEmpresa;

import java.io.Serializable;
import java.util.ArrayList;

import enums.TipoOperario;
import modelo.persist.OperarioDTO;

public class PersistenciaConfiguracion implements Serializable {

    private String nombreLocal;
    private ArrayList<Mozo> mozos;
    private ArrayList<Mesa> mesas;
    private ArrayList<Producto> productos;
    private ArrayList<OperarioDTO> operarios;
    private Sueldo sueldo;
    //Variables encargadas de almacenar los valores estaticos de las clases
    private int nroMozos;
    private int nroOperarios;
    private int nroProductos;


    public PersistenciaConfiguracion(String nombreLocal, ArrayList<Mozo> mozos, ArrayList<Mesa> mesas, ArrayList<Producto> productos, ArrayList<Operario> operarios, Sueldo sueldo){
    	this.nombreLocal = nombreLocal;
    	this.mozos = mozos;
    	this.mesas = mesas;
    	this.productos = productos;
    	this.operarios = this.deOperariosAOperariosDTO(operarios);
    	this.sueldo = sueldo;
    	this.nroMozos = Mozo.getNroMozos();
    	this.nroOperarios = Operario.getNroOperario();
    	this.nroProductos = Producto.getNroProducto();
    }
    	
    	
    public PersistenciaConfiguracion(){
    	
    }

    public void guardarConfiguaracion(){}

    public void recuperarConfiguracion(){}

    public String getNombreLocal() {return nombreLocal;}

    public ArrayList<Mozo> getMozos() {
        return mozos;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public Sueldo getSueldo() {
        return sueldo;
    }

    public ArrayList<OperarioDTO> getOperarios() {
        return operarios;
    }

    
    /**
     * Retorna el numero de mozos (numero usado para obtenr id) almacenado
     * @return Numero de mozos
     */
    public int getNroMozos() {
    	return nroMozos;
    }

    
    /**
     * Retorna el numero de productos (numero usado para obtenr id) almacenado
     * @return Numero de productos
     */
    public int getNroProductos(){ 
    	return nroProductos;
    }

    
    /**
     * Retorna el numero de operarios (numero usado para obtenr id) almacenado
     * @return Numero de operarios
     */
    public int getNroOperarios(){
    	return nroOperarios;
    }
    
    
    public ArrayList<OperarioDTO> deOperariosAOperariosDTO(ArrayList<Operario> operarios){
    	ArrayList<OperarioDTO> operariosDTO = new ArrayList<OperarioDTO>();
    	TipoOperario tipo;
    	for(int i=0;i<operarios.size();i++) {
    		if(operarios.get(0).getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin"))
    			tipo = TipoOperario.ADMIN;
    		else
    			tipo = TipoOperario.COMUN;
    		
    		operariosDTO.add(new OperarioDTO(tipo,operarios.get(i)));
    		
    	}
    	return operariosDTO;
    }
}
