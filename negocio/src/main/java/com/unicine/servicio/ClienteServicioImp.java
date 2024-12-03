package com.unicine.servicio;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.unicine.entidades.Cliente;
import com.unicine.repo.ClienteRepo;

import jakarta.validation.Valid;

@Service
@Validated
public class ClienteServicioImp implements ClienteServicio {

    // NOTE: Teoricamente se uitlizaria el @Autowired para inyectar dependencias, donde se instancia por si solo la clase que se necesita, pero se recomienda utilizar el constructor para eso, ya que el @Service no es va a instanciar
    private final ClienteRepo clienteRepo;

    public ClienteServicioImp(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    /**
     * Método que verifica si el correo ya esta registrado
     * @param correo
     * @return si existe el correo devuelve true, de lo contrario false
     */
    private boolean correoRepetido(String correo) {

        Optional<Cliente> cliente = clienteRepo.findByCorreo(correo);
        return cliente.isPresent();
    }

    /**
     * Metodo que verifica si la cedula ya esta registrada
     * @param cedula
     * @return si existe la cedula devuelve true, de lo contrario false
     */
    private boolean comprobarCedula(Integer cedula) {

        Optional<Cliente> cliente = clienteRepo.findById(cedula);
        return cliente.isPresent();
    }

    private int validarDigitos(Integer numero) {

        return (int) (Math.log10(numero) + 1);
    }

    /**
     * Método que calcula la edad de un cliente
     * @param fecha de nacimiento
     * @return la edad del cliente
     */
    public int calcularEdad(LocalDate fechaNacimiento) {

        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNacimiento, fechaActual).getYears();
    }

    @Override
    public Cliente login(@Valid String correo, String password) throws Exception {

        Optional<Cliente> cliente = clienteRepo.comprobarAutenticacion(correo, password);

        if (cliente.isEmpty()){
            throw new Exception("Los datos de autenticación son incorrectos");
        }
        if (!cliente.get().getEstado()) {
            throw new Exception("El cliente no esta activo, debe activarla con el enlace que fue enviado a su correo");
        }

        return  cliente.get();
    }

    @Override
    public Cliente registrar(@Valid Cliente cliente) throws Exception {

        int longitud = validarDigitos(cliente.getCedula());    // Calculo para obtener la longitud de la cedula

        boolean correoExiste = correoRepetido(cliente.getCorreo());

        boolean cedulaExiste = comprobarCedula(cliente.getCedula());

        int obtenerEdad = calcularEdad(cliente.getFechaNacimiento());
        
        if (longitud < 7) {
            throw new Exception("La cedula no puede tener menos de siete digitos"); 
        }

        if (longitud > 10) {
            throw new Exception("La cedula no puede tener mas de diez digitos");
        }

        if (cedulaExiste) {
            throw new Exception("Esta cedula ya esta registrada");
        }
        
        if (correoExiste) {
            throw new Exception("Este correo ya esta registrado");
        }

        if (obtenerEdad <= 18) {
            throw new Exception("El cliente debe ser mayor de edad para registrarse");
        }


        /* StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
        cliente.setPassword(spe.encryptPassword(cliente.getPassword())); */
        Cliente registro = clienteRepo.save(cliente);

        /* AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword("teclado");

        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt = ldt.atZone(ZoneId.of("America/Bogota"));

        String param1 = textEncryptor.encrypt(registro.getCorreo());
        String param2 = textEncryptor.encrypt(""+zdt.toInstant().toEpochMilli());

        emailServicio.enviarEmail("Registro en unicine", "Por favor acceda al siguiente enlace para activar la cuenta: http://localhost:8080/activar_cuenta.xhtml?p1="+param1+"&p2="+param2, cliente.getCorreo()); */
        return registro;
    }

    @Override
    public Cliente actualizar(@Valid Cliente cliente) throws Exception {

        Optional<Cliente> actualizado = clienteRepo.findById(cliente.getCedula());

        boolean correoExiste = correoRepetido(cliente.getCorreo());

        if (actualizado.isEmpty()) {
            throw new Exception("El cliente no existe");
        }

        if (correoExiste) {
            throw new Exception("Este correo ya esta registrado");
        }

        return clienteRepo.save(cliente);
    }

    @Override
    public void eliminar(@Valid Integer cedula) throws Exception {

        int longitud = validarDigitos(cedula);

        if (longitud < 7) {
            throw new Exception("La cedula no puede tener menos de siete digitos"); 
        }

        if (longitud > 10) {
            throw new Exception("La cedula no puede tener mas de diez digitos");
        }

        Optional<Cliente> eliminado = clienteRepo.findById(cedula);

        if (eliminado.isEmpty()) {
            throw new Exception("El cliente no existe");
        }
        
        clienteRepo.delete(eliminado.get());
    }

    @Override
    public Cliente obtener(@Valid Integer cedula) throws Exception {

        int longitud = validarDigitos(cedula);

        if (longitud < 7) {
            throw new Exception("La cedula no puede tener menos de siete digitos"); 
        }

        if (longitud > 10) {
            throw new Exception("La cedula no puede tener mas de diez digitos");
        }

        Optional <Cliente> buscado = clienteRepo.findById(cedula);
        
        if (buscado.isEmpty()) {
            throw new Exception("El cliente no existe");
        }

        return buscado.get();
    }

    @Override
    public List<Cliente> listar() {

        return clienteRepo.findAll();
    }

}
