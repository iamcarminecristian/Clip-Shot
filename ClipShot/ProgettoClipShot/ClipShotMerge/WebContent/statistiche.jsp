<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	 <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.css'>
	<link rel="stylesheet" type="text/css" href="css/styleStatistiche.css">
	<link rel="stylesheet" type="text/css" href="css/popup.css">
</head>
<body>
	<div class="conteiner">
		<div class="grafico">
			
		</div>
		<div class="lista-foto">
			<div class="foto">
				<div class="img-foto">
					<ul class="inline-popups">
    					<a href="#test-popup3" data-effect="mfp-zoom-in"><img src="img/tokyo.jpg" width="256px" height="256px"></a>
  					</ul>
				</div>
			</div>
			
		</div>
	</div>

	<div id="test-popup3<%=i%>" class="white-popup mfp-with-anim mfp-hide">
		<div class="pci">
			<div class="sopra">
				<div class="foto-stat">
					<img src="img/tokyo.jpg" width="128px" height="128px">
				</div>
				<div class="acquisti">
					<p>Acquisti:</p><br>
					<p>7</p>
				</div>
			</div>
			<div class="sotto">
				<div class="descrizione">
				<p>Descrizione:</p><br>
				<p>roba a caso</p>
			</div>
			<div class="like">
				<p>Like:</p><br>
				<p>6</p>
			</div>
			</div>	
			
		</div>
			
	</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js'></script>

  

    <script  src="js/index.js"></script>
</body>
</html>