function MostrarFormulario() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
       document.getElementById("Ajax").innerHTML = this.responseText;
      }
    };
    xhttp.open("GET", "Formulario.txt", true);
    xhttp.send();
  }

  function MostrarFormulario2(){
    $.get('FUNCIONACTM',function(responseText){
      $('#Ajax').html(responseText);
      });
    }
  function ListarClientes(){
	  $.get('BaseDatos', function(responseText){
		  console.log(responseText);
		  $('#Servlet').html(responseText);
	  });
  }
  function CRUD(opcion){
    var rut = $('#rut1').val();
    var nombre = $('#nom').val();
    var comuna = $('#id_comuna').val();

    switch(opcion){
      case 1:
        var opt = "InsertCliente";
        console.log("InsertCliente");
        console.log($('#crud').val())
        $.post('CRUD',{dataSet:opt,dataSet2:nombre,dataSet3:rut,dataSet4:comuna},function(responseText){
        $('#InfoAqui').html(responseText)});
        break;
      case 2:
          var opt = "ActualizarCliente"
        	  console.log("update cliente js");
          console.log($('#crud').val())
          $.post('CRUD',{dataSet:opt,dataSet2:nombre,dataSet3:rut,dataSet4:comuna}, function(responseText){
            $('#InfoAqui').html(responseText);});
          break;
      case 3:
        var opt = "EliminarCliente";
        console.log("delete cliente js");
        console.log($('#crud').val())
        $.post('CRUD',{dataSet:opt,dataSet2:rut}, function(responseText){
          $('#InfoAqui').html(responseText)});
        break;
      case 4 :
    	  var opt = "MostrarCliente";
    	  console.log("Cliente js");
          $.post('CRUD',{dataSet:opt,dataSet2:rut}, function(responseText){
              $('#InfoAqui').html(responseText)});
            break;
      case 5 :
          var opt ="MostrarTodos";
          console.log("TODOS js")
          $.post('CRUD',{dataSet:opt},function(responseText){
            $('#InfoAqui').html(responseText)
          });
          break; 
	}
}

function mostrarLogin(){
document.write('<div id="myModal" class="modal fade" role="dialog">')
document.write('  <div class="modal-dialog">')
document.write('    <div class="modal-content">')
document.write('      <div class="modal-header">')
document.write('        <button type="button" class="close" data-dismiss="modal">&times;</button>')
document.write('        <h4 class="modal-title">Modal Header</h4>')
document.write('      </div>')
document.write('      <div class="modal-body">')
document.write('        <p>Some text in the modal.</p>')
document.write('      </div>')
document.write('      <div class="modal-footer">')
document.write('        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>')
document.write('      </div>')
document.write('    </div>')
document.write('  </div>')
document.write('</div>')
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
}


/*function mostrarNav(){
    document.write('<nav class="navbar navbar-inverse ">')
    document.write('<div class="container-fluid ">')
    document.write('<div class="navbar-header ">')
    document.write('<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">')
    document.write('<span class="icon-bar"></span>')
    document.write('<span class="icon-bar"></span>')
    document.write('<span class="icon-bar"></span>')                      
    document.write('</button>')
    document.write('<a class="navbar-brand" href="Main.html">Swimming Power</a>')
    document.write('</div>')
    document.write('<div class="collapse navbar-collapse" id="myNavbar">')
    document.write('<ul class="nav navbar-nav">')
    document.write('<li class="active"><a href="Main.html">Home</a></li>')
    document.write('<li class="dropdown">')
    document.write('<a class="dropdown-toggle" data-toggle="dropdown" href="#">La Natación<span class="caret"></span></a>')
    document.write('<ul class="dropdown-menu">')
    document.write('<li><a href="#"La Natación</a></li>')
    document.write('<li><a href="#">Beneficios</a></li>')
    document.write('<li><a href="SobreNosotros.html">Sobre nosotros</a></li>')
    document.write('</ul>')
    document.write('</li>')
    document.write('<li><a href="#">Sobre la Entrendora</a></li>')
    document.write('<li><a href="AudioVisual.html">AudioVisual</a></li>')
    document.write('</ul>')
    document.write('<ul class="nav navbar-nav navbar-right">')
    document.write('<li><a href="BaseDeDatos.html">Postular<span class="glyphicon glyphicon-user"></span></a></li>')
    document.write('<li><a href="Postulacion.html">Login<span class="glyphicon glyphicon-log-in"></span></a></li>')
    document.write('</ul>')
    document.write('</div>')
    document.write('</div>')
    document.write('</nav>')
    // Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
}*/
/*function Servlet(){
  	$.post('CRUD2') 
	}
function CRUD2(opcion){
	var rut = $('#rut1').val();
	var nombre = $('#nom').val();
	var comuna = $('#id_comuna').val();

	switch(opcion){
	  case 1:
		var opt = "InsertCliente";
		console.log("InsertCliente");
		console.log($('#crud').val())
		$.post('CRUD',{dataSet:opt,dataSet2:nombre,dataSet3:rut,dataSet4:comuna},function(responseText){
		$('#InfoAqui').html(responseText)});
		break;
	  case 2:
		  var opt = "ActualizarCliente"
			  console.log("update cliente js");
		  console.log($('#crud').val())
		  $.post('CRUD',{dataSet:opt,dataSet2:nombre,dataSet3:rut,dataSet4:comuna}, function(responseText){
			$('#InfoAqui').html(responseText);});
		  break;
	  case 3:
		var opt = "EliminarCliente";
		console.log("delete cliente js");
		console.log($('#crud').val())
		$.post('CRUD',{dataSet:opt,dataSet2:rut}, function(responseText){
		  $('#InfoAqui').html(responseText)});
		break;
	  case 4 :
		  var opt = "MostrarCliente";
		  console.log("Cliente js");
		  $.post('CRUD',{dataSet:opt,dataSet2:rut}, function(responseText){
			  $('#InfoAqui').html(responseText)});
			break;
	  case 5 :
		  var opt ="MostrarTodos";
		  console.log("TODOS js")
		  $.post('CRUD2',{dataSet:opt},function(responseText){
		  });
		  break; 
	}
}*/
      
   
    	
      
        
