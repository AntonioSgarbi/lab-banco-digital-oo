//package tech.antoniosgarbi.desafiobanco.factory;
//
//import org.springframework.stereotype.Component;
//import tech.antoniosgarbi.desafiobanco.exception.ContaNaoInformada;
//import tech.antoniosgarbi.desafiobanco.model.enums.ContaTipo;
//import tech.antoniosgarbi.desafiobanco.service.contract.IConta;
//import tech.antoniosgarbi.desafiobanco.service.impl.ContaCorrenteService;
//import tech.antoniosgarbi.desafiobanco.service.impl.ContaPoupancaService;
//
//@Component
//public class ContaServiceFactory {
//    private final ContaPoupancaService contaPoupancaService;
//    private final ContaCorrenteService contaCorrenteService;
//
//    public ContaServiceFactory(ContaPoupancaService contaPoupancaService, ContaCorrenteService contaCorrenteService) {
//        this.contaPoupancaService = contaPoupancaService;
//        this.contaCorrenteService = contaCorrenteService;
//    }
//
//    public IConta getContaService(ContaTipo contaTipo) {
//        if(contaTipo == ContaTipo.POUPANCA)
//            return contaPoupancaService;
//        else if(contaTipo == ContaTipo.CORRENTE)
//            return contaCorrenteService;
//        throw new ContaNaoInformada("Escolha um tipo de conta para executar esta ação");
//    }
//}
