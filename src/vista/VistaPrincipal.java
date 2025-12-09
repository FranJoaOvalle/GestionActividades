package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel; 
import java.awt.*;

public class VistaPrincipal extends JFrame {

    // Componentes para Adultos Mayores
    public JTextField txtAdultoRut, txtAdultoNombre, txtAdultoApellido, txtAdultoNacimiento, txtAdultoEncargado, txtAdultoFono;
    public JTextField txtAdultoBuscar;
    public JButton btnAdultoGuardar, btnAdultoEditar, btnAdultoEliminar, btnAdultoLimpiar, btnAdultoBuscar, btnAdultoListar;
    public JTable tablaAdultos;
    public DefaultTableModel modeloAdultos;

    // Componentes para Actividades
    public JTextField txtActividadNombre, txtActividadCategoria, txtActividadDescripcion, txtActividadDia, txtActividadHoraInicio, txtActividadHoraFin, txtActividadCupos, txtActividadInstructor;
    public JTextField txtActividadBuscar;
    public JButton btnActividadGuardar, btnActividadEditar, btnActividadEliminar, btnActividadLimpiar, btnActividadBuscar, btnActividadListar;
    public JTable tablaActividades;
    public DefaultTableModel modeloActividades;

    // Componentes para Inscripciones
    public JComboBox<String> cbxInscripcionAdulto; 
    public JComboBox<String> cbxInscripcionActividad;
    public JButton btnInscribir;         
    public JButton btnCancelarInscripcion; 
    
    // Filtros de Inscripciones
    public JRadioButton radVerInscritosActividad;
    public JRadioButton radVerActividadesPersona;
    public JRadioButton radVerInscritosDia; 
    public JButton btnConsultarInscripciones;
    
    public JTable tablaInscripciones;
    public DefaultTableModel modeloInscripciones;

    public VistaPrincipal() {
        super("Gestión Centro Adulto Mayor");
        setSize(1200, 750); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        iniciarUI();
    }

    private void iniciarUI() {
        setLayout(new BorderLayout());
        
        // Título principal
        JLabel lblTitulo = new JLabel("Sistema de Gestión Integral", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setBorder(new EmptyBorder(15, 0, 15, 0));
        add(lblTitulo, BorderLayout.NORTH);

        // Pestañas
        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        tabs.addTab("Adultos Mayores", panelAdultos());
        tabs.addTab("Actividades", panelActividades());
        tabs.addTab("Inscripciones", panelInscripciones());

        add(tabs, BorderLayout.CENTER);
    }

    // --- Pestaña 1: Adultos Mayores ---
    private JPanel panelAdultos() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));



        // Formulario
        JPanel form = new JPanel(new GridLayout(3, 4, 10, 10));
        form.setBorder(bordeTitulo("Datos Personales"));

        txtAdultoRut = new JTextField(); 
        txtAdultoNombre = new JTextField();
        txtAdultoApellido = new JTextField();
        txtAdultoNacimiento = new JTextField(); 
        txtAdultoNacimiento.setToolTipText("dd-MM-yyyy");
        txtAdultoEncargado = new JTextField();
        txtAdultoFono = new JTextField();

        form.add(new JLabel("RUT:")); form.add(txtAdultoRut);
        form.add(new JLabel("Nombre:")); form.add(txtAdultoNombre);
        form.add(new JLabel("Apellido:")); form.add(txtAdultoApellido);
        form.add(new JLabel("Nacimiento:")); form.add(txtAdultoNacimiento);
        form.add(new JLabel("Encargado:")); form.add(txtAdultoEncargado);
        form.add(new JLabel("Fono Encargado:")); form.add(txtAdultoFono);

        panel.add(form, BorderLayout.NORTH);

        // Botones y Tabla
        JPanel centro = new JPanel(new BorderLayout(5, 5));
        
        // Botones de acción
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAdultoGuardar = new JButton("Guardar");
        btnAdultoEditar = new JButton("Editar");
        btnAdultoEliminar = new JButton("Eliminar"); 
        btnAdultoLimpiar = new JButton("Limpiar");
        
        estiloBoton(btnAdultoGuardar, new Color(40, 167, 69), Color.WHITE);
        estiloBoton(btnAdultoEliminar, new Color(220, 53, 69), Color.WHITE);

        acciones.add(btnAdultoGuardar);
        acciones.add(btnAdultoEditar);
        acciones.add(btnAdultoLimpiar);
        
        // Panel Barra Inferior
        JPanel panelBarra = new JPanel(new BorderLayout());

        JLabel lblAyuda = new JLabel("Haga doble click en una fila para editar");
        lblAyuda.setForeground(Color.GRAY);
        lblAyuda.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        lblAyuda.setBorder(new EmptyBorder(0, 5, 0, 0)); 
        
        JPanel buscar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        txtAdultoBuscar = new JTextField(15);
        btnAdultoBuscar = new JButton("Buscar");
        btnAdultoListar = new JButton("Ver todo"); 
        
        buscar.add(new JLabel("Buscar:"));
        buscar.add(txtAdultoBuscar);
        buscar.add(btnAdultoBuscar);
        buscar.add(btnAdultoListar);

        panelBarra.add(lblAyuda, BorderLayout.WEST);
        panelBarra.add(buscar, BorderLayout.EAST);

        JPanel panelBotones = new JPanel(new BorderLayout());
        panelBotones.add(acciones, BorderLayout.CENTER);
        panelBotones.add(panelBarra, BorderLayout.SOUTH);

        centro.add(panelBotones, BorderLayout.NORTH);

        // Tabla
        modeloAdultos = new DefaultTableModel();
        modeloAdultos.addColumn("RUT"); 
        modeloAdultos.addColumn("Nombre"); 
        modeloAdultos.addColumn("Apellido");
        modeloAdultos.addColumn("Nacimiento"); 
        modeloAdultos.addColumn("Encargado");
        modeloAdultos.addColumn("Fono"); 
        
        tablaAdultos = new JTable(modeloAdultos);
        tablaAdultos.setDefaultEditor(Object.class, null);
        centro.add(new JScrollPane(tablaAdultos), BorderLayout.CENTER);

        // Botón Eliminar
        JPanel sur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAdultoEliminar = new JButton("Eliminar");
        estiloBoton(btnAdultoEliminar, new Color(220, 53, 69), Color.WHITE);
        
        sur.add(new JLabel("<html><i>Seleccione una fila para borrar:</i></html>"));
        sur.add(btnAdultoEliminar);
        
        centro.add(sur, BorderLayout.SOUTH);

        panel.add(centro, BorderLayout.CENTER);
        return panel;
    }

    // --- Pestaña 2: Actividades ---
    private JPanel panelActividades() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Formulario
        JPanel form = new JPanel(new GridLayout(4, 4, 10, 10));
        form.setBorder(bordeTitulo("Info Actividad"));

        txtActividadNombre = new JTextField();
        txtActividadCategoria = new JTextField(); 
        txtActividadDescripcion = new JTextField(); 
        txtActividadDia = new JTextField();
        txtActividadHoraInicio = new JTextField(); 
        txtActividadHoraFin = new JTextField();    
        txtActividadCupos = new JTextField();
        txtActividadInstructor = new JTextField();

        // Fila 1
        form.add(new JLabel("Nombre:")); form.add(txtActividadNombre);
        form.add(new JLabel("Categoría:")); form.add(txtActividadCategoria); 
        
        // Fila 2
        form.add(new JLabel("Descripción:")); form.add(txtActividadDescripcion);
        form.add(new JLabel("Día:")); form.add(txtActividadDia);
        
        // Fila 3
        form.add(new JLabel("Hora Inicio:")); form.add(txtActividadHoraInicio);
        form.add(new JLabel("Hora Fin:")); form.add(txtActividadHoraFin);
        
        // Fila 4
        form.add(new JLabel("Cupos:")); form.add(txtActividadCupos);
        form.add(new JLabel("Instructor:")); form.add(txtActividadInstructor);

        panel.add(form, BorderLayout.NORTH);

        // Botones
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnActividadGuardar = new JButton("Guardar Actividad");
        estiloBoton(btnActividadGuardar, new Color(0, 123, 255), Color.WHITE);
        
        btnActividadEditar = new JButton("Modificar");
        btnActividadLimpiar = new JButton("Limpiar");
        
        acciones.add(btnActividadGuardar);
        acciones.add(btnActividadEditar);
        acciones.add(btnActividadLimpiar);

        // Barra Inferior
        JPanel panelBarra = new JPanel(new BorderLayout());

        JLabel lblAyuda = new JLabel("Haga doble click en una fila para editar");
        lblAyuda.setForeground(Color.GRAY);
        lblAyuda.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        lblAyuda.setBorder(new EmptyBorder(0, 5, 0, 0)); 

        JPanel buscar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        txtActividadBuscar = new JTextField(15);
        btnActividadBuscar = new JButton("Buscar");
        btnActividadListar = new JButton("Ver todo"); 
        
        buscar.add(new JLabel("Buscar:"));
        buscar.add(txtActividadBuscar);
        buscar.add(btnActividadBuscar);
        buscar.add(btnActividadListar);

        panelBarra.add(lblAyuda, BorderLayout.WEST);
        panelBarra.add(buscar, BorderLayout.EAST);

        JPanel panelSup = new JPanel(new BorderLayout());
        panelSup.add(acciones, BorderLayout.CENTER);
        panelSup.add(panelBarra, BorderLayout.SOUTH);
        
        JPanel centro = new JPanel(new BorderLayout());
        centro.add(panelSup, BorderLayout.NORTH);

        // Tabla
        modeloActividades = new DefaultTableModel();
        modeloActividades.addColumn("ID");          
        modeloActividades.addColumn("Actividad");   
        modeloActividades.addColumn("Categoría");   
        modeloActividades.addColumn("Descripción"); 
        modeloActividades.addColumn("Día");         
        modeloActividades.addColumn("Inicio");      
        modeloActividades.addColumn("Fin");         
        modeloActividades.addColumn("Instructor");  
        modeloActividades.addColumn("Cupos");       

        tablaActividades = new JTable(modeloActividades);
        
        // Ajuste de columnas
        TableColumnModel cm = tablaActividades.getColumnModel();
        cm.getColumn(0).setPreferredWidth(30); 
        cm.getColumn(4).setPreferredWidth(60); 
        cm.getColumn(8).setPreferredWidth(50); 
        
        centro.add(new JScrollPane(tablaActividades), BorderLayout.CENTER);

        // Botón Eliminar
        JPanel sur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnActividadEliminar = new JButton("Eliminar");
        estiloBoton(btnActividadEliminar, new Color(220, 53, 69), Color.WHITE);
        
        sur.add(new JLabel("<html><i>Seleccione una fila para borrar:</i></html>"));
        sur.add(btnActividadEliminar);
        
        centro.add(sur, BorderLayout.SOUTH);

        panel.add(centro, BorderLayout.CENTER);
        return panel;
    }

    // --- Pestaña 3: Inscripciones ---
    private JPanel panelInscripciones() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Formulario de inscripción
        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(bordeTitulo("Nueva Inscripción"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Adulto
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        form.add(new JLabel("Adulto Mayor:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 0; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        cbxInscripcionAdulto = new JComboBox<>();
        form.add(cbxInscripcionAdulto, gbc);

        // Actividad
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0; gbc.anchor = GridBagConstraints.EAST;
        form.add(new JLabel("Actividad:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        cbxInscripcionActividad = new JComboBox<>();
        form.add(cbxInscripcionActividad, gbc);

        // Botón Inscribir
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.NONE; gbc.anchor = GridBagConstraints.CENTER;
        btnInscribir = new JButton("Confirmar Inscripción");
        estiloBoton(btnInscribir, new Color(40, 167, 69), Color.WHITE);
        btnInscribir.setPreferredSize(new Dimension(200, 35)); 
        form.add(btnInscribir, gbc);

        panel.add(form, BorderLayout.NORTH);

        // Listado y Consultas
        JPanel centro = new JPanel(new BorderLayout(5, 5));
        centro.setBorder(bordeTitulo("Listado de Inscritos"));

        // Filtros
        JPanel filtros = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup grupo = new ButtonGroup();
        radVerInscritosActividad = new JRadioButton("Ver por Actividad", true); 
        radVerActividadesPersona = new JRadioButton("Ver por Persona");
        radVerInscritosDia = new JRadioButton("Ver por Día"); 
        
        grupo.add(radVerInscritosActividad);
        grupo.add(radVerActividadesPersona);
        grupo.add(radVerInscritosDia);
        
        btnConsultarInscripciones = new JButton("Consultar");
        
        filtros.add(radVerInscritosActividad);
        filtros.add(radVerActividadesPersona);
        filtros.add(radVerInscritosDia);
        filtros.add(btnConsultarInscripciones);
        
        centro.add(filtros, BorderLayout.NORTH);

        // Tabla
        modeloInscripciones = new DefaultTableModel();
        modeloInscripciones.addColumn("ID");          
        modeloInscripciones.addColumn("Actividad"); 
        modeloInscripciones.addColumn("Participante");
        modeloInscripciones.addColumn("Día");       
        
        tablaInscripciones = new JTable(modeloInscripciones);
        
        // Ajuste de columna ID
        TableColumnModel cm = tablaInscripciones.getColumnModel();
        cm.getColumn(0).setPreferredWidth(30); 
        
        centro.add(new JScrollPane(tablaInscripciones), BorderLayout.CENTER);

        // Botón Eliminar
        JPanel sur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnCancelarInscripcion = new JButton("Eliminar"); 
        estiloBoton(btnCancelarInscripcion, new Color(220, 53, 69), Color.WHITE);
        
        sur.add(new JLabel("<html><i>Seleccione en la tabla para borrar:</i></html>"));
        sur.add(btnCancelarInscripcion);
        
        centro.add(sur, BorderLayout.SOUTH);

        panel.add(centro, BorderLayout.CENTER);
        return panel;
    }

    // Helpers    
    private TitledBorder bordeTitulo(String titulo) {
        return BorderFactory.createTitledBorder(null, titulo, TitledBorder.DEFAULT_JUSTIFICATION, 
                TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", Font.BOLD, 12));
    }

    private void estiloBoton(JButton btn, Color fondo, Color texto) {
        btn.setBackground(fondo);
        btn.setForeground(texto);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
    }
}