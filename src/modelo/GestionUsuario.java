package modelo;

import java.util.ArrayList;

public class GestionUsuario {
    private ArrayList<Usuario> usuarios;

    public GestionUsuario(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario buscarUsuarioPorId(int id){
        for(Usuario u: usuarios){
            if(u.getIdUsuario() == id){
                return u;
            }
        }
        return null;
    }

    public boolean agregarUsuario(Usuario usuario){
        if(buscarUsuarioPorId(usuario.getIdUsuario()) != null){
            return false;
        }
        usuarios.add(usuario);
        return true;
    }

    public boolean eliminarUsuario(Usuario usuario){
        Usuario u = buscarUsuarioPorId(usuario.getIdUsuario());
        if(u == null){
            return false;
        }
        usuarios.remove(u);
        return true;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
