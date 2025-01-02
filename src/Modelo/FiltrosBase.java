
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marvin
 */
public abstract class FiltrosBase<T> {
    protected List<String> filtros;
    protected List<Object> parametros;
    
    public FiltrosBase()
    {
        filtros = new ArrayList<>();
        parametros = new ArrayList<>();
    }
    
    public abstract List<T> ejecutarConsulta();

    public void agregarFiltro(String campo, Object valor) {
        if (valor != null && !valor.toString().isEmpty()) {
            filtros.add(campo + " LIKE ?");
            parametros.add("%" + valor + "%");
        }
    }

    public String construirConsultaBase(String consultaBase) {
        if (!filtros.isEmpty()) {
            consultaBase += " WHERE " + String.join(" AND ", filtros);
        }
        return consultaBase;
    }
}
