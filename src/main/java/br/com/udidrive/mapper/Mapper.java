package br.com.udidrive.mapper;

import br.com.udidrive.model.*;
import br.com.udidrive.vo.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Mapper {
    private static ModelMapper mapper = new ModelMapper();
    //private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    static{
        mapper.createTypeMap(Avaliacao.class, AvaliacaoVO.class).addMapping(Avaliacao::getIdAvaliacao, AvaliacaoVO::setIdAvaliacao);
        mapper.createTypeMap(AvaliacaoVO.class, Avaliacao.class).addMapping(AvaliacaoVO::getIdAvaliacao, Avaliacao::setIdAvaliacao);

        mapper.createTypeMap(Carteira.class, CarteiraVO.class).addMappings(mapper -> {
            mapper.map(Carteira::getIdCarteira, CarteiraVO::setIdCarteira);
            mapper.map(src -> src.getUsuario().getIdUsuario(), CarteiraVO::setUsuarioId);
        });

        mapper.createTypeMap(CarteiraVO.class, Carteira.class).addMappings(mapper -> {
            mapper.map(CarteiraVO::getIdCarteira, Carteira::setIdCarteira);
        });

        mapper.createTypeMap(Cliente.class, ClienteVO.class).addMapping(Cliente::getIdCliente, ClienteVO::setIdCliente);
        mapper.createTypeMap(ClienteVO.class, Cliente.class).addMapping(ClienteVO::getIdCliente, Cliente::setIdCliente);

        mapper.createTypeMap(Endereco.class, EnderecoVO.class).addMapping(Endereco::getIdEndereco, EnderecoVO::setIdEndereco);
        mapper.createTypeMap(EnderecoVO.class, Endereco.class).addMapping(EnderecoVO::getIdEndereco, Endereco::setIdEndereco);

        mapper.createTypeMap(EntidadeTipo.class, EntidadeTipoVO.class).addMapping(EntidadeTipo::getIdTipo, EntidadeTipoVO::setIdEntidade);
        mapper.createTypeMap(EntidadeTipoVO.class, EntidadeTipo.class).addMapping(EntidadeTipoVO::getIdEntidade, EntidadeTipo::setIdTipo);

        mapper.createTypeMap(Foto.class, FotoVO.class).addMapping(Foto::getIdFoto, FotoVO::setIdFoto);
        mapper.createTypeMap(FotoVO.class, Foto.class).addMapping(FotoVO::getIdFoto, Foto::setIdFoto);

        mapper.createTypeMap(FreteAdicional.class, FreteAdicionalVO.class).addMapping(FreteAdicional::getIdFrete, FreteAdicionalVO::setIdFrete);
        mapper.createTypeMap(FreteAdicionalVO.class, FreteAdicional.class).addMapping(FreteAdicionalVO::getIdFrete, FreteAdicional::setIdFrete);

        mapper.createTypeMap(ItemEntrega.class, ItemEntregaVO.class).addMapping(ItemEntrega::getIdItem, ItemEntregaVO::setIdItem);
        mapper.createTypeMap(ItemEntregaVO.class, ItemEntrega.class).addMapping(ItemEntregaVO::getIdItem, ItemEntrega::setIdItem);

        mapper.createTypeMap(Motorista.class, MotoristaVO.class).addMapping(Motorista::getIdMotorista, MotoristaVO::setIdMotorista);
        mapper.createTypeMap(MotoristaVO.class, Motorista.class).addMapping(MotoristaVO::getIdMotorista, Motorista::setIdMotorista);

        mapper.createTypeMap(Pagamento.class, PagamentoVO.class).addMapping(Pagamento::getIdPagamento, PagamentoVO::setIdPagamento);
        mapper.createTypeMap(PagamentoVO.class, Pagamento.class).addMapping(PagamentoVO::getIdPagamento, Pagamento::setIdPagamento);

        mapper.createTypeMap(Pedido.class, PedidoVO.class).addMapping(Pedido::getIdPedido, PedidoVO::setIdPedido);
        mapper.createTypeMap(PedidoVO.class, Pedido.class).addMapping(PedidoVO::getIdPedido, Pedido::setIdPedido);

        mapper.createTypeMap(Rastreamento.class, RastreamentoVO.class).addMapping(Rastreamento::getIdRastreamento, RastreamentoVO::setIdRastreamento);
        mapper.createTypeMap(RastreamentoVO.class, Rastreamento.class).addMapping(RastreamentoVO::getIdRastreamento, Rastreamento::setIdRastreamento);

        mapper.createTypeMap(Suporte.class, SuporteVO.class).addMapping(Suporte::getIdTicket, SuporteVO::setIdTicket);
        mapper.createTypeMap(SuporteVO.class, Suporte.class).addMapping(SuporteVO::getIdTicket, Suporte::setIdTicket);

        mapper.createTypeMap(Tarifa.class, TarifaVO.class).addMapping(Tarifa::getIdTarifa, TarifaVO::setIdTarifa);
        mapper.createTypeMap(TarifaVO.class, Tarifa.class).addMapping(TarifaVO::getIdTarifa, Tarifa::setIdTarifa);

        mapper.createTypeMap(Usuario.class, UsuarioVO.class).addMapping(Usuario::getIdUsuario, UsuarioVO::setIdUsuario);
        mapper.createTypeMap(UsuarioVO.class, Usuario.class).addMapping(UsuarioVO::getIdUsuario, Usuario::setIdUsuario);

        mapper.createTypeMap(Veiculo.class, VeiculoVO.class).addMapping(Veiculo::getIdVeiculo, VeiculoVO::setIdVeiculo);
        mapper.createTypeMap(VeiculoVO.class, Veiculo.class).addMapping(VeiculoVO::getIdVeiculo, Veiculo::setIdVeiculo);
    }

    public static <O,D> D parseObject(O origin, Class<D> destination){
        return mapper.map(origin,destination);
    }

    public static <O,D> List<D> parseListObject(List<O> origin, Class<D> destination){
        List<D> destinationObjects = new ArrayList<D>();
        for (O o : origin){
            destinationObjects.add(mapper.map(o, destination));
        }
        return destinationObjects;
    }
}
