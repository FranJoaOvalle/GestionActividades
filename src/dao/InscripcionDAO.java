package dao;

import db.Conexion;
import modelo.Actividad;
import modelo.AdultoMayor;
import modelo.Inscripcion;
import vista.PopUps;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InscripcionDAO implements ISimpleDAO<Inscripcion, Integer> {
    @Override
    public void create(Inscripcion i) {
        final String query = "INSERT INTO Inscripcion (id_inscripcion, rut_adulto, id_actividad) VALUES (?, ?, ?)";
        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(query))
        {
            ps.setInt(1, i.getIdInscripcion());
            ps.setString(2, i.getAdultoMayor().getRut());
            ps.setInt(3, i.getActividad().getIdActividad());
            ps.executeUpdate();
        }
        catch (SQLException e) {
            PopUps.ERROR("Error al ejecutar query: ", e);
        }
    }

    @Override
    public Inscripcion readOne(Integer idQuery) {
        Inscripcion i = null;
        final String query = "SELECT * FROM Inscripcion WHERE id_inscripcion = ?";
        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(query))
        {
            ps.setInt(1, idQuery);
            try (ResultSet rs = ps.executeQuery())
            {
                if (rs.next())
                    i = mapInscripcion(rs);
            }
        }
        catch (SQLException e) {
            PopUps.ERROR("Error al ejecutar query: ", e);
        }
        return i;
    }

    @Override
    public List<Inscripcion> readAll() {
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        final String query = "SELECT * FROM Inscripcion";
        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(query))
        {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next())
                    inscripciones.add(mapInscripcion(rs));
            }
        }
        catch (SQLException e) {
            PopUps.ERROR("Error al ejecutar query: ", e);
        }
        return inscripciones;
    }

    @Override
    public List<Inscripcion> readBy(String filtro) {
        PopUps.SIN_IMPLEMENTAR();
        return null;
    }

    @Override
    public void update(Inscripcion i) {
        final String query = "UPDATE Inscripcion SET rut_adulto = ?, id_actividad = ? WHERE id_inscripcion = ?";
        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(query))
        {
            ps.setString(1, i.getAdultoMayor().getRut());
            ps.setInt(2, i.getActividad().getIdActividad());
            ps.setInt(3, i.getIdInscripcion());
            ps.executeUpdate();
        }
        catch (SQLException e) {
            PopUps.ERROR("Error al ejecutar query: ", e);
        }
    }

    @Override
    public void delete(Integer idQuery) {
        final String query = "DELETE FROM Inscripcion WHERE id_inscripcion = ?";
        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(query))
        {
            ps.setInt(1, idQuery);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            PopUps.ERROR("Error al ejecutar query: ", e);
        }
    }

    private Inscripcion mapInscripcion(ResultSet rs) throws SQLException
    {
        int idInscripcion = rs.getInt("id_inscripcion");
        String rutAdulto = rs.getString("rut_adulto");
        int idActividad = rs.getInt("id_actividad");

        AdultoMayor adulto = new AdultoMayorDAO().readOne(rutAdulto);
        Actividad actividad = new ActividadDAO().readOne(idActividad);

        return new Inscripcion(idInscripcion, adulto, actividad);
    }

}
