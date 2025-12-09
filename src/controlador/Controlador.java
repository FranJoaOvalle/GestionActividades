package controlador;

import modelo.AdultoMayor;
import modelo.GestionActividades;
import modelo.GestionAdultosMayores;
import modelo.GestionInscripcion;
import utils.Validadores;
import vista.VistaPrincipal;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class Controlador {
    GestionAdultosMayores gestionAdultosMayores;
    GestionActividades gestionActividades;
    GestionInscripcion gestionInscripcion;
    VistaPrincipal vistaPrincipal;
    private String rutSeleccionado;

    public Controlador(GestionAdultosMayores gestionAdultosMayores, GestionActividades gestionActividades, GestionInscripcion gestionInscripcion, VistaPrincipal vistaPrincipal) {
        this.gestionAdultosMayores = gestionAdultosMayores;
        this.gestionActividades = gestionActividades;
        this.gestionInscripcion = gestionInscripcion;
        this.vistaPrincipal = vistaPrincipal;
        configurarSeleccionTabla();
    }

    public void botones(){
        this.vistaPrincipal.btnAdultoGuardar.addActionListener(e -> this.agregarAdultoMayor());
        this.vistaPrincipal.btnAdultoLimpiar.addActionListener(e -> this.limpiarFormularioAdultoMayor());
        this.vistaPrincipal.btnAdultoListar.addActionListener(e -> this.listarAdultosMayores());
        this.vistaPrincipal.btnAdultoEliminar.addActionListener(e -> eliminarAdultoMayor(rutSeleccionado));
        this.vistaPrincipal.btnAdultoEditar.addActionListener(e -> actualizarAdultoMayor(rutSeleccionado));

    }

    private void agregarAdultoMayor(){
        String rut = this.vistaPrincipal.txtAdultoRut.getText();
        if(!utils.Validadores.validarRUT(rut)){
            vista.PopUps.ERROR("Rut Invalido: ",new Exception("El rut ingresado no es valido."));
            this.vistaPrincipal.txtAdultoRut.setText("");
            this.vistaPrincipal.txtAdultoRut.requestFocus();
            return;
        }

        String nombre = this.vistaPrincipal.txtAdultoNombre.getText();
        if(nombre == null || nombre.isEmpty()){
            vista.PopUps.ERROR("Nombre Invalido: ",new Exception("El nombre ingresado no es valido."));
            this.vistaPrincipal.txtAdultoNombre.setText("");
            this.vistaPrincipal.txtAdultoNombre.requestFocus();
            return;
        }

        String apellido = this.vistaPrincipal.txtAdultoApellido.getText();
        if(apellido == null || apellido.trim().isEmpty()){
            vista.PopUps.ERROR("Apellido Invalido: ", new Exception("El apellido ingresado no es valido."));
            this.vistaPrincipal.txtAdultoApellido.setText("");
            this.vistaPrincipal.txtAdultoApellido.requestFocus();
            return;
        }

        String nacimiento = this.vistaPrincipal.txtAdultoNacimiento.getText();
        if(!Validadores.validarFecha(nacimiento)){
            vista.PopUps.ERROR("Fecha Nacimiento Invalido: ", new Exception("La fecha de nacimiento ingresada no es valida."));
            this.vistaPrincipal.txtAdultoNacimiento.setText("");
            this.vistaPrincipal.txtAdultoNacimiento.requestFocus();
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd-MM-uuuu")
                .withResolverStyle(ResolverStyle.STRICT);

        LocalDate nacimiento2 = LocalDate.parse(nacimiento, formatter);

        String encargado = this.vistaPrincipal.txtAdultoEncargado.getText();
        if(encargado == null || encargado.trim().isEmpty()){
            vista.PopUps.ERROR("Nombre Encargado Invalido: ", new Exception("El nombre del encargado ingresado no es valido."));
            this.vistaPrincipal.txtAdultoEncargado.setText("");
            this.vistaPrincipal.txtAdultoEncargado.requestFocus();
            return;
        }

        String contactoEncargado = this.vistaPrincipal.txtAdultoFono.getText();
        if(contactoEncargado == null || contactoEncargado.trim().isEmpty()){
            vista.PopUps.ERROR("Fono Encargado Invalido: ", new Exception("El fono del encargado imgresado no es valido."));
            this.vistaPrincipal.txtAdultoFono.setText("");
            this.vistaPrincipal.txtAdultoFono.requestFocus();
            return;
        }

        this.gestionAdultosMayores.agregarAdultoMayor(new AdultoMayor(rut,nombre,apellido,nacimiento2,encargado,contactoEncargado));
        vista.PopUps.GENERICO("Adulto Mayor ingresado con exito.","Adulto Mayor Valido");
        this.limpiarFormularioAdultoMayor();
    }

    private void limpiarFormularioAdultoMayor(){
        this.vistaPrincipal.txtAdultoRut.setText("");
        vistaPrincipal.txtAdultoRut.setEditable(true);
        this.vistaPrincipal.txtAdultoNombre.setText("");
        this.vistaPrincipal.txtAdultoApellido.setText("");
        this.vistaPrincipal.txtAdultoNacimiento.setText("");
        this.vistaPrincipal.txtAdultoEncargado.setText("");
        this.vistaPrincipal.txtAdultoFono.setText("");
        this.vistaPrincipal.txtAdultoRut.requestFocus();
    }

    private void listarAdultosMayores(){
        DefaultTableModel m = (DefaultTableModel) this.vistaPrincipal.tablaAdultos.getModel();
        m.setNumRows(0);
        for(AdultoMayor a: this.gestionAdultosMayores.getAdultosMayores()){
            String fechaFormateada = a.getNacimiento().format(utils.Fechas.DATE_CL);
            m.addRow(new Object[] {a.getRut(),a.getNombreAdultoMayor(),a.getApellidoAdultoMayor(),fechaFormateada,a.getNombreEncargado(),a.getContactoEncargado()});
        }
    }

    private void configurarSeleccionTabla() {

        this.vistaPrincipal.tablaAdultos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){

                int fila = vistaPrincipal.tablaAdultos.getSelectedRow();

                if(fila == -1){
                    return;
                }

                rutSeleccionado = vistaPrincipal.tablaAdultos.getValueAt(fila, 0).toString();

                if(e.getClickCount() == 1){
                    return;
                }

                if(e.getClickCount() == 2) {

                    AdultoMayor adulto = gestionAdultosMayores.buscarAdultoMayorPorRut(rutSeleccionado);

                    if(adulto != null) {
                        String fechaFormateada = adulto.getNacimiento().format(utils.Fechas.DATE_CL);
                        vistaPrincipal.txtAdultoRut.setText(adulto.getRut());
                        vistaPrincipal.txtAdultoNombre.setText(adulto.getNombreAdultoMayor());
                        vistaPrincipal.txtAdultoApellido.setText(adulto.getApellidoAdultoMayor());
                        vistaPrincipal.txtAdultoNacimiento.setText(fechaFormateada);
                        vistaPrincipal.txtAdultoEncargado.setText(adulto.getNombreEncargado());
                        vistaPrincipal.txtAdultoFono.setText(adulto.getContactoEncargado());

                        vistaPrincipal.txtAdultoRut.setEditable(false);
                    }
                }
            }
        });
    }

    private void eliminarAdultoMayor(String rut){
        AdultoMayor adulto = gestionAdultosMayores.buscarAdultoMayorPorRut(rut);
        gestionAdultosMayores.eliminarAdultoMayor(adulto);
        listarAdultosMayores();
    }

    private void actualizarAdultoMayor(String rut){
        String nombre = this.vistaPrincipal.txtAdultoNombre.getText();
        if(nombre == null || nombre.isEmpty()){
            vista.PopUps.ERROR("Nombre Invalido: ",new Exception("El nombre ingresado no es valido."));
            this.vistaPrincipal.txtAdultoNombre.setText("");
            this.vistaPrincipal.txtAdultoNombre.requestFocus();
            return;
        }

        String apellido = this.vistaPrincipal.txtAdultoApellido.getText();
        if(apellido == null || apellido.trim().isEmpty()){
            vista.PopUps.ERROR("Apellido Invalido: ", new Exception("El apellido ingresado no es valido."));
            this.vistaPrincipal.txtAdultoApellido.setText("");
            this.vistaPrincipal.txtAdultoApellido.requestFocus();
            return;
        }

        String nacimiento = this.vistaPrincipal.txtAdultoNacimiento.getText();
        if(!Validadores.validarFecha(nacimiento)){
            vista.PopUps.ERROR("Fecha Nacimiento Invalido: ", new Exception("La fecha de nacimiento ingresada no es valida."));
            this.vistaPrincipal.txtAdultoNacimiento.setText("");
            this.vistaPrincipal.txtAdultoNacimiento.requestFocus();
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd-MM-uuuu")
                .withResolverStyle(ResolverStyle.STRICT);

        LocalDate nacimiento2 = LocalDate.parse(nacimiento, formatter);

        String encargado = this.vistaPrincipal.txtAdultoEncargado.getText();
        if(encargado == null || encargado.trim().isEmpty()){
            vista.PopUps.ERROR("Nombre Encargado Invalido: ", new Exception("El nombre del encargado ingresado no es valido."));
            this.vistaPrincipal.txtAdultoEncargado.setText("");
            this.vistaPrincipal.txtAdultoEncargado.requestFocus();
            return;
        }

        String contactoEncargado = this.vistaPrincipal.txtAdultoFono.getText();
        if(contactoEncargado == null || contactoEncargado.trim().isEmpty()){
            vista.PopUps.ERROR("Fono Encargado Invalido: ", new Exception("El fono del encargado imgresado no es valido."));
            this.vistaPrincipal.txtAdultoFono.setText("");
            this.vistaPrincipal.txtAdultoFono.requestFocus();
            return;
        }

        AdultoMayor antiguosDatos = gestionAdultosMayores.buscarAdultoMayorPorRut(rut);
        AdultoMayor nuevosDatos = new AdultoMayor(rut,nombre,apellido,nacimiento2,encargado,contactoEncargado);
        if(gestionAdultosMayores.actualizarAdultoMayor(antiguosDatos,nuevosDatos)){
            vista.PopUps.GENERICO("Adulto Mayor Actualizado con exito.", "Exito");
        }
        listarAdultosMayores();
    }
}
