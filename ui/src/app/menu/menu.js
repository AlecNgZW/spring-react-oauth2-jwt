import React from "react";
import Link from "react-router/lib/Link";

import NavItem from "../bootstrap/item";
import AuthMenu from "./auth";

const Menu = props => (
	<nav className="navbar navbar-default navbar-fixed-top">
		<div className="container">
			<div className="navbar-header">
				<Link className="navbar-brand" to="/">App</Link>
			</div>
			<div className="collapse navbar-collapse">
				<ul className="nav navbar-nav">
					<NavItem to="foo">Foo</NavItem>
					<NavItem to="bar">Bar</NavItem>
				</ul>
				<AuthMenu/>
			</div>
		</div>
	</nav>
);

export default Menu;