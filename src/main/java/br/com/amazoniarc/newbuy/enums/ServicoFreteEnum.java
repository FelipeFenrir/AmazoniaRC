package br.com.amazoniarc.newbuy.enums;

import static java.util.Arrays.asList;

import java.util.List;

/**
 * Enum para emular o serviço de Frete dos Correios.
 * @author felipe.batista
 */
public enum ServicoFreteEnum {
    PAC_SEM_CONTRATO(asList("04510")),
    PAC_COM_CONTRATO(asList("41068", "04669")),
    PAC_PARA_GRANCES_FORMATOS(asList("41300")),
    SEDEX_SEM_CONTRATO(asList("04014")),
    SEDEX_A_COBRAR_SEM_CONTRATO(asList("40045")),
    SEDEX_A_COBRAR_COM_CONTRATO(asList("40126")),
    SEDEX_10_SEM_CONTRATO(asList("40215")),
    SEDEX_HOJE_SEM_CONTRATO(asList("40290")),
    SEDEX_COM_CONTRATO(asList("40096", "40436", "40444", "40568", "40606", "04162")),
    ESEDEX_COM_CONTRATO(asList("81019")),
    ESEDEX_PRIORITARIO_COM_CONTRATO(asList("81027")),
    ESEDEX_EXPRESS_COM_CONTRATO(asList("81035")),
    GRUPO_1_ESEDEX_COM_CONTRATO(asList("81868")),
    GRUPO_2_ESEDEX_COM_CONTRATO(asList("81833")),
    GRUPO_3_ESEDEX_COM_CONTRATO(asList("81850"));

    private final List<String> codigo;

    /**
     * Construtor.
     * @param codigo
     */
    ServicoFreteEnum(List<String> codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtem o código do serviço de frete.
     * @return Lista de Códigos.
     */
    public List<String> getCodigo() {
        return codigo;
    }
}
