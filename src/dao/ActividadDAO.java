package dao;

import db.Conexion;
import modelo.Actividad;
import utils.Fechas;
import vista.PopUps;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ActividadDAO implements ISimpleDAO<Actividad, Integer> {
    @Override
    public void create(Actividad a) {
        final String query =
                "INSERT INTO Actividad (id_actividad, nombre, categoria, descripcion, dia, hora_inicio, hora_fin, cupos, nombre_profesor)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(query))
        {
            ps.setInt(1, a.getIdActividad());
            ps.setString(2, a.getNombreActividad());
            ps.setString(3, a.getCategoria());
            ps.setString(4, a.getDescripcion());
            ps.setInt(5, a.getDia().getValue());
            ps.setInt(6, Fechas.localTimeAMinutos(a.getHoraInicio()));
            ps.setInt(7, Fechas.localTimeAMinutos(a.getHoraFin()));
            ps.setInt(8, a.getCupos());
            ps.setString(9, a.getNombreProfesor());

            ps.executeUpdate();
        }
        catch (SQLException e) {
            PopUps.ERROR("Error al ejecutar query: ", e);
        }
    }

    @Override
    public Actividad readOne(Integer idQuery) {
        Actividad a = null;
        final String query = "SELECT * FROM Actividad WHERE id_actividad = ?";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(query))
        {
            ps.setInt(1, idQuery);
            try (ResultSet rs = ps.executeQuery())
            {
                if (rs.next())
                    a = mapActividad(rs);
            }
        }
        catch (SQLException e) {
            PopUps.ERROR("Error al ejecutar query: ", e);
        }
        return a;
    }

    @Override
    public List<Actividad> readAll() {
        ArrayList<Actividad> lista = new ArrayList<>();
        final String query = "SELECT * FROM Actividad";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(query))
        {
            try (ResultSet rs = ps.executeQuery())
            {
                while (rs.next())
                    lista.add(mapActividad(rs));
            }
        }
        catch (SQLException e) {
            PopUps.ERROR("Error al ejecutar query: ", e);
        }
        return lista;
    }

    @Override
    public List<Actividad> readBy(String filtro) {
        PopUps.SIN_IMPLEMENTAR();
        return null;
    }

    @Override
    public void update(Actividad a) {
        final String query =
                "UPDATE Actividad SET nombre = ?, categoria = ?, descripcion = ?, dia = ?, hora_inicio = ?, hora_fin = ?, cupos = ?, nombre_profesor = ? " +
                        "WHERE id_actividad = ?";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(query))
        {
            ps.setString(1, a.getNombreActividad());
            ps.setString(2, a.getCategoria());
            ps.setString(3, a.getDescripcion());
            ps.setInt(4, a.getDia().getValue());
            ps.setInt(5, Fechas.localTimeAMinutos(a.getHoraInicio()));
            ps.setInt(6, Fechas.localTimeAMinutos(a.getHoraFin()));
            ps.setInt(7, a.getCupos());
            ps.setString(8, a.getNombreProfesor());
            ps.setInt(9, a.getIdActividad());

            ps.executeUpdate();
        }
        catch (SQLException e) {
            PopUps.ERROR("Error al ejecutar query: ", e);
        }
    }

    @Override
    public void delete(Integer idQuery) {
        final String query = "DELETE FROM Actividad WHERE id_actividad = ?";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(query))
        {
            ps.setInt(1, idQuery);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            PopUps.ERROR("Error al ejecutar query: ", e);
        }
    }

    private Actividad mapActividad(ResultSet rs) throws SQLException
    {
        int idActividad = rs.getInt("id_actividad");
        String nombre = rs.getString("nombre");
        String categoria = rs.getString("categoria");
        String descripcion = rs.getString("descripcion");
        DayOfWeek dia = DayOfWeek.of(rs.getInt("dia"));
        LocalTime horaInicio = Fechas.minutosALocalTime(rs.getInt("hora_inicio"));
        LocalTime horaFin = Fechas.minutosALocalTime(rs.getInt("hora_fin"));
        int cupos = rs.getInt("cupos");
        String nombreProfesor = rs.getString("nombre_profesor");

        return new Actividad(idActividad, nombre, categoria, descripcion, dia,  horaInicio, horaFin, cupos, nombreProfesor);
    }
}
