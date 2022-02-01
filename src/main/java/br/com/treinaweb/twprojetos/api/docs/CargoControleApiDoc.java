package br.com.treinaweb.twprojetos.api.docs;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import br.com.treinaweb.twprojetos.api.anotacoes.ApiPageable;
import br.com.treinaweb.twprojetos.api.dto.CargoDTO;
import br.com.treinaweb.twprojetos.api.excessoes.ApiErro;
import br.com.treinaweb.twprojetos.api.excessoes.ValidacaoApiErro;
import br.com.treinaweb.twprojetos.entidades.Cargo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags= "Cargos", description = "Cargo Controller")
public interface CargoControleApiDoc {

    @ApiOperation(value = "Listar todos os cargos")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Listagem dos cargos realizada com sucesso")
    })
    @ApiPageable
    CollectionModel<EntityModel<Cargo>> buscarTodos(@ApiIgnore Pageable paginacao);
   
    @ApiOperation(value = "Buscar cargo por ID")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Cargo localizado com sucesso"),
        @ApiResponse(code = 404, message = "Cargo não localizado", response = ApiErro.class)
    })
    EntityModel<Cargo> buscarPorId(Long id);

    @ApiOperation(value = "Cadastrar cargo")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Cargo cadastrado com sucesso"),
        @ApiResponse(code = 400, message = "Houveram erros de validação", response = ValidacaoApiErro.class)
    })
    EntityModel<Cargo> cadastrar(CargoDTO cargoDTO);

    @ApiOperation(value = "Atualizar cargo")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Cargo atualizado com sucesso"),
        @ApiResponse(code = 400, message = "Houveram erros de validação", response = ValidacaoApiErro.class),
        @ApiResponse(code = 404, message = "Cargo não localizado", response = ApiErro.class)
    })
    EntityModel<Cargo> atualizar(CargoDTO cargoDTO, Long id);

    @ApiOperation(value = "Excluir cargo por ID")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Cargo excluido com sucesso"),
        @ApiResponse(code = 404, message = "Cargo não localizado", response = ApiErro.class)
    })
    ResponseEntity<?> excluirPorId(Long id);
    

}
