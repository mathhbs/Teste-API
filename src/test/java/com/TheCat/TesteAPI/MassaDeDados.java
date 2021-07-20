package com.TheCat.TesteAPI;

public class MassaDeDados {
	
	String vote_id;
	String urlCadastro = "user/passwordlesssignup";
	String corpoCadastro = "{\"email\": \"mat_henrique@hotmail.com\", \"appDescription\": \"Teste the cat api\"}";
	
	String corpoVotacao = "{\"image_id\": \"LobaTEke-\", \"value\": \"true\", \"sub_id\": \"demo-cc31b3\"}";
	String corpoFavorita = "{ \"image_id\": \"2uo\"}";
	String corpoDesfavorita = "favourites/{favourite_id}";
}
