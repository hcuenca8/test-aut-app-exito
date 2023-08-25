package com.exito.app.test.automation.e2e.questions.general.app.pantalla;

import com.exito.app.test.automation.e2e.questions.javadoc.QuestionsJavaDoc;
import com.exito.app.test.automation.e2e.userinterfaces.general.app.pantalla.ContenidoAppUI;
import com.exito.app.test.automation.e2e.utils.questions.estadoelementos.constants.enums.EstadoElemento;
import com.exito.app.test.automation.e2e.utils.questions.estadoelementos.questions.ElEstado;
import com.exito.app.test.automation.e2e.utils.userinterfaces.app.interfaces.IUserInterface;
import lombok.Builder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Para mas informacion:
 * @see QuestionsJavaDoc#CLASE
 */
@Builder
public class SeObservaTexto implements Question<Boolean>
{

    //private String textos;
    private List<String> textos;

    private EstadoElemento este;

    private boolean exacto;

    private static final String INDICADOR_TEXTO_EXACTO = "\\|";

    private static final String RGX_INDICADOR_TEXTO_EXACTO = "(^\\\\"+INDICADOR_TEXTO_EXACTO+")|(\\\\"+INDICADOR_TEXTO_EXACTO+"$)";

    /**
     * Para mas informacion:
     * @see QuestionsJavaDoc#ANSWERED_BY
     */
    @Override
    public Boolean answeredBy(Actor actor)
    {
        /**
         * Para mas informacion:
         * @see QuestionsJavaDoc#ENLAZAR_VALIDACIONES_VERIFICACIONES
         */

        /*char chrPrimerCaracter = this.textos.charAt(0);
        String strPrimerCaracter = String.valueOf(chrPrimerCaracter);

        String separador = Character.isLetterOrDigit(chrPrimerCaracter)
            || strPrimerCaracter.equals(this.INDICADOR_TEXTO_EXACTO)
                ? null
                : Pattern.quote(strPrimerCaracter);

        String[] textos = separador==null
            ?   new String[]{this.textos}
            :   this.textos.split(separador)
            ;
        */

        boolean resultado = true;

        for(String validarTexto : this.textos)
        {
            if( validarTexto!=null &&  !validarTexto.isEmpty()  )
            {
                IUserInterface lblTexto;
                boolean fueXIndicadorTextoExacto;
                if( (fueXIndicadorTextoExacto =
                        (   validarTexto.startsWith(this.INDICADOR_TEXTO_EXACTO)
                            && validarTexto.endsWith(this.INDICADOR_TEXTO_EXACTO)
                        )
                    ) || this.exacto
                ){
                    if(fueXIndicadorTextoExacto){
                        validarTexto = validarTexto.replaceAll(RGX_INDICADOR_TEXTO_EXACTO,StringUtils.EMPTY);
                    }

                    lblTexto = ContenidoAppUI.LBL_TEXTO_EXACTO;
                }else{
                    lblTexto = ContenidoAppUI.LBL_TEXTO;
                }

                if( !ElEstado.deLosElementos(
                        lblTexto.getTarget(validarTexto)
                    ).sea(this.este)
                    .answeredBy(actor)
                ) {
                    resultado = false;
                    break;
                }
            }
        }

        return resultado;
    }

    /**
     * Para mas informacion:
     * @see QuestionsJavaDoc#ENLACE
     */
    public static SeObservaTexto enPantalla(EstadoElemento este, boolean exacto,String texto)
    {
        char chrPrimerCaracter = texto.charAt(0);
        String strPrimerCaracter = String.valueOf(chrPrimerCaracter);

        String separador = Character.isLetterOrDigit(chrPrimerCaracter)
            || strPrimerCaracter.equals(INDICADOR_TEXTO_EXACTO)
            ? null
            : Pattern.quote(strPrimerCaracter);

        List<String> textos = separador==null
            ?   Arrays.asList(texto)
            :   Arrays.asList(texto.split(separador))
            ;

        return SeObservaTexto.builder()
                .este(este)
                .textos(textos)
                .exacto(exacto)
                .build();
    }

    public static SeObservaTexto enPantalla(EstadoElemento este, boolean exacto, String ... textos)
    {
        return SeObservaTexto.builder()
            .este(este)
            .textos(Arrays.asList(textos))
            .exacto(exacto)
            .build();
    }
}
