package modelo.configEmpresa;

import java.util.ArrayList;

import enums.EstadoMozo;
import exceptions.DatosLoginIncorrectosException;
import exceptions.IdIncorrectoException;
import exceptions.UsuarioNoAutorizadoException;
import modelo.empresa.Promocion;

public class ConfiguracionEmpresa {
    private static ConfiguracionEmpresa instance = null;
    private String nombreLocal;
    private ArrayList<Mozo> mozos;
    private ArrayList<Mesa> mesas;
    private ArrayList<Producto> productos;
    private ArrayList<Operario> operarios;
    private Sueldo sueldo;
    private PersistenciaConfiguracion persistencia;
    
    // agregado después del contrato
    private ArrayList<Promocion> promociones;

    private ConfiguracionEmpresa(){
    	ConfiguracionEmpresa.getInstance();
    }

    public static ConfiguracionEmpresa getInstance(){
    	if(instance == null)
    		return instance = new ConfiguracionEmpresa();
    	else
    		return instance;
    		
    }

    /**
     * Se encarga de cambiar el nombre del local, para esto el usuario debe ser admin,
     * en caso de no serlo debe emitir una excepcion
     * @param name : Nuevo nombre del local
     * @param user : usuario que intenta realizar la accion
     * @throws UsuarioNoAutorizadoException : Si el usuario no esta autorizado
     * pre: El nombre debe ser un string distinto de nulo y de vacio.
     *      user != null
     * post: nombreLocal = name || new UsuarioNoAutorizadoException
     *
     */
    public void cambiaNombreLocal(String name, Operario user) throws UsuarioNoAutorizadoException {
    	if(user.getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin")) {
    		this.nombreLocal = name;
    	}
    	else {
    		throw new UsuarioNoAutorizadoException();
    	}
    }
    

    /**
     * Se encarga de agregar un nuevo mozo a los registros de la empresa, si el usuario no es admin
     * se emite una excepcion
     * @param nuevoMozo : El nuevo mozo que se desea agregar
     * @param user : El usuario que intenta realizar la accion
     * @throws UsuarioNoAutorizadoException : Si el usuario no esta autorizado
     * pre: el nuevo mozo debe ser distinto de null
     *      user != null
     * post: se añadira un nuevo mozo a la coleccion
     */
    public void AgregaMozo(Mozo nuevoMozo, Operario user) throws UsuarioNoAutorizadoException {
    	if(user.getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin")) {
    		this.mozos.add(nuevoMozo);
    	}
    	else {
    		throw new UsuarioNoAutorizadoException();
    	}
    	
    }
    

    /**
     * Se encarga de actualizar un mozo, si el usuario no es admin se emite una excepcion
     * @param mozoActualizado : El mozo que se desea actualizar
     * @param mozoId : El usuario que intenta realizar la accion
     * @param user : El usuario que intenta realizar la accion
     * @throws UsuarioNoAutorizadoException : Si el usuario no esta autorizado
     * @throws IdIncorrectoException : Si no existe el Id ingresado
     * pre: mozoActualizado no debe ser nulo
     *      user != null
     * post: el mozo del sistema tomara los valores de mozoActulizado,
     */
    public void actualizarMozo(Mozo mozoActualizado, int mozoId, Operario user) throws UsuarioNoAutorizadoException, IdIncorrectoException {
    	if(user.getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin")) {
        	if(mozoId < this.mozos.size()) {
            	this.mozos.get(mozoId).setCantHijos(mozoActualizado.getCantHijos());
            	this.mozos.get(mozoId).setEstado(mozoActualizado.getEstado());
            	this.mozos.get(mozoId).setFechaNacimiento(mozoActualizado.getFechaNacimiento());
            	this.mozos.get(mozoId).setNombreApellido(mozoActualizado.getNombreApellido());
            }
        	else {
        		throw new IdIncorrectoException();
        	}
        }
        else {
        	throw new UsuarioNoAutorizadoException();
        }
    }
    

    /**
     * Se encarga de eliminar un mozo segun su Id
     * @param mozoId : El id del mozo a eleminar
     * @param user : El usuario que intenta realizar la accion
     * @throws UsuarioNoAutorizadoException : Si el usuario no esta autorizado
     * @throws IdIncorrectoException : Si no existe el Id ingresado
     * pre: user != null
     * post: Se eliminara el mozo con el id ingresado de la coleccion
     */
    public void eliminaMozo(int mozoId, Operario user) throws UsuarioNoAutorizadoException, IdIncorrectoException {
    	if(user.getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin")) {
    		if(mozoId < this.mozos.size()) {
        		this.mozos.get(mozoId).setEstado(EstadoMozo.INACTIVO);
        	}
    		else {
    			throw new IdIncorrectoException();
    		}
    	}
    	else {
    		throw new UsuarioNoAutorizadoException();
    	}
    }
    

    /**
     * Se agrega una mesa al registro de la empresa, si el usuario no es admin se emite una exception
     * @param nuevaMesa : La mesa que se quiere agregar
     * @param user : El usuario que intenta realizar dicha accion
     * @throws UsuarioNoAutorizadoException : Se emite si el usuario no esta autorizado
     * pre: nuevaMesa != null
     *      user != null
     * post: Se agrega la meza a la coleccion de mesas
     */
    public void agregarMesa(Mesa nuevaMesa, Operario user) throws  UsuarioNoAutorizadoException {
    	if(user.getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin")) {
    		this.mesas.add(nuevaMesa);
    	}
    	else {
    		throw new UsuarioNoAutorizadoException();
    	}
    }

    /**
     * Se actualiza la mesa en el sistema
     * @param mesaActualizada : La mesa con los valores actualizados
     * @param nroMesa : el numero de la mesa
     * @param user : El usuario que intenta realizar la accion;
     * @throws UsuarioNoAutorizadoException : Se emite si el usuario no esta autorizado
     * @throws IdIncorrectoException : Si no existe el Id ingresado
     * pre: mesaAcutalizada != null
     *      user != null
     * post: Se actualiza la mesa en la coleccion.
     */
    public void actulizarMesa(Mesa mesaActualizada, int nroMesa, Operario user) throws UsuarioNoAutorizadoException, IdIncorrectoException{
    	if(user.getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin")) {
        	if(nroMesa < this.mesas.size()) {
            	this.mesas.get(nroMesa).setCantSillas(mesaActualizada.getCantSillas());
            }
        	else {
        		throw new IdIncorrectoException();
        	}
        }
        else {
        	throw new UsuarioNoAutorizadoException();
        }
    }

    /**
     * Se elimina de la colecicon la mesa indicada
     * @param nroMesa : el numero de la mesa a eliminar
     * @param user : El usuario que intenta realizar la accion
     * @throws UsuarioNoAutorizadoException : Se emite si el usuario no esta autorizado
     * @throws IdIncorrectoException : Si no existe el Id ingresado
     * pre: user != null
     * post: Se elimina la mesa de la coleccion
     */
    public void eliminarMesa(int nroMesa, Operario user) throws UsuarioNoAutorizadoException, IdIncorrectoException {
    	if(user.getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin")) {
    		this.mesas.get(nroMesa).inactivarMesa();
    	}
    	else {
    		throw new UsuarioNoAutorizadoException();
    	}
    	
    };

    /**
     * Se agrega un producto al registro de la empresa, si el usuario no es admin se emite una exception
     * @param nuevoProducto : El producto que se quiere agregar
     * @param user : El usuario que intenta realizar dicha accion
     * @throws UsuarioNoAutorizadoException : Se emite si el usuario no esta autorizado
     * pre: nuevoProducto != null
     *      user != null
     * post: Se agrega el producto a la coleccion de mesas
     */
    public void agregarProducto(Producto nuevoProducto, Operario user) throws  UsuarioNoAutorizadoException {
    	if(user.getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin")) {
    		this.productos.add(nuevoProducto);
    	}
    	else {
    		throw new UsuarioNoAutorizadoException();
    	}

    }

    /**
     * Se actualiza un producto en el sistema
     * @param productoActualizado : El producto con los valores actualizados
     * @param productoId : el Id del producto
     * @param user : El usuario que intenta realizar la accion;
     * @throws UsuarioNoAutorizadoException : Se emite si el usuario no esta autorizado
     * @throws IdIncorrectoException : Si no existe el Id ingresado
     * pre: productoActualizado != null
     *      user != null
     * post: Se actualiza el producto en la coleccion.
     */
    public void actulizarProducto(Producto productoActualizado, int productoId, Operario user) throws UsuarioNoAutorizadoException, IdIncorrectoException{
    	if(user.getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin")) {
        	if(productoId < this.productos.size()) {
            	this.productos.get(productoId).setNombre(productoActualizado.getNombre());
            	this.productos.get(productoId).setPrecioCosto(productoActualizado.getPrecioCosto());
            	this.productos.get(productoId).setPrecioVenta(productoActualizado.getPrecioVenta());
            	this.productos.get(productoId).setStock(productoActualizado.getStock());
            }
        	else {
        		throw new IdIncorrectoException();
        	}
        }
        else {
        	throw new UsuarioNoAutorizadoException();
        }
    }

    /**
     * Se elimina de la colecicon el producto indicada
     * @param idProducto : el id del producto a eliminar
     * @param user : El usuario que intenta realizar la accion
     * @throws UsuarioNoAutorizadoException : Se emite si el usuario no esta autorizado
     * @throws IdIncorrectoException : Si no existe el Id ingresado
     * pre: user != null
     * post: Se elimina el producto de la coleccion
     */
    public void eliminarProducto(int idProducto, Operario user) throws UsuarioNoAutorizadoException, IdIncorrectoException {
    	//por ahora no lo voy a implementar después vemos si conviene
    };

    /**
     * Se agrega un operario al registro de la empresa, si el usuario no es admin se emite una exception
     * @param nuevoOperario : el operario que se quiere agregar
     * @param user : El usuario que intenta realizar dicha accion
     * @throws UsuarioNoAutorizadoException : Se emite si el usuario no esta autorizado
     * pre: nuevoOperario != null
     *      user != null
     * post: Se agrega el operario a la coleccion de mesas
     */
    public void agregarOperario(Operario nuevoOperario, Operario user) throws  UsuarioNoAutorizadoException {
    	if(user.getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin")) {
    		this.operarios.add(nuevoOperario);
    	}
    	else {
    		throw new UsuarioNoAutorizadoException();
    	}
    }

    /**
     * Se actualiza un operario en el sistema
     * @param operarioActualizado : El operario con los valores actualizados
     * @param idOperario : el Id del operario
     * @param user : El usuario que intenta realizar la accion;
     * @throws UsuarioNoAutorizadoException : Se emite si el usuario no esta autorizado
     * @throws IdIncorrectoException : Si no existe el Id ingresado
     * pre: operarioActualizado != null
     *      user != null
     * post: Se actualiza el operario en la coleccion.
     */
    public void actualizarOperario(Operario operarioActualizado, int idOperario, Operario user) throws UsuarioNoAutorizadoException, IdIncorrectoException{
    	if(user.getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin")) {
        	if(idOperario < this.operarios.size()) {
            	this.operarios.get(idOperario).setNombreApellido(operarioActualizado.getNombreApellido());
            	this.operarios.get(idOperario).setActivo(operarioActualizado.getActivo());
            	this.operarios.get(idOperario).setNombreUsuario(operarioActualizado.getNombreUsuario());
            	this.operarios.get(idOperario).setPassword(operarioActualizado.getPassword());
            }
        	else {
        		throw new IdIncorrectoException();
        	}
        }
        else {
        	throw new UsuarioNoAutorizadoException();
        }
    }

    /**
     * Se elimina de la colecicon el producto indicada
     * @param idOperario : el id del operario a eliminar
     * @param user : El usuario que intenta realizar la accion
     * @throws UsuarioNoAutorizadoException : Se emite si el usuario no esta autorizado
     * @throws IdIncorrectoException : Si no existe el Id ingresado
     * pre: user != null
     * post: Se elimina el opeario de la coleccion
     */
    public void eliminarOperario(int idOperario, Operario user) throws UsuarioNoAutorizadoException, IdIncorrectoException {
    	//por ahora no lo voy a implementar después vemos si conviene
    };

    /**
     * Se encarga de actualizar el elemento sueldo de la empresa
     * @param nuevoSueldo : el nuevo sueldo
     * @throws UsuarioNoAutorizadoException : Si el usuario no se encuentra autorizado
     * pre: sueldo != null
     * post: this.sueldo = nuevoSueldo;
     */
    public void actualizarSueldo(Sueldo nuevoSueldo, Operario user) throws UsuarioNoAutorizadoException {
    	if(user.getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin")) {
    		this.sueldo = nuevoSueldo;
    	}
    	else {
    		throw new UsuarioNoAutorizadoException();
    	}
    }

    /**
     * Si el nombre de usuario y contraseña son correctas, retorna el operario correspondiente
     * @param nombreDeUsuario : Nombre de usuario del operario
     * @param password : Contraseña del operario
     * @return El operario correspondiente con el nombre de usuario.
     * @throws DatosLoginIncorrectosException : Si el nombre de usuario o contraseñas son incorrectos
     * pre: nombreDeUsuario != null && nombreDeUsuario != ""
     *      password != null && password != ""
     * post: retorna el operario deseado.
     */
    public Operario login(String nombreDeUsuario, String password) throws DatosLoginIncorrectosException {

		int i=0;
		if(operarios.size()!=0){
			while(operarios.size()>i && (!operarios.get(i).getNombreUsuario().equalsIgnoreCase(nombreDeUsuario))) 
				i++;
				if(i<operarios.size())
					if((operarios.get(i).getPassword().equalsIgnoreCase(password))) 
						return operarios.get(i);
					else
						throw new DatosLoginIncorrectosException();
				else
					throw new DatosLoginIncorrectosException();
		}
    	else {
    		return null;
    	}
    }

    /**
     * Retorna los operarios del sistema, si el usuario no esta autorizado se emite una excepcion
     * @param user : usuario que intenta realizar dicha accion
     * @return La coleccion de operarios
     * @throws UsuarioNoAutorizadoException : Si el usuario no se encuentra autorizado
     * pre: user != null
     * post: retorna this.operarios
     */
    public ArrayList<Operario> getOperarios(Operario user) throws UsuarioNoAutorizadoException { 
    	if(user.getClass().toString().equals("class modelo.configEmpresa.OperarioAdmin")) {
    		return this.operarios;
    	}
    	else {
    		throw new UsuarioNoAutorizadoException();
    	}
    }
    

    /**
     * Retorna los mozos del sistema
     * @return Los mozos del sistema
     */
    public ArrayList<Mozo> getMozos() {
    	return this.mozos;
    }
    

    /**
     * Retorna el mozo correspondiente al id ingresado, en caso de que no exista dicho id arroja una excepcion
     * @param mozoId : Id del mozo deseado
     * @return el mozo correspondiente al id ingresado
     * @throws IdIncorrectoException Si el Id no corresponde
     */
    public Mozo getMozoById(int mozoId) throws IdIncorrectoException {
    if(mozoId<this.mozos.size()) {
    		return this.mozos.get(mozoId);
    	}
    	else {
    		throw new IdIncorrectoException();
    	}
    }

    /**
     * Retorna las mesas del sistema
     * @return Las mesas del sistema
     */
    public ArrayList<Mesa> getMesas() {
    	return this.mesas;
    }
    

    /**
     * Retorna la mesa correspondiente al id ingresado, en caso de que no exista dicho id arroja una excepcion
     * @param nroMesa : numero de la mesa deseado
     * @return la mesa correspondiente al id ingresado
     * @throws IdIncorrectoException Si el Id no corresponde
     */
    public Mesa getMesaNroMesa(int nroMesa) throws IdIncorrectoException {
        if(nroMesa<this.mesas.size()) {
    		return this.mesas.get(nroMesa);
    	}
    	else {
    		throw new IdIncorrectoException();
    	}
    }

    /**
     * Retorna los productos del sistema
     * @return Los productos del sistema
     */
    public ArrayList<Producto> getProductos() {
    	return this.productos;
    }

    /**
     * Retorna el producto correspondiente al id ingresado, en caso de que no exista dicho id arroja una excepcion
     * @param productoId : Id del producto deseado
     * @return el producto correspondiente al id ingresado
     * @throws IdIncorrectoException Si el Id no corresponde
     */
    public Producto getProductoById(int productoId) throws IdIncorrectoException {
        if(productoId<this.productos.size()) {
    		return this.productos.get(productoId);
    	}
    	else {
    		throw new IdIncorrectoException();
    	}
    }

    /**
     * Retorna el elemento sueldo de la empresa
     * @return El elemento sueldo de la empresa
     */
    public Sueldo getSueldo() { 
    	return this.sueldo;
    }

    /**
     * Determina el elemento sueldo de la empresa
     * @param nuevoSueldo : El nuevo elemento sueldo
     * @throws UsuarioNoAutorizadoException : Si el usuario no se encuentra autorizado
     *
     * pre: nuevoSueldo != null;
     * post : this.sueldo == nuevoSueldo;
     */
    public void setSueldo(Sueldo nuevoSueldo) throws UsuarioNoAutorizadoException {
    	this.sueldo = nuevoSueldo;
    }

    /**
     * Se encarga de guardar la configuracion de la empresa
     * (faltan agregar las excepciones correspondientes)
     */
    public void guardarConfiguracion(){}

    /**
     * Se encarga de recuperar la configuracion de la empresa
     * (faltan agregar las excepciones correspondientes)
     */
    public void recuperarConfiguracion(){}

    
    //agregado luego de hacer los javadoc
	public ArrayList<Operario> getOperarios() {
		return operarios;
	}

	public void setOperarios(ArrayList<Operario> operarios) {
		this.operarios = operarios;
	}

	public ArrayList<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(ArrayList<Promocion> promociones) {
		this.promociones = promociones;
	}

	public String getNombreLocal() {
		return nombreLocal;
	}
	
	public void agregaPromociones(Promocion promocion) {
		this.promociones.add(promocion);
	}
}
