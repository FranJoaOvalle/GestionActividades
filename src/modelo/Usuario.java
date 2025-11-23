package modelo;

public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String username;
    private boolean esAdministrador;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String username, boolean esAdministrador) {
        this.setIdUsuario(idUsuario);
        this.setNombreUsuario(nombreUsuario);
        this.setUsername(username);
        this.setEsAdministrador(esAdministrador);
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEsAdministrador(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAdministrador() {
        return esAdministrador;
    }
}
