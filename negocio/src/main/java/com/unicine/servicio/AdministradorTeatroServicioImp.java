package com.unicine.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unicine.entidades.AdministradorTeatro;
import com.unicine.repo.AdministradorTeatroRepo;

@Service
public class AdministradorTeatroServicioImp implements AdministradorTeatroServicio {

    // NOTE: Teoricamente se uitlizaria el @Autowired para inyectar dependencias, donde se instancia por si solo la clase que se necesita, pero se recomienda utilizar el constructor para eso, ya que el @Service no es va a instanciar
    private final AdministradorTeatroRepo administradorTeatroRepo;

    public AdministradorTeatroServicioImp(AdministradorTeatroRepo administradorTeatroRepo) {
        this.administradorTeatroRepo = administradorTeatroRepo;
    }

    @Override
    public AdministradorTeatro login(String correo, String password) throws Exception {

        Optional<AdministradorTeatro> administrador = administradorTeatroRepo.comprobarAutenticacion(correo, password);

        if (!administrador.isPresent()){
            throw new Exception("Los datos de autenticación son incorrectos");
        }

        return  administrador.get();
    }

    @Override
    public AdministradorTeatro registrar(AdministradorTeatro administrador) throws Exception {
        
        boolean correoExiste = correoRepetido(administrador.getCorreo());

        if (correoExiste) {
            throw new Exception("Este correo ya esta registrado");
        }

        /* StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
        administrador.setPassword(spe.encryptPassword(administrador.getPassword())); */
        AdministradorTeatro registro = administradorTeatroRepo.save(administrador);

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

        Optional<AdministradorTeatro> administrador = administradorTeatroRepo.findByCorreo(correo);
        return administrador.isPresent();
    }

    @Override
    public AdministradorTeatro actualizar(AdministradorTeatro administrador) throws Exception {

        Optional<AdministradorTeatro> actualizado = administradorTeatroRepo.findById(administrador.getCedula());

        if (actualizado.isEmpty()) {
            throw new Exception("El administrador no existe");
        }

        return administradorTeatroRepo.save(administrador);
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

        Optional<AdministradorTeatro> eliminado = administradorTeatroRepo.findById(cedula);

        if (eliminado.isEmpty()) {
            throw new Exception("El administrador no existe");
        }
        
        administradorTeatroRepo.delete(eliminado.get());
    }

    @Override
    public AdministradorTeatro obtener(Integer cedula) throws Exception {

        if (cedula == null) {
            throw new Exception("Es necesario la cedula del usuario");
        }

        Integer length = (int) (Math.log10(cedula) + 1);    // Calculo para obtener la longitud de la cedula
        
        if (length > 10 || length < 7) {
            throw new Exception("La cedula no puede tener más de diez digitos, ni menos de siete"); 
        }

        Optional <AdministradorTeatro> buscado = administradorTeatroRepo.findById(cedula);
        
        if (buscado.isEmpty()) {
            throw new Exception("El administrador no existe");
        }

        return buscado.get();
    }

    @Override
    public List<AdministradorTeatro> listar() {

        return administradorTeatroRepo.findAll();
    }

}
