package com.unicine.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unicine.entidades.Administrador;
import com.unicine.repo.AdministradorRepo;

@Service
public class AdministradorServicioImp implements AdministradorServicio {

    // NOTE: Teoricamente se uitlizaria el @Autowired para inyectar dependencias, donde se instancia por si solo la clase que se necesita, pero se recomienda utilizar el constructor para eso, ya que el @Service no es va a instanciar
    private final AdministradorRepo administradorRepo;

    public AdministradorServicioImp(AdministradorRepo administradorRepo) {
        this.administradorRepo = administradorRepo;
    }

    @Override
    public Administrador login(String correo, String password) throws Exception {

        Optional<Administrador> administrador = administradorRepo.comprobarAutenticacion(correo, password);

        if (!administrador.isPresent()){
            throw new Exception("Los datos de autenticación son incorrectos");
        }

        return  administrador.get();
    }

    @Override
    public Administrador registrar(Administrador administrador) throws Exception {
        
        boolean correoExiste = correoRepetido(administrador.getCorreo());

        if (correoExiste) {
            throw new Exception("Este correo ya esta registrado");
        }

        /* StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
        administrador.setPassword(spe.encryptPassword(administrador.getPassword())); */
        Administrador registro = administradorRepo.save(administrador);

        /* AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword("teclado");

        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt = ldt.atZone(ZoneId.of("America/Bogota"));

        String param1 = textEncryptor.encrypt(registro.getCorreo());
        String param2 = textEncryptor.encrypt(""+zdt.toInstant().toEpochMilli());

        emailServicio.enviarEmail("Registro en unicine", "Por favor acceda al siguiente enlace para activar la cuenta: http://localhost:8080/activar_cuenta.xhtml?p1="+param1+"&p2="+param2, administrador.getCorreo()); */
        return registro;
    }

    /**
     * Método que verifica si el correo ya esta registrado
     * @param correo
     * @return si existe el correo devuelve true, de lo contrario false
     */
    private boolean correoRepetido(String correo) {

        Optional<Administrador> administrador = administradorRepo.findByCorreo(correo);
        return administrador.isPresent();
    }

    @Override
    public Administrador actualizar(Administrador administrador) throws Exception {
        
        Optional<Administrador> actualizado = administradorRepo.findById(administrador.getCedula());

        if (actualizado.isEmpty()) {
            throw new Exception("El administrador no existe");
        }

        return administradorRepo.save(administrador);
    }

    @Override
    public void eliminar(Integer cedula) throws Exception {

        if (cedula == null) {
            throw new Exception("Es necesario la cedula del usuario");
        }

        Integer length = (int) (Math.log10(cedula) + 1);    // Calculo para obtener la longitud de la cedula
        
        if (length > 10 || length < 7) {
            throw new Exception("La cedula no puede tener más de diez digitos, ni menos de siete"); 
        }

        Optional<Administrador> eliminado = administradorRepo.findById(cedula);

        if (eliminado.isEmpty()) {
            throw new Exception("El administrador no existe");
        }
        
        administradorRepo.delete(eliminado.get());
    }

    @Override
    public Administrador obtener(Integer cedula) throws Exception {

        if (cedula == null) {
            throw new Exception("Es necesario la cedula del usuario");
        }

        Integer length = (int) (Math.log10(cedula) + 1);    // Calculo para obtener la longitud de la cedula
        
        if (length > 10 || length < 7) {
            throw new Exception("La cedula no puede tener más de diez digitos, ni menos de siete"); 
        }

        Optional <Administrador> buscado = administradorRepo.findById(cedula);
        
        if (buscado.isEmpty()) {
            throw new Exception("El administrador no existe");
        }

        return buscado.get();
    }

    @Override
    public List<Administrador> listar() {

        return administradorRepo.findAll();
    }

}
