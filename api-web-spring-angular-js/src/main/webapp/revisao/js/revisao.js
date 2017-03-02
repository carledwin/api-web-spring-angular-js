countContato = 0;

		function exibirNome(){
			//variavel local
			var x= 10;
			z = "tudo bem";
		/*variaveis globais
			x = 10;
			x="Texto";
			x={"Objeto"};
			x=["vetor"];
		*/

			var elNome = document.getElementById("nome");
			//document.write(el_nome.value);
			
			var elDisplay = document.getElementById("display");
			elDisplay.innerText =  elNome.value;

			/*
			var elDisplay2 = document.getElementById("display2");
			elDisplay2.innerHTML = "<p style = 'color:red'>" + elDisplay.innerText + "</p>";

			console.log(elDisplay2);
			console.log(elNome.value);
			*/

		}

		function imprimirDados(){
			//var elementosForm = document.getElementById("formCadastro");	
			var arrContatos = document.forms.formCadastro.txt_contato;
			var elResultado2 = document.getElementById("resultado");
			var elBr = document.createElement("br");
			var elH3Contato = document.createElement("h3");
				
				elResultado2.innerText = "";
				
			if(arrContatos != null){
				elH3Contato.setAttribute("style", "color:blue");
				elH3Contato.innerText = "Lista de contatos";

				for( indexContato=0; indexContato < arrContatos.length; indexContato++){
					//window.alert("Contato: " + arrContatos[indexContato].value);
					
					var elNovoSpan = document.createElement("span");
					
					var elLabel2 = document.createElement("label");

					elLabel2.innerText = arrContatos[indexContato].value;
					elNovoSpan.appendChild(elLabel2);
					elResultado2.appendChild(elBr);
					elResultado2.appendChild(elNovoSpan);

				} 

			}else{
					elH3Contato.setAttribute("style", "color:red");
					elH3Contato.innerText = "Nenhum contato registrado.";
				}

				elResultado2.appendChild(elH3Contato);
				elH3Contato.appendChild(elBr);

			
		}

		function salvar(){
			var elListaContatos2 = document.getElementById("listaContatos");
			var elFormCadastro = document.getElementById("formCadastro");
			var elFormChildInputNome = elFormCadastro;
			var elResultado = document.getElementById("resultado");
			var elTituloResultado = document.createElement("h3");
			var elNome2 = document.getElementById("nome");

			elTituloResultado.innerText = elNome2.value;

			elResultado.innerText = "";
			
			elResultado.appendChild(elTituloResultado);
			
		}

		function adicionarNovoContato(){

			var elListaContatos = document.getElementById("listaContatos");
			var elLinhaContato = document.createElement("span");
			var labelContato = document.createElement("label")
			var inputContato = document.createElement("input");
			var brContato = document.createElement("br");
			var inputButton = document.createElement("input");
			
			countContato ++;

			labelContato.innerText = "Contato " + countContato + ": ";
			
			inputContato.setAttribute("id", "input_"+countContato);
			inputContato.setAttribute("name", "txt_contato");
			
			inputButton.setAttribute("type","button");
			inputButton.setAttribute("value", "-");
			//inputButton.setAttribute("onclick", "removerContato()");
			//inputButton.onclick = removerContato();
			//inputButton.onclick = removerContato;
			//ponteiro para function/propriedade que faz referencia a uma function
			inputButton.onclick = 	function(){
										elListaContatos.removeChild(elLinhaContato);
									};

			elLinhaContato.appendChild(labelContato);
			elLinhaContato.appendChild(inputContato);
			elLinhaContato.appendChild(inputButton);
			elLinhaContato.appendChild(brContato);

			elListaContatos.appendChild(elLinhaContato);
		}

		/*function removerContato(){
			window.alert("Deseja realmente excluir o contato?");
			//console.log("removido");
		}*/

		//load da pagina imprime o texto
		//exibirNome();
		//document.write("Oi " + z + "?");