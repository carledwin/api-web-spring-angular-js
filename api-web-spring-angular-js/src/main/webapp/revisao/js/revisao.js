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