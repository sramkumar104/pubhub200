

<nav class="navbar navbar-default navbar-fixed">
	<div class="container-fluid">
		<div class="navbar-header">

			<a class="navbar-brand" href="home.jsp"><span
				class="glyphicon glyphicon-home">&nbsp;PubHub</span></a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-left">


			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> Admin <span class="caret"></span>
				</a>
					
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">
						<p>
							<%out.print(session.getAttribute("log_user")); %> <b class="caret"></b>
						</p>
						<ul class="dropdown-menu">
						<li><a href="auth/logout">Log out</a></li>
				</a>
					
				<li class="separator hidden-lg hidden-md"></li>
			</ul>
		</div>
	</div>
</nav>