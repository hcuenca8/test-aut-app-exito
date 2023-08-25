package com.exito.app.test.automation.e2e.utils.gherkin.tabla.utils;


import com.exito.app.test.automation.e2e.utils.formatos.FormatoUtil;
import com.exito.app.test.automation.e2e.utils.gherkin.tabla.interfaces.ITablaGherkin;
import com.exito.app.test.automation.e2e.utils.models.params.interfaces.IParam;
import com.exito.app.test.automation.e2e.constants.enums.tablasgherkin.TablasGherkin;
import com.exito.app.test.automation.e2e.models.scena.screenplay.Protagonista;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TablaGherkinUtil
{
    private Map<String, String> tblGherkin;

    private Set<String> lstTblGherkin;

    private static final String ID_CAMPO_NULL = "%[NULL]%";

    private TablaGherkinUtil(Map<String, String> tblGherkin)
    {
        this.tblGherkin = tblGherkin;
        this.lstTblGherkin = this.tblGherkin.keySet();
    }

    public static TablaGherkinUtil deLaTabla(Map<String, String> tblGherkin){
        return new TablaGherkinUtil(tblGherkin);
    }

    public String obtener(ITablaGherkin<? extends IParam> columnaTablaGherkin)
    {
        return this.validarFormato(this.tblGherkin,columnaTablaGherkin.getColumna());
    }

    private String validarFormato(Map<String, String> tblGherkin, String columnaTablaGherkin)
    {
        String valorFormateado;

        //valorFormateado = StringUtils.trimToEmpty(tblGherkin.get(columnaTablaGherkin))
        valorFormateado = tblGherkin.get(columnaTablaGherkin);

        if(   valorFormateado!=null )
        {
            String patron = "\\{'(.+)'\\}";
            Matcher matcher = Pattern.compile(patron).matcher(valorFormateado);
            if  (   matcher.find() )
            {
                valorFormateado = this.validarFormato(tblGherkin,matcher.group(1));
            }else{
                valorFormateado = FormatoUtil.validar(valorFormateado);
            }
        }

        if( valorFormateado == null )
        {
            valorFormateado = ID_CAMPO_NULL;
        }

        Protagonista.principal().getTblGherkin().put(columnaTablaGherkin,valorFormateado);
        this.lstTblGherkin.remove(columnaTablaGherkin);

        return valorFormateado;
    }

    public void cruzarCon(Map<String, ITablaGherkin<?>> tblsGherkin)
    {
        ITablaGherkin<?> colTblGherkinEncontrada;

        //for    String columna : this.lstTblGherkin
        while(!this.lstTblGherkin.isEmpty())
        {
            String columna = this.lstTblGherkin.iterator().next();
            if  (   (colTblGherkinEncontrada = tblsGherkin.get(columna)) ==null )
            {
                /**
                 * lanzar exception
                 * parametro de tabla gherkin no mapeado
                 */
                throw new UnsupportedOperationException();
            }else{
                colTblGherkinEncontrada.crearScreen(this);
            }
        }
    }

    public static void cargarTablasGherkin(Map<String, ITablaGherkin<?>> tblsGherkin)
    {
        for (   TablasGherkin tblGherkinResumen : TablasGherkin.values()   )
        {
            for (   ITablaGherkin<?> tblGherkin : tblGherkinResumen.getTablaGherkin()  )
            {
                if  (tblsGherkin.containsKey(tblGherkin.getColumna())  )
                {
                    /**
                     * Lanzar exception
                     * parametro de tabla gherkin repetido
                     * tblGherkin.getColumna()
                     * this.tblsGherkin.get(tblGherkin.getColumna()).classname
                     */
                    throw new UnsupportedOperationException();
                }else{
                    tblsGherkin.put(tblGherkin.getColumna(), tblGherkin);
                }
            }
        }
    }

    public static boolean campoNull(Object valorCampo)
    {
        return ID_CAMPO_NULL.equals(valorCampo);
    }

    public static boolean campoNoNull(Object valorCampo)
    {
        return !ID_CAMPO_NULL.equals(valorCampo);
    }

}
