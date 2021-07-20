package com.TheCat.TesteAPI;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class TesteApi extends MassaDeDados {

	@BeforeClass
	public static void urlbase() {
		RestAssured.baseURI = "https://api.thecatapi.com/v1/";
	}

	@Test
	public void cadastro() {

		Response response = given().contentType("application/json").body(corpoCadastro).when().post(urlCadastro);

		validacao(response);
	}

	@Test
	public void votacao() {

		Response response = given().contentType("application/json").body(corpoVotacao).when().post("votes/");

		validacao(response);
		String id = response.jsonPath().getString("id");
		vote_id = id;
		System.out.println("ID => " + id);
	}

	@Test
	public void deletaVotacao() {
		votacao();
		deletaVoto();

	}

	private void deletaVoto() {

		Response response = given().contentType("application/json")
				.header("x-api-key", "862efcda-b465-4be0-b848-618c92ba9142").pathParam("vote_id", vote_id).when()
				.delete("votes/{vote_id}");

		validacao(response);
	}

	@Test
	public void favoritaDesfavorita() {
		favorita();
		desfavorita();
	}

	private void favorita() {

		Response response = given().contentType("application/json")
				.header("x-api-key", "862efcda-b465-4be0-b848-618c92ba9142").body(corpoFavorita).when()
				.post("favourites");
		String id = response.jsonPath().getString("id");
		vote_id = id;

		validacao(response);
	}

	private void desfavorita() {
		Response response = given().contentType("application/json")
				.header("x-api-key", "862efcda-b465-4be0-b848-618c92ba9142").pathParam("favourite_id", vote_id).when()
				.delete(corpoDesfavorita);

		validacao(response);
	}

	public void validacao(Response response) {
		response.then().statusCode(200);
		System.out.println("RETORNO DA API => " + response.body().asString());
		System.out.println("-----------------------------------------------");
	}

}
