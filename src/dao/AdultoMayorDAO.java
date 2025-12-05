package dao;

import db.Conexion;
import modelo.AdultoMayor;
import utils.Fechas;
import vista.PopUps;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdultoMayorDAO implements ISimpleDAO<AdultoMayor, String> {
    @Override
    public void create(AdultoMayor a) {
        final String query =
                "INSERT INTO AdultoMayor (rut, nombre, apellido, fecha_nacimiento, nombre_encargado, fono_encargado) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(query))
        {
            ps.setString(1, a.getRut());
            ps.setString(2, a.getNombreAdultoMayor());
            ps.setString(3, a.getApellidoAdultoMayor());
            ps.setLong(4, Fechas.localDateAUnix(a.getNacimiento()));
            ps.setString(5, a.getNombreEncargado());
            ps.setString(6, a.getContactoEncargado());

            ps.executeUpdate();
        }
        catch (SQLException e) {
            PopUps.ERROR("Error al ejecutar query: ", e);
        }
    }


    @Override
    public AdultoMayor readOne(String rutQuery) {
        AdultoMayor a = null;
        final String query = "SELECT * FROM AdultoMayor WHERE rut = ?";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(query))
        {
            ps.setString(1, rutQuery);
            try (ResultSet rs = ps.executeQuery())
            {
                if (rs.next())
                    a = mapAdultoMayor(rs);
            }
        }
        catch (SQLException e) {
            PopUps.ERROR("Error al ejecutar query: ", e);
        }
        return a;
    }

    @Override
    public List<AdultoMayor> readAll() {
        ArrayList<AdultoMayor> lista = new ArrayList<>();
        final String query = "SELECT * FROM AdultoMayor";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(query))
        {
            try (ResultSet rs = ps.executeQuery())
            {
                while (rs.next())
                    lista.add(mapAdultoMayor(rs));
            }
        }
        catch (SQLException e) {
            PopUps.ERROR("Error al ejecutar query: ", e);
        }
        return lista;
    }

    @Override
    public List<AdultoMayor> readBy(String filtro) {
        PopUps.SIN_IMPLEMENTAR();
        return null;
    }

    @Override
    public void update(AdultoMayor a) {
        final String query = "UPDATE AdultoMayor SET nombre = ?, apellido = ?, fecha_nacimiento = ?, nombre_encargado = ?, fono_encargado = ? WHERE rut = ?";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(query))
        {
            ps.setString(1, a.getNombreAdultoMayor());
            ps.setString(2, a.getApellidoAdultoMayor());
            ps.setLong(3, Fechas.localDateAUnix(a.getNacimiento()));
            ps.setString(4, a.getNombreEncargado());
            ps.setString(5, a.getContactoEncargado());
            ps.setString(6, a.getRut());
            ps.executeUpdate();
        }
        catch (SQLException e) {
            PopUps.ERROR("Error al ejecutar query: ", e);
        }
    }

    @Override
    public void delete(String rutQuery) {
        final String query = "DELETE FROM AdultoMayor WHERE rut = ?";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(query))
        {
            ps.setString(1, rutQuery);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            PopUps.ERROR("Error al ejecutar query: ", e);
        }
    }

    private AdultoMayor mapAdultoMayor(ResultSet rs) throws SQLException
    {
        String rut = rs.getString("rut");
        String nombreAdultoMayor = rs.getString("nombre");
        String apellidoAdultoMayor = rs.getString("apellido");
        LocalDate fechaNacimiento = Fechas.unixALocalDate(rs.getLong("fecha_nacimiento"));
        String nombreEncargado = rs.getString("nombre_encargado");
        String contactoEncargado = rs.getString("fono_encargado");

        return new AdultoMayor(rut, nombreAdultoMayor, apellidoAdultoMayor, fechaNacimiento, nombreEncargado, contactoEncargado);
    }
}
